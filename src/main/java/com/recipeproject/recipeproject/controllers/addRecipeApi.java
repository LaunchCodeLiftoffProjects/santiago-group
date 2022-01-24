package com.recipeproject.recipeproject.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipeproject.recipeproject.models.DataParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

@RestController
public class addRecipeApi {
    private static String COOKBOOK_IO_URL = "https://mycookbook-io1.p.rapidapi.com/recipes/rapidapi";

    @RequestMapping(value = "addurl", method = RequestMethod.POST)
    public ResponseEntity<Object> getfromWeb(@RequestBody Map<String, String> body){
        String url = body.get("url");
        RestTemplate restTemplate = new RestTemplate();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://mycookbook-io1.p.rapidapi.com/recipes/rapidapi"))
                .header("x-rapidapi-host", "mycookbook-io1.p.rapidapi.com")
                .header("x-rapidapi-key", "e353e864a1msh21955970eb647ecp1b206fjsn1f74a04a741f")

                .method("POST", HttpRequest.BodyPublishers.ofString(url))
                .build();
        String response;
        DataParser dataParser = new DataParser();
        try {
            HttpResponse<String> apiResponse = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(apiResponse.body());
            response = apiResponse.body();
            ObjectMapper objectMapper = new ObjectMapper();
            dataParser = objectMapper.readValue(response, new TypeReference<List<DataParser>>() {  }).get(0);
        }
        catch (Exception e){
            response = "shits fucked";
        }


        return ResponseEntity.ok(dataParser);


    }

}
