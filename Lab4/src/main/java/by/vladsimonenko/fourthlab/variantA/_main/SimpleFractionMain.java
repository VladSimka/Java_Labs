package by.vladsimonenko.fourthlab.variantA._main;

import by.vladsimonenko.fourthlab.variantA.action.SimpleFractionAction;
import by.vladsimonenko.fourthlab.variantA.entity.SimpleFraction;
import by.vladsimonenko.fourthlab.variantA.exceptions.SimpleFractionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class with main method for variantA
 */

public class SimpleFractionMain {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        SimpleFractionAction action = new SimpleFractionAction();

        int size = SimpleFractionAction.getLineCountByReader("simplefraction.txt");


        SimpleFraction[] fractions = new SimpleFraction[size];
        for (int i = 0; i < fractions.length; i++) {
            fractions[i] = new SimpleFraction();
        }

        try {
            SimpleFractionAction.setSimpleFraction(fractions, "simplefraction.txt");
            action.add(fractions[0], fractions[1]);
            action.multiply(fractions[0], fractions[2]);
            action.subtract(fractions[0], fractions[3]);
            action.divide(fractions[0], fractions[4]);
        } catch (SimpleFractionException e) {
            logger.error("Не удалось выполнить математические операции: " + e.getMessage());
        }
        catch (IllegalArgumentException e){
            logger.error(e.getMessage());
        }


    }
}
