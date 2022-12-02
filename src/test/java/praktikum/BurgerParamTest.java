package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class BurgerParamTest {
    private final List<Ingredient> ingredients;
    Burger burger = new Burger();
    private final List<String> expected;

/*    public BurgerParamTest(Ingredient ingredient1, Ingredient ingredient2, String expected1, String expected2) {
        this.ingredients.add(ingredient1);
        this.ingredients.add(ingredient2);
        this.expected.add(expected1);
        this.expected.add(expected2);

    }*/

    public BurgerParamTest(List<Ingredient> ingredients, List<String> expected) {
        this.expected = expected;
        this.ingredients = ingredients;
    }

    /*    @Parameterized.Parameters
        public static Object[][] getConstructorParams() {
            return new Object[][]{
                    {new Ingredient(IngredientType.SAUCE, "hot sauce", 100f),
                            new Ingredient(IngredientType.FILLING, "sour cream", 200f),
                            String.format("%s, %s, %s%n", IngredientType.SAUCE, "hot sauce", 100f),
                            String.format("%s, %s, %s%n", IngredientType.FILLING, "sour cream", 200f)}
            };
        }*/
    @Parameterized.Parameters
    public static Object[][] getConstructorParams() {
        return new Object[][]{
                {List.of(new Ingredient(IngredientType.SAUCE, "hot sauce", 100f), new Ingredient(IngredientType.FILLING, "sour cream", 200f)),
                        List.of(String.format("%s, %s, %s%n", IngredientType.SAUCE, "hot sauce", 100f),String.format("%s, %s, %s%n", IngredientType.FILLING, "sour cream", 200f))}
        };
    }

    @Test
    public void testAddIngredientsWorks() {
        Assert.assertEquals(burger.ingredients.size(), 0);
        for(Ingredient ingredient:ingredients){
            burger.addIngredient(ingredient);
        }
        Assert.assertEquals(burger.ingredients.size(), ingredients.size());
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
        Assert.assertEquals(burger.ingredients.size(), ingredients.size()-1);
        Assert.assertEquals(String.format("%s, %s, %s%n", burger.ingredients.get(0).getType(), burger.ingredients.get(0).getName(), burger.ingredients.get(0).getPrice()), expected.get(1));
    }

    @Test
    public void testMoveIngredient() {
        for(Ingredient ingredient:ingredients){
            burger.addIngredient(ingredient);
        }
        burger.moveIngredient(0, ingredients.size()-1);
        Assert.assertEquals(String.format("%s, %s, %s%n", burger.ingredients.get(0).getType(), burger.ingredients.get(0).getName(), burger.ingredients.get(0).getPrice()), expected.get(ingredients.size()-1));
        Assert.assertEquals(String.format("%s, %s, %s%n", burger.ingredients.get(ingredients.size()-1).getType(), burger.ingredients.get(ingredients.size()-1).getName(), burger.ingredients.get(ingredients.size()-1).getPrice()), expected.get(0));
    }

}