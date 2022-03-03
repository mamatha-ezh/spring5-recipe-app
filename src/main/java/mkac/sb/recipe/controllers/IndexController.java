/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkac.sb.recipe.controllers;

import java.util.Optional;
import mkac.sb.recipe.domain.Category;
import mkac.sb.recipe.domain.UOM;
import mkac.sb.recipe.repository.CategoryRepository;
import mkac.sb.recipe.repository.UOMRepository;
import mkac.sb.recipe.service.RecipeServable;
import mkac.sb.recipe.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mamat
 */
@Controller
public class IndexController {
    

private final RecipeServable recipeServable;

    public IndexController(RecipeServable recipeServable) {
        this.recipeServable = recipeServable;
    }

   
    
    @RequestMapping({"","/","index.html"})
    public String getIndex(Model model){
        model.addAttribute("recipes",recipeServable.getRecipes());
        return "index";
    }
    
}
