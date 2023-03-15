package by.vladsimonenko.fourthlab.variantA.action;

import by.vladsimonenko.fifthlab.exceptions.InvalidNumberException;
import by.vladsimonenko.fourthlab.variantA.entity.SimpleFraction;
import by.vladsimonenko.fourthlab.variantA.exceptions.SimpleFractionException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;


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
        if (q.getDenominator() == 0) {
            throw new IllegalArgumentException("Деление на ноль");
        }
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


    public static int getLineCountByReader(String fileName) {
        try (var lnr = new LineNumberReader(new BufferedReader(new FileReader(fileName)))) {
            while (lnr.readLine() != null) ;
            return lnr.getLineNumber();
        } catch (IOException e) {
            logger.error("Ошибка прочтения файла: " + e.getMessage());
        }
        return 0;
    }

    /**
     * Method that set fraction from file
     * @param fractions array of fractions
     * @param filename name of file
     */
    public static void setSimpleFraction(SimpleFraction[] fractions, String filename) throws SimpleFractionException {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            int[] numerators = new int[fractions.length];
            int[] denominators = new int[fractions.length];

            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("/");
                if (parts.length != 2) {
                    throw new InvalidNumberException("Неверная запись дроби в файле: " + line);
                }

                int numerator = Integer.parseInt(parts[0]);
                int denominator = Integer.parseInt(parts[1]);
                if (denominator == 0) {
                    throw new IllegalArgumentException("Знаменатель не может быть 0!");
                }

                numerators[i] = numerator;
                denominators[i] = denominator;
                i++;

            }

            for (int j = 0; j < fractions.length; j++) {
                fractions[j].setDenominator(denominators[j]);
                fractions[j].setNumerator(numerators[j]);
            }

        } catch (IOException | InvalidNumberException e) {
            logger.error("Ошибка прочтения файла: " + e.getMessage());
            throw new SimpleFractionException("Не удалось прочитать всю информацию в файле");
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            throw new SimpleFractionException("Неверная информация");
        }
        catch (OutOfMemoryError e){
            logger.error(e.getMessage());
        }


    }
}
