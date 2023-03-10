package by.vladsimonenko.fifthlab._main;

import by.vladsimonenko.fifthlab.action.ReadAction;

/**
 * Main class for variant C
 */
public class ReadMain {
    public static void main(String[] args) {
        ReadAction action = new ReadAction();
        double sum;
        action.sumFromFile("locales.txt");
    }
}
