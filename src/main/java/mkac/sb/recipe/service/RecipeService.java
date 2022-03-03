/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkac.sb.recipe.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mkac.sb.recipe.domain.Recipe;
import mkac.sb.recipe.repository.RecipeRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author mamat
 */
@Service
public class RecipeService implements RecipeServable{

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
    
    @Override
    public Set<Recipe> getRecipes() {
        
        Set rs =  new HashSet<Recipe>();
        recipeRepository.findAll().iterator().forEachRemaining(rs::add);
        return rs;
    }
    
}
