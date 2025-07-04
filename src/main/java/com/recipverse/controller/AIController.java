package com.recipverse.controller;

import com.recipverse.dto.AIPromptRequest;
import com.recipverse.service.MistralService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class AIController {

    private final MistralService mistralService;

    @PostMapping("/suggest")
    public ResponseEntity<String> suggest(@RequestBody AIPromptRequest request) {
        return ResponseEntity.ok(mistralService.suggestRecipe(request.getPrompt()));
    }
}
