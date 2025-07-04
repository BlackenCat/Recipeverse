package com.recipverse.service;

import com.recipverse.entity.Ingredient;
import com.recipverse.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public Ingredient create(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public List<Ingredient> getByRecipe(Long recipeId) {
        return ingredientRepository.findByRecipeId(recipeId);
    }

    public Ingredient update(Long id, Ingredient updated) {
        Ingredient existing = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));

        existing.setName(updated.getName());
        existing.setQuantity(updated.getQuantity());
        return ingredientRepository.save(existing);
    }

    public void delete(Long id) {
        ingredientRepository.deleteById(id);
    }
}
