package by.vladsimonenko.ninthlab.variantD._main;

import by.vladsimonenko.ninthlab.variantA.reader.StringReader;
import by.vladsimonenko.ninthlab.variantD.action.*;
import by.vladsimonenko.ninthlab.variantD.entity.*;

import java.util.Arrays;
import java.util.List;

public class TextBookMain {
    public static void main(String[] args) {
        StringReader reader = new StringReader();
        String text = reader.readTextFromFile("data/data_varD.txt");

        List<Symbol> symbolList = SymbolAction.symbolsFromText(text);
        List<Word> wordList = WordAction.wordsFromText(text);
        List<Sentence> sentenceList = SentenceAction.wordsFromText(text);
        List<Paragraph> paragraphList = ParagraphAction.wordsFromText(text);
        List<PunctuationMark> punctuationMarkList = PunctuationMarkAction.punctuationMarksFromText(text);


        System.out.println("Все символы в тексте: ");

        for (int i = 0; i < symbolList.size(); i++) {
            System.out.print(symbolList.get(i) + "  ");
            if ((i + 1) % 25 == 0) {
                System.out.println();
            }
        }

        System.out.println("\n");

        System.out.println("Все слова в тексте: ");

        for (int i = 0; i < wordList.size(); i++) {
            System.out.print(wordList.get(i) + "  ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }

        System.out.println("\n");


        System.out.println("Все предложения в тексте:");
        for (int i = 0; i < sentenceList.size(); i++) {
            System.out.println(i + 1 + ") " + sentenceList.get(i));
        }

        System.out.println("\n");

        System.out.println("Все абзацы в тексте:");
        for (int i = 0; i < paragraphList.size(); i++) {
            System.out.println(i + 1 + ") " + paragraphList.get(i));
        }


        System.out.println("\n");

        System.out.println("Все знаки препинания в тексте:");
        for (int i = 0; i < punctuationMarkList.size(); i++) {
            System.out.print(punctuationMarkList.get(i) + "  ");
            if ((i + 1) % 25 == 0) {
                System.out.println();
            }
        }

    }
}
