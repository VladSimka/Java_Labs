package by.vladsimonenko.ninthlab.variantA._main;

import by.vladsimonenko.ninthlab.variantA.action.StringLengthAction;
import by.vladsimonenko.ninthlab.variantA.reader.StringReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Class with main method for variantA
 */
public class StringLengthMain {
    static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

        StringReader reader = new StringReader();

        try {
            String txt = reader.readTextFromFile(args[0]);
            StringLengthAction action = new StringLengthAction();


            int max = action.maxLengthInText(txt);
            int min = action.minLengthInText(txt);
            System.out.println("Слова максимальной длины (" + max + "): ");
            action.printWordsWithCurrentLength(txt, max);

            System.out.println("\n");

            System.out.println("Слова минимальной длины (" + min + "): ");
            action.printWordsWithCurrentLength(txt, min);
        } catch (RuntimeException e) {
            LOGGER.error(e.getMessage());
        }


    }
}
