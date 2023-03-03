package by.vladsimonenko.fourthlab.variantA.action;

import by.vladsimonenko.fourthlab.variantA.entity.SimpleFraction;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class for interacting with a simple fraction
 */

public class SimpleFractionAction {
    static Logger logger = LogManager.getLogger();


    /**
     * Addition method for simple fractions
     *
     * @param p first fraction
     * @param q second fraction
     * @return result of addition
     */
    public SimpleFraction add(SimpleFraction p, SimpleFraction q) {
        logger.log(Level.DEBUG, "Argument p is " + p + ", argument q is " + q);
        int numerator = p.getNumerator() * q.getDenominator() + p.getDenominator() * q.getNumerator();
        int denominator = p.getDenominator() * q.getDenominator();
        SimpleFraction result = new SimpleFraction(numerator, denominator);
        reduce(result);
        logger.log(Level.INFO, "Result of addition is " + result);
        return result;
    }


    /**
     * Subtraction method for simple fractions
     *
     * @param p first fraction
     * @param q second fraction
     * @return result of subtraction
     */
    public SimpleFraction subtract(SimpleFraction p, SimpleFraction q) {
        logger.log(Level.DEBUG, "Argument p is " + p + ", argument q is " + q);
        int numerator = p.getNumerator() * q.getDenominator() - p.getDenominator() * q.getNumerator();
        int denominator = p.getDenominator() * q.getDenominator();
        SimpleFraction result = new SimpleFraction(numerator, denominator);
        reduce(result);
        logger.log(Level.INFO, "Result of subtracting is " + result);
        return result;
    }

    /**
     * Multiplication method for simple fractions
     *
     * @param p first fraction
     * @param q second fraction
     * @return result of multiplication
     */
    public SimpleFraction multiply(SimpleFraction p, SimpleFraction q) {
        logger.log(Level.DEBUG, "Argument p is " + p + ", argument q is " + q);
        int numerator = p.getNumerator() * q.getNumerator();
        int denominator = p.getDenominator() * q.getDenominator();
        SimpleFraction result = new SimpleFraction(numerator, denominator);
        reduce(result);
        logger.log(Level.INFO, "Result of multiplication is " + result);
        return result;
    }

    /**
     * Division method for simple fractions
     *
     * @param p first fraction
     * @param q second fraction
     * @return result of division
     */
    public SimpleFraction divide(SimpleFraction p, SimpleFraction q) {
        logger.log(Level.DEBUG, "Argument p is " + p + ", argument q is " + q);
        int numerator = p.getNumerator() * q.getDenominator();
        int denominator = p.getDenominator() * q.getNumerator();
        SimpleFraction result = new SimpleFraction(numerator, denominator);
        reduce(result);
        logger.log(Level.INFO, "Result of division is " + result);
        return result;
    }

    /**
     * Method that reduce simple fraction
     *
     * @param fraction fraction to reduce
     */
    private void reduce(SimpleFraction fraction) {
        int gcd = greatestCommonDivisor(Math.abs(fraction.getDenominator()), Math.abs(fraction.getNumerator()));
        fraction.setNumerator(fraction.getNumerator() / gcd);
        fraction.setDenominator(fraction.getDenominator() / gcd);
    }

    /**
     * Method to find the greatest common divisor of two numbers. It needed to reduce simple fraction.
     *
     * @param a first number
     * @param b second number
     * @return greatest common divisor
     */
    private int greatestCommonDivisor(int a, int b) {
        return b == 0 ? a : greatestCommonDivisor(b, a % b);
    }
}
