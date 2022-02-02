package com.recipeproject.recipeproject.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipeproject.recipeproject.models.*;
import com.recipeproject.recipeproject.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class addFromWeb {
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
        List<Ingredient> ingList = new ArrayList<>();
        List<String> stepList = new ArrayList<>();

        newRecipe.setName(dataParser.getName());
        newRecipe.setDescription(dataParser.getDescription());
        newRecipe.setCook_time(dataParser.getCook_time());
        newRecipe.setYield(dataParser.getYield());
        newRecipe.setTotal_time(dataParser.getTotal_time());
        newRecipe.setCook_time(dataParser.getCook_time());

        recipeRepository.save(newRecipe);

        instructList = dataParser.getInstructions();
        if(instructList.size() == 1) {
            for (Instructions instructions : instructList) {
                stepList = instructions.getSteps();
            }
        }

        for (String step : stepList
             ) {
            Character a = step.charAt(0);
            Integer stepNum = Character.getNumericValue(a);
            RecipeStep stepHold = new RecipeStep(stepNum,step.substring(2) );
            recipeStepRepository.save(stepHold);


        }
        ingList = getIngredientInfo(dataParser);
        newRecipe.setIngredientList(ingList);
        for (Ingredient ingredient: ingList) {
            Junction newRow = new Junction(newRecipe, ingredient, ingredient.getMeasurement(), ingredient.getAmount(), ingredient.getPrepNotes());
            junctionRepository.save(newRow);

            if (!ingredientRepository.findByName(ingredient.getName())) {
                ingredientRepository.save(ingredient);
            }
        }

            return "success";
    }


    public List<Ingredient> getIngredientInfo(DataParser dataParser){
        List<String> ingredients = dataParser.getIngredients();
        StringBuilder strbul=new StringBuilder();
        strbul.append("ingredients: \r");
        for(String str : ingredients)
        {
            strbul.append(str);
            //for adding comma between elements
            strbul.append(",\r");
        }
        //just for removing last comma
        strbul.setLength(strbul.length()-1);
        String str=strbul.toString();
        RestTemplate restTemplate = new RestTemplate();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://zestful.p.rapidapi.com/parseIngredients"))
                .header("content-type", "application/json")
                .header("x-rapidapi-host", "zestful.p.rapidapi.com")
                .header("x-rapidapi-key", "0ebc868e2mshdaa7507d4f54327p1618cdjsn98480f8cd15b")
                .method("POST", HttpRequest.BodyPublishers.ofString(str))
                .build();
        String response;

        IngredientParser ingredientParser = new IngredientParser();
        try {
            HttpResponse<String> apiResponse = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(apiResponse.body());
            response = apiResponse.body();
            ObjectMapper objectMapper = new ObjectMapper();
            ingredientParser = objectMapper.readValue(response, new TypeReference<List<IngredientParser>>() {  }).get(0);
        }
        catch (Exception e){
            response = "shits fucked";
        }
        List<Ingredient> ingredients1 = new ArrayList<>();
        List<IngApi> ingParse = ingredientParser.getIngredientParsed();
        Ingredient ingredient = new Ingredient();
        for (IngApi ingApi : ingParse
             ) {
            ingredient.setAmount(ingApi.getQuantity());
            ingredient.setMeasurement(ingApi.getUnit());
            ingredient.setName(ingApi.getProduct());
            ingredient.setPrepNotes(ingApi.getPreparationNotes());
            ingredients1.add(ingredient);
        }

        return ingredients1;


    }
}
