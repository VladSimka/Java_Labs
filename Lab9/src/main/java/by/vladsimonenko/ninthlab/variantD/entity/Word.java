package by.vladsimonenko.ninthlab.variantD.entity;

/**
 * Class that represents word
 */
public class Word {
    String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Word() {
        super();
    }

    @Override
    public String toString() {
        return word;
    }
}
