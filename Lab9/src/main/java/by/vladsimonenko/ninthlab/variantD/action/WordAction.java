package by.vladsimonenko.ninthlab.variantD.action;

import by.vladsimonenko.ninthlab.variantD.entity.Word;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class - action for word
 */
public class WordAction {
    /**
     * Method that finds all words in text
     * @param text current text
     * @return list of words
     */
    public static List<Word> wordsFromText(String text) {
        List<Word> result = new ArrayList<>();

        text = text.replaceAll("\\p{Punct}", "");
        text = text.replaceAll("—", " ");
        text = text.replaceAll("-", " ");
        String[] arr = text.split("\\s+");

        Set<String> stringSet = new HashSet<>();


        for (int i = 1; i < arr.length; i++) {
            if (stringSet.add(arr[i].toLowerCase())) {
                result.add(new Word(arr[i]));
            }
        }

        return result;
    }
}
