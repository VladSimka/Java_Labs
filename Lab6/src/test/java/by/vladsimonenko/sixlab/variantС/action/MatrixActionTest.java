package by.vladsimonenko.sixlab.variantС.action;

import org.testng.Assert;
import org.testng.annotations.Test;


public class MatrixActionTest {

    @Test
    public void testTransposeMatrix() {
        int[][] actual = {{1,2,3},{4,5,6},{7,8,9}};
        MatrixAction.transposeMatrix(actual);
        int[][] expected = {{1,4,7},{2,5,8},{3,6,9}};
        Assert.assertEquals(actual,expected);
    }
}