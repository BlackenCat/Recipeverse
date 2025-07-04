package com.recipverse.controller;

import com.recipverse.entity.Rating;
import com.recipverse.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Rating> rate(@RequestBody Rating rating) {
        return ResponseEntity.ok(ratingService.rate(rating));
    }

    @GetMapping("/recipe/{recipeId}")
    public ResponseEntity<List<Rating>> getByRecipe(@PathVariable Long recipeId) {
        return ResponseEntity.ok(ratingService.getByRecipe(recipeId));
    }

    @GetMapping("/average/{recipeId}")
    public ResponseEntity<Double> getAverage(@PathVariable Long recipeId) {
        return ResponseEntity.ok(ratingService.getAverageRating(recipeId));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ratingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
