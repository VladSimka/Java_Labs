package by.vladsimonenko.sixlab.variantA.main;

import by.vladsimonenko.sixlab.variantA.service.ReaderWriterAction;

import java.util.Arrays;

/**
 * Class with main method for Variant A
 */
public class ReaderWriterMain {
    // args = data/info_A.txt , data/out.txt;
    public static void main(String[] args) {
        ReaderWriterAction action = new ReaderWriterAction();
        action.findWordsInAFile(args[0], args[1]);

    }
}
