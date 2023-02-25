package by.vladsimonenko.thirdlab.variantC.creator;

import by.vladsimonenko.thirdlab.variantC.entity.BoolMatrix;
import by.vladsimonenko.thirdlab.variantC.exception.BoolMatrixException;

/**
 * Class that creates an object of BoolMatrix
 */
public class BoolMatrixCreator {

    /**
     * Fills the BoolMatrix with random values
     *
     * @param matrix BoolMatrix to be filled in
     */
    public void fillBoolMatrix(BoolMatrix matrix) {
        int v = matrix.getRows();
        int h = matrix.getColumns();

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < h; j++) {
                try {
                    int value = (int) (Math.random() * 2);
                    matrix.setElement(i, j, value);
                } catch (BoolMatrixException e) {
                    System.err.println(e);
                }
            }
        }


    }
}
