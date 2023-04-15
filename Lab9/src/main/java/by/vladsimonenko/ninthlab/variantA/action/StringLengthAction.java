package by.vladsimonenko.ninthlab.variantA.action;
import java.util.*;

/**
 * Class - action that works with string
 */
public class StringLengthAction {

    /**
     * Method that prints words with current length
     *
     * @param text          current text
     * @param currentLength current length
     */
    public void printWordsWithCurrentLength(String text, int currentLength) {
        text = text.replaceAll("\\p{Punct}", "");
        String[] arr = text.split("\\s+");

        Arrays.stream(arr)
                .filter(s -> s.length() == currentLength)
                .forEach(s -> System.out.print(s + " "));
    }

    /**
     * Find max length of word in text
     *
     * @param text current text
     * @return max length
     */
    public int maxLengthInText(String text) {
        text = text.replaceAll("\\p{Punct}", "");
        String[] arr = text.split("\\s+");
        Optional<Integer> max = Arrays.stream(arr)
                .map(String::length)
                .max(Comparator.comparingInt(i -> i));
        return max.get();
    }

    /**
     * Find min length of word in text
     *
     * @param text current text
     * @return min length
     */
    public int minLengthInText(String text) {
        text = text.replaceAll("\\p{Punct}", "");
        String[] arr = text.split("\\s+");
        Optional<Integer> min = Arrays.stream(arr)
                .map(String::length)
                .min(Comparator.comparingInt(i -> i));
        return min.get();
    }


}
