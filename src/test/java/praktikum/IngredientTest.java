package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IngredientTest {
    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, "sauce", 105.78f);
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(ingredient.getPrice(), 105.78f,0);
    }

    @Test
    public void getName() {
        Assert.assertEquals(ingredient.getName(),"sauce");
    }

    @Test
    public void getType() {
        Assert.assertEquals(ingredient.getType(),IngredientType.SAUCE);
    }
}