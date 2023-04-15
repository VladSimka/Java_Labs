package by.vladsimonenko.ninthlab.variantD.action;

import by.vladsimonenko.ninthlab.variantD.entity.Sentence;
import by.vladsimonenko.ninthlab.variantD.entity.Word;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class - action for sentence
 */
public class SentenceAction {
    /**
     * Method that finds all sentences in text
     * @param text current text
     * @return list of sentences
     */
    public  static List<Sentence> wordsFromText(String text) {
        List<Sentence> result = new ArrayList<>();

        text = text.replaceAll("\\p{Blank}{2,}", " ");
        String[] arr = text.split("\\.");

        Set<String> stringSet = new HashSet<>();


        for (int i = 0; i < arr.length-1; i++) {
            if (stringSet.add(arr[i].toLowerCase())) {
                result.add(new Sentence(arr[i].substring(1)));
            }
        }

        return result;
    }

}
