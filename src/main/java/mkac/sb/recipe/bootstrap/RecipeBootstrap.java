/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkac.sb.recipe.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mkac.sb.recipe.domain.Category;
import mkac.sb.recipe.domain.Difficulty;
import mkac.sb.recipe.domain.Ingredient;
import mkac.sb.recipe.domain.Note;
import mkac.sb.recipe.domain.Recipe;
import mkac.sb.recipe.domain.UOM;
import mkac.sb.recipe.repository.CategoryRepository;
import mkac.sb.recipe.repository.RecipeRepository;
import mkac.sb.recipe.repository.UOMRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author mamat
 */
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent>{
    
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UOMRepository uomRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UOMRepository uomRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.uomRepository = uomRepository;
    }

    private List<Recipe> getRecipes(){
        List<Recipe> recipes = new ArrayList(2);
        Optional<UOM> uomcup = uomRepository.findByDescription("cup");
        if(!uomcup.isPresent())
            throw new RuntimeException("UOM cup not present!");
        Optional<UOM> uomeach = uomRepository.findByDescription("each");
        if(!uomeach.isPresent())
            throw new RuntimeException("UOM each not present");
        Optional<UOM> uomtsp = uomRepository.findByDescription("teaspoon");
         if(!uomtsp.isPresent())
            throw new RuntimeException("UOM tsp not present");
         UOM ucup= uomcup.get();
         UOM ueach= uomeach.get();
         UOM utsp= uomtsp.get();
         Optional<Category> acat = categoryRepository.findByDescription("American");
        if(!acat.isPresent())
            throw new RuntimeException("Category American not present");
       Category ctgAmerican = acat.get();
       Recipe bananamuffin = new Recipe();
       bananamuffin.setCookingTime(20);
       bananamuffin.setPrepTime(10);
       bananamuffin.setDescription("Banana muffins");
       bananamuffin.setDirections("nstructions\n" +
"Preheat the oven to 425F. Line a 12-cup muffin tin with paper liners.\n" +
"In a large bowl, whisk together flour, sugar, baking powder, baking soda, salt, and cinnamon.\n" +
"In a medium bowl, whisk together banana, melted butter, eggs, and vanilla, until incorporated but the bananas are still a bit lumpy. Pour the banana mixture into the flour mixture and stir until combined. Divide the batter among each paper liner (they will be almost full).\n" +
"Bake for 5 minutes then reduce the oven temperature to 350F and continue baking for another 15 minutes or until the centers are springy to the touch and the tops are golden brown. Let muffins cool in the pan for a few minutes. Serve warm or remove them from the pan and cool completely on a wire rack.");
       
    bananamuffin.setDifficulty(Difficulty.EASY);
    Note notes = new Note();   
    notes.setRecipeNotes("Don’t use an electric mixer, or you could over-mix the batter, resulting in dense muffins or large holes in the crumb. Instead, use a spatula or wooden spoon and mix until everything is just combined. This is the secret to moist and fluffy muffins! \n" +
"Bring your eggs and milk to room temperature, so they incorporate fully into the batter without accidentally overmixing. If they’re cold, place the eggs in a bowl of warm water for a couple of minutes before using them.\n" +
"I recommend using real vanilla extract over artificial vanilla extract for the best flavor.\n" +
"Measure the flour correctly! Adding too much flour to the recipe is the most common mistake, leading to a dense muffin. The best and easiest way to measure flour is by using a scale. If you don’t have one, then fluff your flour with a spoon, sprinkle it into your measuring cup, and use a knife to level it off.\n" +
"You can easily mash your bananas with a fork or potato masher.\n" +
"For more flavor, brown the butter before using it. Just make sure to allow it to cool before combining with the wet ingredients.\n" +
"Make sure the oven temperature is high to start. The high temperature helps the tops of the banana muffins spring up for that classic dome top.\n" +
"If you have frozen bananas, thaw them before mashing and using them.\n" +
"");
 // notes.setRecipe(bananamuffin);
  bananamuffin.setNotes(notes);
  bananamuffin.addIngredient(new Ingredient("All purpose flour",new BigDecimal(1.5),ucup));
  bananamuffin.addIngredient(new Ingredient("Sugar",new BigDecimal(0.75),ucup));
  bananamuffin.addIngredient(new Ingredient("Baking soda",new BigDecimal(1),utsp));
  bananamuffin.addIngredient(new Ingredient("Baking powder",new BigDecimal(1),utsp));
  bananamuffin.addIngredient(new Ingredient("Salt",new BigDecimal(0.75),utsp));
  bananamuffin.addIngredient(new Ingredient("Cinnamon powder",new BigDecimal(1),utsp));
  bananamuffin.addIngredient(new Ingredient("Banana",new BigDecimal(1.5),ucup));
  bananamuffin.addIngredient(new Ingredient("Unsalted Butter",new BigDecimal(0.5),ucup));
  bananamuffin.addIngredient(new Ingredient("Eggs",new BigDecimal(2),ueach));
  bananamuffin.getCategories().add(ctgAmerican);
  recipes.add(bananamuffin);
  return recipes;
  }
    
    @Override
    
    public void onApplicationEvent(ContextRefreshedEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    recipeRepository.saveAll(getRecipes());
    }
    
}
