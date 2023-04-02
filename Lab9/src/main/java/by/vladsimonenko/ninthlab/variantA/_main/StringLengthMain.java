package by.vladsimonenko.ninthlab.variantA._main;

import by.vladsimonenko.ninthlab.variantA.action.StringLengthAction;

public class StringLengthMain {
    public static void main(String[] args) {
        String txt = "Hello, world! How are you? My name is Vlad";

        StringLengthAction action = new StringLengthAction();
        int max = action.maxLengthInText(txt);
        int min = action.minLengthInText(txt);
        System.out.println("Слова максимальной длины: ");
        action.printWordsWithCurrentLength(txt,max);

        System.out.println();

        System.out.println("Слова минимальной длины: ");
        action.printWordsWithCurrentLength(txt,min);

    }
}
