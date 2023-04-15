package by.vladsimonenko.ninthlab.variantD.action;

import by.vladsimonenko.ninthlab.variantD.entity.Paragraph;
import by.vladsimonenko.ninthlab.variantD.entity.PunctuationMark;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class - action for punctuation mark
 */
public class PunctuationMarkAction {

    /**
     * Method that finds all punctuations marks in text
     * @param text current text
     * @return list of punctuation marks
     */
    public static List<PunctuationMark> punctuationMarksFromText(String text) {
        List<PunctuationMark> result = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\p{Punct}");
        Matcher matcher = pattern.matcher(text);
        Set<String> marksSet = new HashSet<>();

        while (matcher.find()) {
            String r = matcher.group();
            if (marksSet.add(r.toLowerCase())) {
                result.add(new PunctuationMark(r));
            }
        }

        return result;
    }
}
