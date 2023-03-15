package by.vladsimonenko.sixlab.variantС.action;

import by.vladsimonenko.sixlab.variantA.service.ReaderWriterAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


/**
 * Class - action for reading information
 */
public class Reader {
    static Logger logger = LogManager.getLogger();

    /**
     * Method that reads information from file and fill the matrix
     *
     * @param matrix   current matrix
     * @param fileName name of file
     */
    public void readFromFile(int[][] matrix, String fileName) {
        File inputFile = new File(fileName);
        try {
            Scanner scanner = new Scanner(inputFile);
            int n = ReaderWriterAction.getLineCountByReader(fileName);
            scanner = new Scanner(inputFile);

            //check matrix
            while (scanner.hasNextLine()) {
                String[] row = scanner.nextLine().split(" ");
                if (row.length != n) {
                    throw new IllegalArgumentException("Неверный формат матрицы!");
                }
                for (int i = 0; i < n; i++) {
                    try {
                        Integer.parseInt(row[i]);
                    } catch (NumberFormatException e) {
                        logger.error("Ошибка: матрица должна содержать только целые числа.");
                    }
                }
            }

            //read matrix from file
            scanner = new Scanner(inputFile);
            int i = 0;
            while (scanner.hasNextLine()) {
                String[] row = scanner.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
                i++;
            }

            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[k][j]);
                }
                System.out.println();
            }
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

    }
}
