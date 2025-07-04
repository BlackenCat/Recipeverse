package com.recipverse.service;

import com.recipverse.entity.Rating;
import com.recipverse.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;

    public Rating rate(Rating rating) {
        // Éviter les doublons : un utilisateur ne peut noter qu'une seule fois
        return ratingRepository.findByUserIdAndRecipeId(
                rating.getUser().getId(),
                rating.getRecipe().getId()
        ).map(existing -> {
            existing.setScore(rating.getScore());
            return ratingRepository.save(existing);
        }).orElseGet(() -> ratingRepository.save(rating));
    }

    public List<Rating> getByRecipe(Long recipeId) {
        return ratingRepository.findByRecipeId(recipeId);
    }

    public void delete(Long id) {
        ratingRepository.deleteById(id);
    }

    public double getAverageRating(Long recipeId) {
        List<Rating> ratings = ratingRepository.findByRecipeId(recipeId);
        return ratings.stream().mapToInt(Rating::getScore).average().orElse(0.0);
    }
}
