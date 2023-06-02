package by.vladsimonenko.twelfthlab.entity;

public class Word extends Entity {
    private String belarusianWord;
    private String englishWord;

    public Word(String englishWord, String belarusianWord) {
        this.belarusianWord = belarusianWord;
        this.englishWord = englishWord;
    }

    public String getBelarusianWord() {
        return belarusianWord;
    }

    public void setBelarusianWord(String belarusianWord) {
        this.belarusianWord = belarusianWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }
}
