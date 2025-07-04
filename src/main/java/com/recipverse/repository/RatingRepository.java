package com.recipverse.repository;

import com.recipverse.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByRecipeId(Long recipeId);
    Optional<Rating> findByUserIdAndRecipeId(Long userId, Long recipeId);
}
