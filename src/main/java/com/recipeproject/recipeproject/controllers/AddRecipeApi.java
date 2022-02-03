package com.recipeproject.recipeproject.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipeproject.recipeproject.models.DataParser;
import com.recipeproject.recipeproject.models.dto.AddRecipeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

@Controller
public class AddRecipeApi {



    private static String COOKBOOK_IO_URL = "https://mycookbook-io1.p.rapidapi.com/recipes/rapidapi";

    @Autowired
    private AddFromWeb addFromWeb;

    @RequestMapping(value = "addurl", method = RequestMethod.POST)
    public String getfromWeb(@ModelAttribute AddRecipeDTO addRecipeDTO, Model model) {

        String url = addRecipeDTO.getUrl();

        RestTemplate restTemplate = new RestTemplate();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://mycookbook-io1.p.rapidapi.com/recipes/rapidapi"))
                .header("x-rapidapi-host", "mycookbook-io1.p.rapidapi.com")
                .header("x-rapidapi-key", "e353e864a1msh21955970eb647ecp1b206fjsn1f74a04a741f")
                .method("POST", HttpRequest.BodyPublishers.ofString(url))
                .build();
        String response;
        //The json is stored as a DataParser object on this next line, it still needs to have the data put into the DB but pulling it out should be easy
        DataParser dataParser = new DataParser();
        try {
            HttpResponse<String> apiResponse = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(apiResponse.body());
            response = apiResponse.body();
            ObjectMapper objectMapper = new ObjectMapper();
            dataParser = objectMapper.readValue(response, new TypeReference<List<DataParser>>() {
            }).get(0);
        } catch (Exception e) {
            response = "shits fucked";
        }

        addFromWeb.saveDPtoRecipe(dataParser, model);

        return "success";


    }
    @GetMapping("addurl")
    public String addurl (Model model){
        return "addurl";
    }

}