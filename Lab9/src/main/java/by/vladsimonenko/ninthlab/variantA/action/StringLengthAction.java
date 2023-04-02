package by.vladsimonenko.ninthlab.variantA.action;

import java.util.*;

public class StringLengthAction {


    public void printWordsWithCurrentLength(String text, int currentLength) {
        text = text.replaceAll("\\p{Punct}", "");
        String[] arr = text.split(" ");
        Arrays.stream(arr)
                .filter(s -> s.length() == currentLength)
                .forEach(s -> System.out.print(s + " "));
    }

    public int maxLengthInText(String text) {
        text = text.replaceAll("\\p{Punct}", "");
        String[] arr = text.split(" ");
        Optional<Integer> max = Arrays.stream(arr)
                .map(String::length)
                .max(Comparator.comparingInt(i -> i));
        return max.get();
    }

    public int minLengthInText(String text) {
        text = text.replaceAll("\\p{Punct}", "");
        String[] arr = text.split(" ");
        Optional<Integer> min = Arrays.stream(arr)
                .map(String::length)
                .min(Comparator.comparingInt(i -> i));
        return min.get();
    }


}
