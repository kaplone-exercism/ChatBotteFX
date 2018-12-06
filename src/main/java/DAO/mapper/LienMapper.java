package main.java.DAO.mapper;

import main.java.DAO.Mapper;
import main.java.model.Lien;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LienMapper implements Mapper<Lien> {

    Lien element = null;
    String table = "LIEN";

    @Override
    public String getTable() {
        return table;
    }

    @Override
    public Lien mapping(ResultSet rs) throws SQLException {
        element = new Lien();
        element.setId(rs.getInt("ID"));
        element.setQualite(rs.getInt("QUALITE"));
        element.setIdVocabulaireRequete(rs.getInt("ID_VOCABULAIRE_REQUETE"));
        element.setIdVocabulaireReponse(rs.getInt("ID_VOCABULAIRE_REPONSE"));
        element.setCompte(rs.getInt("COMPTE"));
        return element;
    }
}
