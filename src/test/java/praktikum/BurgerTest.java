package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private List<Ingredient> ingredients;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testGetPriceAndGetReceiptWorksCorrectly() {
        String bunName = "bunName";
        String ingredientType = "ingredientType";

        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(Float.valueOf(100));
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredients.size()).thenReturn(2);
        for (int i = 0; i < ingredients.size(); i++) {
            Mockito.when(ingredients.get(i)).thenReturn(new Ingredient(IngredientType.SAUCE, ingredientType, 100f));
            burger.addIngredient(ingredients.get(i));
        }
        StringBuilder actual = new StringBuilder(String.format("(==== %s ====)%n", bunName));

        for (Ingredient ingredient : burger.ingredients) {
            actual.append(String.format("= %s %s =%n", "sauce".toLowerCase(),
                    ingredientType));
        }
        actual.append(String.format("(==== %s ====)%n", bunName));
        actual.append(String.format("%nPrice: %f%n", 400F));

        Assert.assertEquals(burger.getPrice(), 400f, 0);
        Assert.assertEquals(burger.getReceipt(), actual.toString());
    }
}