package by.vladsimonenko.thirdlab.variantC.action;

import by.vladsimonenko.thirdlab.variantC.entity.BoolMatrix;
import by.vladsimonenko.thirdlab.variantC.exception.BoolMatrixException;

import java.util.Arrays;


/**
 * Class - action that interacts with BoolMatrix
 */
public class BoolMatrixAction {

    /**
     * Method that performs the addition of two BoolMatrix
     *
     * @param p first addend
     * @param q second addend
     * @return result of addition
     */
    public BoolMatrix add(BoolMatrix p, BoolMatrix q) throws BoolMatrixException {
        if (p.getRows() != q.getRows() || p.getColumns() != q.getColumns()) {
            throw new BoolMatrixException("Размерности матриц не совпадают");
        }
        int v = p.getRows();
        int h = p.getColumns();
        BoolMatrix result = new BoolMatrix(v, h);
        try {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < h; j++) {
                    result.setElement(i, j, (p.getElement(i, j) + q.getElement(i, j)) % 2);
                }
            }
        } catch (BoolMatrixException e) {
            System.err.println(e);
        }
        return result;
    }

    /**
     * Method that performs the multiplication of two BoolMatrix
     *
     * @param p first multiplier
     * @param q second multiplier
     * @return result of multiplication
     */
    public BoolMatrix multiply(BoolMatrix p, BoolMatrix q) throws BoolMatrixException {
        int v = p.getRows();
        int h = q.getColumns();
        int controlSize = p.getColumns();
        if (controlSize != q.getRows()) {
            throw new BoolMatrixException("Размерности матриц не подходят для умножения");
        }
        BoolMatrix result = new BoolMatrix(v, h);

        try {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < h; j++) {
                    int value = 0;
                    for (int k = 0; k < controlSize; k++) {
                        value += p.getElement(i, k) * q.getElement(k, j);
                    }
                    result.setElement(i, j, value % 2);

                }
            }
        } catch (BoolMatrixException e) {
            System.err.println(e);
        }
        return result;
    }

    /**
     * Method that inverses the BoolMatrix
     *
     * @param p matrix to inverse
     * @return result of inversion
     */
    public BoolMatrix inversion(BoolMatrix p) throws BoolMatrixException {
        int v = p.getRows();
        int h = p.getColumns();

        BoolMatrix result = new BoolMatrix(v, h);

        try {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < h; j++) {
                    result.setElement(i, j, (p.getElement(i, j) + 1) % 2);
                }
            }
        } catch (BoolMatrixException e) {
            System.err.println(e);
        }
        return result;

    }

    /**
     * Method that finds number of units in BoolMatrix
     *
     * @param p BoolMatrix
     * @return number of units
     */
    public int numberOfUnits(BoolMatrix p) throws BoolMatrixException {
        int v = p.getRows();
        int h = p.getColumns();
        int result = 0;

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < h; j++) {
                result = p.getElement(i, j) == 1 ? ++result : result;
            }
        }
        return result;
    }

    /**
     * Class that arranges BoolMatrix
     *
     * @param p BoolMatrix to order
     * @return ordered BoolMatrix
     */
    public BoolMatrix ordering(BoolMatrix p) throws BoolMatrixException {
        int n = p.getRows();
        int m = p.getColumns();

        String[] arr = new String[n];
        Arrays.fill(arr, "");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i] += String.valueOf(p.getElement(i, j));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    String tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                p.setElement(i, j, Character.getNumericValue(arr[i].charAt(j)));
            }
        }

        return p;
    }

}
