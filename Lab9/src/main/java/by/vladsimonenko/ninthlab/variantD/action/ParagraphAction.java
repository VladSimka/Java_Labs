package by.vladsimonenko.ninthlab.variantD.action;

import by.vladsimonenko.ninthlab.variantD.entity.Paragraph;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class - action for paragraph
 */
public class ParagraphAction {
    /**
     * Method that finds all paragraphs in text
     * @param text current text
     * @return list of paragraphs
     */
    public static List<Paragraph> wordsFromText(String text) {
        List<Paragraph> result = new ArrayList<>();

        String[] arr = text.split("\\s{2,}");

        Set<String> paragraphsSet = new HashSet<>();


        for (int i = 1; i < arr.length; i++) {
            if (paragraphsSet.add(arr[i].toLowerCase())) {
                result.add(new Paragraph(arr[i]));
            }
        }

        return result;
    }

}
