package model;

public class Vocabulaire {

    private String phrases;
    private String mots;

    public Vocabulaire(String phrases) {
        this.phrases = phrases;
    }

    public Vocabulaire(String phrases, String mots) {
        this.phrases = phrases;
        this.mots = mots;
    }

    public String getPhrases() {
        return phrases;
    }

    public void setPhrases(String phrases) {
        this.phrases = phrases;
    }

    public String getMots() {
        return mots;
    }

    public void setMots(String mots) {
        this.mots = mots;
    }
}
