package by.vladsimonenko.tenth.variantA._main;

import by.vladsimonenko.tenth.variantA.action.SetAction;
import by.vladsimonenko.tenth.variantA.action.TextAction;
import by.vladsimonenko.tenth.variantA.reader.TextReader;

/**
 * Class with main method for variant A
 */
public class SetMain {
    public static void main(String[] args) {
        TextAction textAction = new TextAction();
        TextReader reader = new TextReader();
        SetAction action = new SetAction();
        String text = reader.readTextFromFile("data/variantA.txt");
        String[] arr = textAction.textToArray(text);


        action.findAllUniqueWords(arr);

        System.out.println();

    }
}
