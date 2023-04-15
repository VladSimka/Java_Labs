package by.vladsimonenko.ninthlab.variantD.action;

import by.vladsimonenko.ninthlab.variantD.entity.Symbol;
import by.vladsimonenko.ninthlab.variantD.entity.Word;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class - action for symbol
 */
public class SymbolAction {
    /**
     * Method that finds all symbols in text
     * @param text current text
     * @return list of symbols
     */
    public static List<Symbol> symbolsFromText(String text) {
        List<Symbol> result = new ArrayList<>();

        String[] arr = text.split("");

        Set<String> symbolSet = new HashSet<>();


        for (int i = 0; i < arr.length; i++) {
            if (symbolSet.add(arr[i].toLowerCase())) {
                result.add(new Symbol(arr[i]));
            }
        }

        return result;
    }
}
