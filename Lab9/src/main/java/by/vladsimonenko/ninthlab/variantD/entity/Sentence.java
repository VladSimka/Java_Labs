package by.vladsimonenko.ninthlab.variantD.entity;

/**
 * Class that represents sentence
 */
public class Sentence {
    String sentence;

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Sentence() {
        super();
    }

    @Override
    public String toString() {
        return sentence;
    }
}
