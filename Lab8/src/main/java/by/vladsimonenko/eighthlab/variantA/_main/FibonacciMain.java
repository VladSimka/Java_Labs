package by.vladsimonenko.eighthlab.variantA._main;

import by.vladsimonenko.eighthlab.variantA.action.FibonacciAction;
import by.vladsimonenko.eighthlab.variantA.service.FibonacciService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class with main method for VariantA
 */
public class FibonacciMain {
    static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        FibonacciAction action = new FibonacciAction();
        action.fibonacciAction(i -> (Math.sqrt(5 * i * i + 4) % 1 == 0) || (Math.sqrt(5 * i * i - 4) % 1 == 0));
    }
}
