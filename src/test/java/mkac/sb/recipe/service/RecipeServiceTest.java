/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkac.sb.recipe.service;

import java.util.HashSet;
import java.util.Set;
import mkac.sb.recipe.domain.Recipe;
import mkac.sb.recipe.repository.RecipeRepository;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author mamat
 */
public class RecipeServiceTest {
    
 RecipeService instance = null;
     @Mock
     RecipeRepository recipeRepository;
    
    public RecipeServiceTest() {

    }
    
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        instance = new RecipeService(recipeRepository);
    }

    /**
     * Test of getRecipes method, of class RecipeService.
     */
    @Test
    public void testGetRecipes() {
        System.out.println("getRecipes");
       //RecipeService instance = null;
        Set<Recipe> expResult = new HashSet<>();
        expResult.add(new Recipe());
        Set<Recipe> result = instance.getRecipes();
        when(recipeRepository.findAll()).thenReturn(result);
        assertEquals(expResult.size(), result.size());
        // TODO review the generated test code and remove the default call to fail.
        verify(recipeRepository,times(1)).findAll();
        fail("The test case is a prototype.");
    }
    
}
