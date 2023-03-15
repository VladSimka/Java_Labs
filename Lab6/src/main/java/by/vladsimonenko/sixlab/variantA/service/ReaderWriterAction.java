package by.vladsimonenko.sixlab.variantA.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

/**
 * Class for work with i/o threads
 */
public class ReaderWriterAction {

    static Logger logger = LogManager.getLogger();


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
     * Method that find all words that starts with vowel in one file and
     * writes it to another.
     *
     * @param fileInputName  file from which information is read
     * @param fileOutputName file to which information is written
     */
    public void findWordsInAFile(String fileInputName, String fileOutputName) {


        try (FileReader reader = new FileReader(fileInputName);
             BufferedReader bufferedReader = new BufferedReader(reader);
             FileWriter writer = new FileWriter(fileOutputName);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            String line = null;
            String[] arr;

            bufferedWriter.write("Все слова, начинающиеся на гласную буквы :");
            bufferedWriter.newLine();
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(" ");

                for (int i = 0; i < arr.length; i++) {
                    if (startsWithVowel(arr[i])) {
                        bufferedWriter.write(arr[i], 0, arr[i].length());
                        bufferedWriter.write(" ");
                    }
                }
                bufferedWriter.newLine();
            }

        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

    }

    /**
     * Method that checks if a word starts with a vowel
     *
     * @param str current word
     * @return true, if starts
     * else false
     */
    private boolean startsWithVowel(String str) {
        return "уеыаоэяиюё".indexOf(Character.toLowerCase(str.charAt(0))) != -1;
    }
}
