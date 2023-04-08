package by.vladsimonenko.ninthlab.variantC._main;

import by.vladsimonenko.ninthlab.variantC.action.StringConversion;

/**
 * Class with main method for variantC
 */
public class TransformMain {
    public static void main(String[] args) {
        StringConversion action = new StringConversion();
        String input1 = "VJAA";
        String result1 = action.inverseBurrowsWheelerTransform(input1, 3);
        System.out.println("Слово после преобразования = " + input1 + ", исходное слово = " + result1);

        System.out.println();

        String input2 = "LAVD";
        String result2 = action.inverseBurrowsWheelerTransform(input2, 4);
        System.out.println("Слово после преобразования = " + input2 + ", исходное слово = " + result2);

    }
}
