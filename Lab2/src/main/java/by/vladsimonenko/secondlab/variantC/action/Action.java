package by.vladsimonenko.secondlab.variantC.action;

/**
 * Action class with two methods. The first method checks if the element
 * is the maximum in the row. The second method checks if the element
 * is the minimum in the column.
 *
 * @author Симоненко В.А.
 * @version 1.0
 */
public class Action {

    /**
     * @param matrix given matrix
     * @param row    current row
     * @param column current column
     * @return <b>true</b>, if element is maximum in current column, else <b>false</b>
     */
    public boolean isMaxInColumn(int[][] matrix, int row, int column) {
        int max = matrix[0][column];

        //Find maximum in current column
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][column] >= max) {
                max = matrix[i][column];
            }
        }

        return max == matrix[row][column];
    }

    /**
     * @param matrix given matrix
     * @param row    current row
     * @param column current column
     * @return <b>true</b>, if element is minimum in current row, otherwise <b>false</b>
     */
    public boolean isMinInRow(int[][] matrix, int row, int column) {
        int min = matrix[row][0];

        //Find minimum in current row
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[row][j] <= min) {
                min = matrix[row][j];
            }
        }
        return min == matrix[row][column];
    }
}
