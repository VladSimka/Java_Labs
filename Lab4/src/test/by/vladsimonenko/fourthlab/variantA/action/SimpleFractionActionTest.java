package by.vladsimonenko.fourthlab.variantA.action;

import by.vladsimonenko.fourthlab.variantA.entity.SimpleFraction;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SimpleFractionActionTest {


    @Test
    public void testAdd() {
        SimpleFractionAction action = new SimpleFractionAction();
        SimpleFraction actual = action.add(new SimpleFraction(1, 3), new SimpleFraction(1, 2));
        SimpleFraction expected = new SimpleFraction(5, 6);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSubtract() {
        SimpleFractionAction action = new SimpleFractionAction();
        SimpleFraction actual = action.subtract(new SimpleFraction(5, 4), new SimpleFraction(3, 4));
        SimpleFraction expected = new SimpleFraction(1, 2);
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void testMultiply() {
        SimpleFractionAction action = new SimpleFractionAction();
        SimpleFraction actual = action.multiply(new SimpleFraction(5, 4), new SimpleFraction(4, 6));
        SimpleFraction expected = new SimpleFraction(5, 6);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testDivide() {
        SimpleFractionAction action = new SimpleFractionAction();
        SimpleFraction actual = action.divide(new SimpleFraction(10, 11), new SimpleFraction(100, 22));
        SimpleFraction expected = new SimpleFraction(1, 5);
        Assert.assertEquals(actual, expected);
    }
}