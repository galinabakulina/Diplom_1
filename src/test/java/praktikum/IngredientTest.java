package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final String name;
    private final float price;
    private final IngredientType type;

    public IngredientTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {FILLING, "Салатик", 75},
                {FILLING, "Мясо", 300},
                {SAUCE, "Сметанка", 50}
        };
    }

    @Test
    public void ingredientTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), 1e-6f);
        assertEquals(type, ingredient.getType());
    }

}

