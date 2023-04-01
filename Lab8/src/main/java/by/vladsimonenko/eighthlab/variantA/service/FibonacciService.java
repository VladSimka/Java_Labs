package by.vladsimonenko.eighthlab.variantA.service;

/**
 * Functional interface that provides method that works with Fibonacci number
 */
@FunctionalInterface
public interface FibonacciService {
    /**
     * Method that check if number is Fibonacci
     *
     * @param number current number
     * @return true, if number is Fibonacci,
     * else false
     */
    boolean isFibonacciNumber(int number);
}
