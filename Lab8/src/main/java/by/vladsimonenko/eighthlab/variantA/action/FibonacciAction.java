package by.vladsimonenko.eighthlab.variantA.action;

import by.vladsimonenko.eighthlab.variantA.service.FibonacciService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.NoSuchElementException;
import java.util.Scanner;


/**
 * Class - action that works with Fibonacci numbers
 */

public class FibonacciAction {
    static final Logger logger = LogManager.getLogger();


    public void fibonacciAction(FibonacciService service) {

        while (true) {
            System.out.println("Введите число для проверки на число Фибоначчи(-1 , чтобы выйти):");
            Scanner scanner = new Scanner(System.in);
            try {

                int number = scanner.nextInt();
                if (number < -1) {
                    throw new IllegalArgumentException("Не допускаются отрицательные числа");
                }

                if (service.isFibonacciNumber(number)) {
                    logger.info(number + " является числом Фибоначчи");
                } else if (number == -1) {
                    break;
                } else {
                    logger.info(number + " не является чилом Фибоначчи");
                }


            } catch (IllegalArgumentException | NoSuchElementException e) {
                logger.error(e.getMessage());
            }


        }


    }
}
