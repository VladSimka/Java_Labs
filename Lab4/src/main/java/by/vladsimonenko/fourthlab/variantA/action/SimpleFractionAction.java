package by.vladsimonenko.fourthlab.variantA.action;

import by.vladsimonenko.fourthlab.variantA.entity.SimpleFraction;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SimpleFractionAction {
    static Logger logger = LogManager.getLogger();

    public SimpleFraction add(SimpleFraction p, SimpleFraction q) {
        logger.log(Level.DEBUG, "Argument p is " + p + ", argument q is " + q);
        int numerator = p.getNumerator() * q.getDenominator() + p.getDenominator() * q.getNumerator();
        int denominator = p.getDenominator() * q.getDenominator();
        SimpleFraction result = new SimpleFraction(numerator, denominator);
        reduce(result);
        logger.log(Level.INFO, "Result is " + result);
        return result;
    }

    public SimpleFraction subtract(SimpleFraction p, SimpleFraction q) {
        int numerator = p.getNumerator() * q.getDenominator() - p.getDenominator() * q.getNumerator();
        int denominator = p.getDenominator() * q.getDenominator();
        SimpleFraction result = new SimpleFraction(numerator, denominator);
        reduce(result);
        return result;
    }


    public SimpleFraction multiply(SimpleFraction p, SimpleFraction q) {
        int numerator = p.getNumerator() * q.getNumerator();
        int denominator = p.getDenominator() * q.getDenominator();
        SimpleFraction result = new SimpleFraction(numerator, denominator);
        reduce(result);
        return result;
    }

    public SimpleFraction divide(SimpleFraction p, SimpleFraction q) {
        int numerator = p.getNumerator() * q.getDenominator();
        int denominator = p.getDenominator() * q.getNumerator();
        SimpleFraction result = new SimpleFraction(numerator, denominator);
        reduce(result);
        return result;
    }

    private void reduce(SimpleFraction fraction) {
        int gcd = greatestCommonDivisor(Math.abs(fraction.getDenominator()), Math.abs(fraction.getNumerator()));
        fraction.setNumerator(fraction.getNumerator() / gcd);
        fraction.setDenominator(fraction.getDenominator() / gcd);
    }

    private int greatestCommonDivisor(int a, int b) {
        return b == 0 ? a : greatestCommonDivisor(b, a % b);
    }
}
