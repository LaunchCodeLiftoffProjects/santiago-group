package com.recipeproject.recipeproject.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipeproject.recipeproject.models.*;
import com.recipeproject.recipeproject.models.data.*;
import com.recipeproject.recipeproject.models.dto.IngredientResponseDTO;
import com.recipeproject.recipeproject.models.dto.IngredientsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.persistence.criteria.CriteriaBuilder;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AddFromWeb {
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private RecipeStepRepository recipeStepRepository;
    @Autowired
    private JunctionRepository junctionRepository;


    public String saveDPtoRecipe(DataParser dataParser, Model model){
        Recipe newRecipe = new Recipe();
        List<Instructions> instructList= new ArrayList<>();
        List<IngredientParser> ingList = new ArrayList<>();
        List<String> stepList = new ArrayList<>();

        newRecipe.setName(dataParser.getName());
        newRecipe.setDescription(dataParser.getDescription());
        newRecipe.setCook_time(dataParser.getCook_time());
        newRecipe.setYield(dataParser.getYield());
        newRecipe.setTotal_time(dataParser.getTotal_time());


        recipeRepository.save(newRecipe);

        instructList = dataParser.getInstructions();
        Instructions instructions = instructList.get(0);
        stepList = instructions.getSteps();

        int i = 1;
        for (String step : stepList
             ) {
            RecipeStep stepHold = new RecipeStep();
            stepHold.setStepNumber(i);
            stepHold.setStepDescription(step);
            stepHold.setRecipeId(newRecipe.getRecipeId());
            i++;
            recipeStepRepository.save(stepHold);



        }
        ingList = getIngredientInfo(dataParser);

       List<Ingredient> ingredients = new ArrayList<>();
        for (IngredientParser ingredientParser: ingList) {
            IngApi ingApi = ingredientParser.getIngredientParsed();
            Ingredient ingredient = new Ingredient();
            ingredient.setName(ingApi.getProduct());
            ingredients.add(ingredient);
            if(!ingredientRepository.existsByName(ingredient.getName())) {
                ingredientRepository.save(ingredient);
            }

            Junction newRow = new Junction(newRecipe, ingredient, ingApi.getUnit(), ingApi.getQuantity(), ingApi.getPreparationNotes());
            junctionRepository.save(newRow);


        }
        newRecipe.setIngredientList(ingredients);

        return "success";
    }


    public List<IngredientParser> getIngredientInfo(DataParser dataParser){
        List<String> ingredients = dataParser.getIngredients();
        IngredientsDTO ingredientsDTO = new IngredientsDTO();
        ingredientsDTO.setIngredients(dataParser.getIngredients());
        String ingredientsString = "";
        try {
          ingredientsString = new ObjectMapper().writeValueAsString(ingredientsDTO);
        }
        catch(Exception e){


        }

        RestTemplate restTemplate = new RestTemplate();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://zestful.p.rapidapi.com/parseIngredients"))
                .header("Content-Type", "application/json")
                .header("x-rapidapi-host", "zestful.p.rapidapi.com")
                .header("x-rapidapi-key", "e353e864a1msh21955970eb647ecp1b206fjsn1f74a04a741f")
                .method("POST", HttpRequest.BodyPublishers.ofString(ingredientsString))
                .build();
        String response;

        IngredientResponseDTO ingredientResponseDTO = new IngredientResponseDTO();
        try {
            HttpResponse<String> apiResponse = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(apiResponse.body());
            response = apiResponse.body();
            ObjectMapper objectMapper = new ObjectMapper();
             ingredientResponseDTO = objectMapper.readValue(response, IngredientResponseDTO.class);
        }
        catch (Exception e){
            response = "shits fucked";
        }
        List<Ingredient> ingredients1 = new ArrayList<>();

        return ingredientResponseDTO.getResults();


    }
}
