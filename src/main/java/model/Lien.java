package model;

public class Lien {

    private Integer id;
    private Integer qualite;
    private Integer idVocabulaireRequete;
    private Integer idVocabulaireReponse;
    private Integer compte;

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

    public Integer getIdVocabulaireRequete() {
        return idVocabulaireRequete;
    }

    public void setIdVocabulaireRequete(Integer idVocabulaireRequete) {
        this.idVocabulaireRequete = idVocabulaireRequete;
    }

    public Integer getIdVocabulaireReponse() {
        return idVocabulaireReponse;
    }

    public void setIdVocabulaireReponse(Integer idVocabulaireReponse) {
        this.idVocabulaireReponse = idVocabulaireReponse;
    }

    public Integer getCompte() {
        return compte;
    }

    public void setCompte(Integer compte) {
        this.compte = compte;
    }
}
