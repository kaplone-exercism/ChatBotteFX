package main.java.DAO.mapper;

import main.java.DAO.Mapper;
import main.java.model.Reponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReponseMapper implements Mapper<Reponse> {

    Reponse element = null;
    String table = "REPONSE";

    @Override
    public String getTable() {
        return table;
    }

    @Override
    public Reponse mapping(ResultSet rs) throws SQLException {
        element = new Reponse();
        element.setId(rs.getInt("ID"));
        element.setTexte(rs.getString("TEXTE"));
        element.setIdType(rs.getInt("ID_TYPE"));
        return element;
    }
}
