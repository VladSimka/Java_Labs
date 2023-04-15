package by.vladsimonenko.tenth.variantA.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;

/**
 * Class - action that helps read text information from file
 */
public class TextReader {
    static final Logger LOGGER = LogManager.getLogger();

    /**
     * Method find number of lines in file
     *
     * @param fileName name of file
     * @return number of lines
     * @throws IOException
     */
    public static int getLineCountByReader(String fileName) throws IOException {
        try (var lnr = new LineNumberReader(new BufferedReader(new FileReader(fileName)))) {
            while (lnr.readLine() != null) ;
            return lnr.getLineNumber();
        }
    }

    /**
     * Method that read information from file
     *
     * @param fileInputName name of file input
     * @return text from file
     */
    public String readTextFromFile(String fileInputName) {
        File file = new File(fileInputName);
        String result = "";
        try (Scanner scanner = new Scanner(file)) {
            for (int i = 0; i < getLineCountByReader(fileInputName); i++) {
                result += scanner.nextLine() + " ";
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}