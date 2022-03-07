/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkac.sb.recipe.controllers;

import java.util.HashSet;
import java.util.Set;
import mkac.sb.recipe.domain.Recipe;
import mkac.sb.recipe.service.RecipeServable;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

/**
 *
 * @author mamat
 */
public class IndexControllerTest {
    @Mock
    RecipeServable recipeServable;
    @Mock
    Model model;
    IndexController controller;
    
    public IndexControllerTest() {
        
        MockitoAnnotations.initMocks(this);
        controller = new IndexController(recipeServable);
       
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getIndex method, of class IndexController.
     */
    @Test
    public void testGetIndex() {
         Set<Recipe> recipes = new HashSet<>();
        Recipe r1= new Recipe();    
        r1.setId(1L);
        Recipe r2= new Recipe();    
        r2.setId(2L);
        recipes.add(r1);
        recipes.add(r2);
        System.out.println("getIndex");
        when(recipeServable.getRecipes()).thenReturn(recipes);
        ArgumentCaptor<Set<Recipe>> ac = ArgumentCaptor.forClass(Set.class);
        String viewName= controller.getIndex(model);
        assertEquals("index", viewName);
       
        
        Mockito.verify(recipeServable,Mockito.times(1)).getRecipes();
        Mockito.verify(model,Mockito.times(1)).addAttribute(eq("recipes"), ac.capture());
   
    
    }
    
}
