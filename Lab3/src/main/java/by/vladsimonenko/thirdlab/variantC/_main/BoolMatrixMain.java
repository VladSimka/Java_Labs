package by.vladsimonenko.thirdlab.variantC._main;

import by.vladsimonenko.thirdlab.variantC.action.BoolMatrixAction;
import by.vladsimonenko.thirdlab.variantC.creator.BoolMatrixCreator;
import by.vladsimonenko.thirdlab.variantC.entity.BoolMatrix;
import by.vladsimonenko.thirdlab.variantC.exception.BoolMatrixException;

/**
 * Class with main method for variantC
 */
public class BoolMatrixMain {
    public static void main(String[] args) {
        try {
            BoolMatrixCreator creator = new BoolMatrixCreator();
            BoolMatrix p = new BoolMatrix(3, 4);
            BoolMatrix p1 = new BoolMatrix(3, 4);
            creator.fillBoolMatrix(p);
            creator.fillBoolMatrix(p1);
            System.out.println("Matrix first is: " + p);
            BoolMatrix q = new BoolMatrix(4, 5);
            BoolMatrixAction action = new BoolMatrixAction();
            creator.fillBoolMatrix(q);
            System.out.println("Matrix second is: " + q);


            BoolMatrix result = action.multiply(p, q);
            System.out.println("Matrices product is " + result);

            System.out.println("First' matrix: " + p1);
            System.out.println("Matrices sum is: " + action.add(p, p1));


            System.out.println("First matrix inverse: " + action.inversion(p));

            System.out.println("Second matrix inverse: " + action.inversion(q));


            System.out.println("Number of units in first matrix: " + action.numberOfUnits(p));
            System.out.println("Number of units in second matrix: " + action.numberOfUnits(q));
            System.out.println();

            System.out.println("Sorted first matrix: " + action.ordering(p));
            System.out.println("Sorted second matrix: " + action.ordering(q));

        } catch (BoolMatrixException e) {
            System.err.println("Error of creating matrix " + e);
        }
    }
}
