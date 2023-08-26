package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BurgerTest {
    private Burger burger;
    private final Bun myBun = new Bun("Белая булочка", 100);
    private final Ingredient mySalad = new Ingredient(IngredientType.FILLING, "Салатик", 75);
    private final Ingredient myMeat = new Ingredient(IngredientType.FILLING, "Котлетка", 300);
    private final Ingredient mySauce = new Ingredient(IngredientType.SAUCE, "Сметанка", 25);

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void bunsOnly() {
        burger.setBuns(myBun);

        String expected = "(==== Белая булочка ====)\n" +
                "(==== Белая булочка ====)\n" +
                "\n" +
                "Price: 200,000000\n";

        String actual = burger.getReceipt();
        assertEquals(expected, actual);
    }

    @Test
    public void burgerWithMeatOnly() {
        burger.setBuns(myBun);
        burger.addIngredient(mySalad);
        burger.addIngredient(myMeat);
        burger.removeIngredient(0);

        String expected = "(==== Белая булочка ====)\n" +
                "= filling Котлетка =\n" +
                "(==== Белая булочка ====)\n" +
                "\n" +
                "Price: 500,000000\n";

        String actual = burger.getReceipt();
        assertEquals(expected, actual);
    }

    @Test
    public void burgerWithSausceSaladAndMeat() {
        burger.setBuns(myBun);
        burger.addIngredient(mySalad);
        burger.addIngredient(myMeat);
        burger.addIngredient(mySauce);
        burger.moveIngredient(2,0);

        String expected = "(==== Белая булочка ====)\n" +
                "= sauce Сметанка =\n" +
                "= filling Салатик =\n" +
                "= filling Котлетка =\n" +
                "(==== Белая булочка ====)\n" +
                "\n" +
                "Price: 600,000000\n";

        String actual = burger.getReceipt();
        assertEquals(expected, actual);
    }
}