package by.vladsimonenko.secondlab.variantA;

import java.util.Date;

/**
 * Class in which the task is performed.
 *
 * @author Симоненко В.А.
 * @version 1.0
 */

public class Main {

    /**
     * Main method. It looks for the number of significant zeros in the binary representation of a number.
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        int number;
        int numberForPrint;
        number = 129;
        numberForPrint = number;
        int amountZeroes;
        int amountUnits = 0;
        int amount = 0;

        while (number > 0) {
            amount++;
            amountUnits += number % 2;
            number /= 2;
        }
        amountZeroes = amount - amountUnits;
        System.out.println("Количество значащих нулей числа " + numberForPrint + ": " + amountZeroes);

        Date date = new Date();
        System.out.println();
        System.out.println("Разработчик: Симоненко В.А.");
        System.out.println("Задание получено: Sat Feb 11 09:45:00 MSK 2023 ");
        System.out.println("Дата сдачи задания: " + date);
    }

}
