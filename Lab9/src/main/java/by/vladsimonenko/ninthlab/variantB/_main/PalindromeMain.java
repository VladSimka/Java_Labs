package by.vladsimonenko.ninthlab.variantB._main;

import by.vladsimonenko.ninthlab.variantA.reader.StringReader;
import by.vladsimonenko.ninthlab.variantB.action.PalindromeAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class with main method for variantB
 */
public class PalindromeMain {
    static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        PalindromeAction action = new PalindromeAction();
        StringReader reader = new StringReader();
        try {
            String pal = reader.readTextFromFile(args[0]);
            System.out.println("Максимальная подстрока-палиндром: ");
            System.out.println(action.findMaxPalindromeInString(pal));
        } catch (RuntimeException e) {
            LOGGER.error(e.getMessage());
        }

    }
}
