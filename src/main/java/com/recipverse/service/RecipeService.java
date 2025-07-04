package com.recipverse.service;

import com.recipverse.entity.Recipe;
import com.recipverse.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public Recipe create(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getAllPublic() {
        return recipeRepository.findByIsPublicTrue();
    }

    public Recipe getById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
    }

    public Recipe update(Long id, Recipe updated) {
        Recipe existing = getById(id);
        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setPreparationTimeInMinutes(updated.getPreparationTimeInMinutes());
        existing.setCookingTimeInMinutes(updated.getCookingTimeInMinutes());
        existing.setPublic(updated.isPublic());
        return recipeRepository.save(existing);
    }

    public void delete(Long id) {
        recipeRepository.deleteById(id);
    }
}
