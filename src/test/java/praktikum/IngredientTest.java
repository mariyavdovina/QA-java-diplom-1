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
        Assert.assertEquals(105.78f,ingredient.getPrice(), 0);
    }

    @Test
    public void getName() {
        Assert.assertEquals("sauce",ingredient.getName());
    }

    @Test
    public void getType() {
        Assert.assertEquals(IngredientType.SAUCE,ingredient.getType());
    }
}