package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    private Bun myBun;
    @Mock
    private Ingredient mySalad;
    @Mock
    private Ingredient myMeat;
    @Mock
    private Ingredient myCream;

    @Before
    public void setUp() {
        burger = new Burger();

        Mockito.when(myBun.getName()).thenReturn("Белая булочка");
        Mockito.when(myBun.getPrice()).thenReturn(100f);
        Mockito.when(mySalad.getName()).thenReturn("Салатик");
        Mockito.when(mySalad.getPrice()).thenReturn(75f);
        Mockito.when(mySalad.getType()).thenReturn(FILLING);
        Mockito.when(myMeat.getName()).thenReturn("Котлетка");
        Mockito.when(myMeat.getPrice()).thenReturn(300f);
        Mockito.when(myMeat.getType()).thenReturn(FILLING);
        Mockito.when(myCream.getName()).thenReturn("Сметанка");
        Mockito.when(myCream.getPrice()).thenReturn(25f);
        Mockito.when(myCream.getType()).thenReturn(SAUCE);

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
        burger.addIngredient(myCream);
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