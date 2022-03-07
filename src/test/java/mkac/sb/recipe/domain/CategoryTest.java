/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkac.sb.recipe.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mamat
 */
public class CategoryTest {
    
    public CategoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Category.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Category instance = new Category();
        instance.setId(1L);
        Long expResult = 1L;
        Long result = instance.getId();
        System.out.println("id :" +expResult);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of setId method, of class Category.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Category instance = new Category();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
