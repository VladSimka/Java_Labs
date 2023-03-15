package by.vladsimonenko.sixlab.variantС._main;

import by.vladsimonenko.sixlab.variantA.service.ReaderWriterAction;
import by.vladsimonenko.sixlab.variantС.action.Reader;
import by.vladsimonenko.sixlab.variantС.action.Writer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;

/**
 * Class with main method for variant C
 */
public class MatrixFileMain {
    static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        try {
            int n = ReaderWriterAction.getLineCountByReader(args[2]);
            int[][] matrix = new int[n][n];
            Reader reader = new Reader();
            reader.readFromFile(matrix, args[2]);
            Writer writer = new Writer();
            writer.createAndWriteToFile(matrix, args[0], args[1]);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

    }
}
