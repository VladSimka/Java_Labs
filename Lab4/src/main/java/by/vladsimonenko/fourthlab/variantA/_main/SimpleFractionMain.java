package by.vladsimonenko.fourthlab.variantA._main;

import by.vladsimonenko.fourthlab.variantA.action.SimpleFractionAction;
import by.vladsimonenko.fourthlab.variantA.entity.SimpleFraction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class with main method for variantA
 */

public class SimpleFractionMain {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        SimpleFractionAction action = new SimpleFractionAction();

        SimpleFraction frac = new SimpleFraction(1, 2);

        action.add(frac, new SimpleFraction(4, 34));
        action.multiply(frac, new SimpleFraction(5, 4));
        action.subtract(frac, new SimpleFraction(1, 3));
        action.divide(frac, new SimpleFraction(6, 18));


    }
}
