/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkac.sb.recipe.repository;

import mkac.sb.recipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mamat
 */
public interface RecipeRepository extends CrudRepository<Recipe,Long>{
    
}
