package by.vladsimonenko.ninthlab.variantD.entity;

/**
 * Class that represents punctuation mark
 */
public class PunctuationMark {
    String punctuationMark;

    public PunctuationMark(String punctuationMark) {
        this.punctuationMark = punctuationMark;
    }

    public String getPunctuationMark() {
        return punctuationMark;
    }

    public void setPunctuationMark(String punctuationMark) {
        this.punctuationMark = punctuationMark;
    }

    public PunctuationMark() {
        super();
    }

    @Override
    public String toString() {
        return punctuationMark;
    }
}
