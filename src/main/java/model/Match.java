package main.java.model;

public class Match {

    private Integer id;
    private Integer qualite;
    private Integer idQuestion;
    private Integer idReponse;

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

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Integer getIdReponse() {
        return idReponse;
    }

    public void setIdReponse(Integer idReponse) {
        this.idReponse = idReponse;
    }
}
