package by.vladsimonenko.sixlab.variantС.action;

/**
 * Class - action for matrix
 */
public class MatrixAction {
    /**
     * Method that transpose matrix
     * @param matrix current matrix
     */
    public static void transposeMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] transposedMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = transposedMatrix[i][j];
            }
        }

    }
}
