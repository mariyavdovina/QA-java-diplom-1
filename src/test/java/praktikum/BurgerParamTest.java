package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class BurgerParamTest {
    private final List<Ingredient> ingredients;
    Burger burger = new Burger();
    private final List<String> expected;
    public BurgerParamTest(List<Ingredient> ingredients) {
        this.expected = new ArrayList<>();
        this.ingredients = ingredients;
        for(Ingredient ingredient:ingredients){
            this.expected.add(String.format("%s, %s, %s%n", ingredient.getType(), ingredient.name,ingredient.getPrice()));
        }

    }
    @Parameterized.Parameters
    public static Object[][] getConstructorParams() {
        return new Object[][]{
                {List.of(new Ingredient(IngredientType.SAUCE, "hot sauce", 100f), new Ingredient(IngredientType.FILLING, "sour cream", 200f))}
                //{List.of(new Ingredient(IngredientType.SAUCE, "hot sauce", 100f))}
        };
    }

    @Test
    public void testAddIngredientsWorks() {
        Assert.assertEquals(0,burger.ingredients.size());
        for(Ingredient ingredient:ingredients){
            burger.addIngredient(ingredient);
        }
        Assert.assertEquals(ingredients.size(),burger.ingredients.size() );
        for(int i=0;i<ingredients.size();i++){
            Assert.assertEquals(expected.get(i), String.format("%s, %s, %s%n", burger.ingredients.get(i).getType(), burger.ingredients.get(i).getName(), burger.ingredients.get(i).getPrice()));
        }
    }

    @Test
    public void testRemoveIngredientWorks() {
        for(Ingredient ingredient:ingredients){
            burger.addIngredient(ingredient);
        }
        burger.removeIngredient(0);
        Assert.assertEquals(ingredients.size()-1,burger.ingredients.size() );
        Assert.assertEquals(expected.get(1),String.format("%s, %s, %s%n", burger.ingredients.get(0).getType(), burger.ingredients.get(0).getName(), burger.ingredients.get(0).getPrice()));
    }

    @Test
    public void testMoveIngredient() {
        for(Ingredient ingredient:ingredients){
            burger.addIngredient(ingredient);
        }
        burger.moveIngredient(0, ingredients.size()-1);
        Assert.assertEquals(expected.get(ingredients.size()-1),String.format("%s, %s, %s%n", burger.ingredients.get(0).getType(), burger.ingredients.get(0).getName(), burger.ingredients.get(0).getPrice()));
        Assert.assertEquals(expected.get(0),String.format("%s, %s, %s%n", burger.ingredients.get(ingredients.size()-1).getType(), burger.ingredients.get(ingredients.size()-1).getName(), burger.ingredients.get(ingredients.size()-1).getPrice()));
    }

}