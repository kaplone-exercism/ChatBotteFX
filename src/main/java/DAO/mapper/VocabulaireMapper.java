package DAO.mapper;

import DAO.Mapper;
import model.Question;
import model.Vocabulaire;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VocabulaireMapper implements Mapper<Vocabulaire> {

    Vocabulaire element = null;
    String table = "VOCABULAIRE";

    @Override
    public String getTable() {
        return table;
    }

    @Override
    public Vocabulaire mapping(ResultSet rs) throws SQLException {
        element = new Vocabulaire();
        element.setId(rs.getInt("ID"));
        element.setValeur(rs.getString("VALEUR"));
        element.setQualite(rs.getInt("QUALITE"));
        element.setMots(rs.getString("MOT"));
        element.setPhrases(rs.getString("PHRASE"));
        return element;
    }
}
