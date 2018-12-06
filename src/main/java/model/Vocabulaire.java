package main.java.model;

public class Vocabulaire {

    private Integer id;
    private Integer qualite;
    private String valeur;
    private String phrases;
    private String mots;

    public Vocabulaire(){

    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQualite() {
        return qualite;
    }

    public void setQualite(Integer qualite) {
        this.qualite = qualite;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }
}
