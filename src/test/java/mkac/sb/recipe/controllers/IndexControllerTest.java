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
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.springframework.ui.Model;

/*
/**
 *
 * @author mamat
 * /
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
    
    @Test 
    public void testMockMVC() throws Exception{
        MockMvc mockmvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockmvc.perform(get("/")).andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
    
}
