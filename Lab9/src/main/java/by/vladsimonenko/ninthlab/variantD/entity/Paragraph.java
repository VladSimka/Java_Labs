package by.vladsimonenko.ninthlab.variantD.entity;

/**
 * Class that represents paragraph
 */
public class Paragraph {
    String paragraph;

    public Paragraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public Paragraph() {
        super();
    }

    @Override
    public String toString() {
        return paragraph;
    }
}
