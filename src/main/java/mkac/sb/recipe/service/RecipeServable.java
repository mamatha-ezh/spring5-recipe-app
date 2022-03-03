/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkac.sb.recipe.service;

import java.util.Set;
import mkac.sb.recipe.domain.Recipe;

/**
 *
 * @author mamat
 */
public interface RecipeServable {
    
    public Set<Recipe> getRecipes();
        
    
}
