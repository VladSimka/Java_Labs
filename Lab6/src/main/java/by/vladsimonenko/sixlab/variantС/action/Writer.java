package by.vladsimonenko.sixlab.variantС.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Class - action for writing information
 */
public class Writer {
    static Logger logger = LogManager.getLogger();

    /**
     * Method that create folder and file with information about matrix
     *
     * @param matrix   current matrix
     * @param output   name of folder
     * @param fileName name of file
     */
    public void createAndWriteToFile(int[][] matrix, String output, String fileName) {
        File outputDir = new File(output);
        outputDir.mkdir();
        File outputFile = new File(outputDir, fileName);


        try (PrintWriter writer = new PrintWriter(outputFile)) {

            writer.println("Исходная матрица: ");
            for (int[] row : matrix) {
                for (int element : row) {
                    writer.print(element + " ");
                }
                writer.println();
            }
            writer.println("Транспонированная матрица:");
            MatrixAction.transposeMatrix(matrix);
            for (int[] row : matrix) {
                for (int element : row) {
                    writer.print(element + " ");
                }
                writer.println();
            }
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }

    }

}
