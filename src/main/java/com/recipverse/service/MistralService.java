package com.recipverse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MistralService {

    @Value("${mistral.api.key}")
    private String apiKey;

    @Value("${mistral.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String suggestRecipe(String userPrompt) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey.replace("Bearer ", ""));

        JSONObject body = new JSONObject();
        body.put("model", "mistral-medium"); // ou autre
        body.put("temperature", 0.7);
        body.put("messages", new Object[] {
                Map.of("role", "system", "content", "Tu es un assistant culinaire qui propose des recettes."),
                Map.of("role", "user", "content", "Donne une recette avec : " + userPrompt)
        });

        HttpEntity<String> entity = new HttpEntity<>(body.toString(), headers);

        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class);

        JSONObject json = new JSONObject(response.getBody());
        return json.getJSONArray("choices")
                .getJSONObject(0)
                .getJSONObject("message")
                .getString("content");
    }
}
