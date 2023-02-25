package by.vladsimonenko.thirdlab.variantC.entity;

import by.vladsimonenko.thirdlab.variantC.exception.BoolMatrixException;

/**
 * Class for storing bool matrix
 */
public class BoolMatrix {
    private final int rows;
    private final int columns;
    private int[][] matrix;

    public BoolMatrix(int rows, int columns) throws BoolMatrixException {
        if (rows < 1 && columns < 1) {
            throw new BoolMatrixException();
        }
        this.rows = rows;
        this.columns = columns;
        matrix = new int[rows][columns];
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public int getElement(int i, int j) throws BoolMatrixException {
        if (checkRange(i, j)) {
            return matrix[i][j];
        } else {
            throw new BoolMatrixException("Недопустимые границы матрицы");
        }
    }

    public void setElement(int i, int j, int value) throws BoolMatrixException {
        if (checkRange(i, j) && value >= 0 && value <= 1) {
            matrix[i][j] = value;
        } else {
            throw new BoolMatrixException("Недоступное для вставки элемента поле");
        }
    }

    private boolean checkRange(int i, int j) {
        return (i >= 0 && i < rows && j >= 0 && j < columns);
    }

    @Override
    public String toString() {
        final String BLANK = " ";
        StringBuilder s = new StringBuilder("\nMatrix : " + matrix.length + "x"
                + matrix[0].length + "\n");
        for (int[] row : matrix) {
            for (int value : row) {
                s.append(value).append(BLANK);
            }
            s.append("\n");
        }
        return s.toString();
    }
}
