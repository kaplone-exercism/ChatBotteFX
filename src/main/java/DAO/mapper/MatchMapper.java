package main.java.DAO.mapper;

import main.java.DAO.Mapper;
import main.java.model.Match;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MatchMapper implements Mapper<Match> {

    Match element = null;
    String table = "MATCH";

    @Override
    public String getTable() {
        return table;
    }

    @Override
    public Match mapping(ResultSet rs) throws SQLException {
        element = new Match();
        element.setId(rs.getInt("ID"));
        element.setQualite(rs.getInt("QUALITE"));
        element.setIdQuestion(rs.getInt("ID_QUESTION"));
        element.setIdReponse(rs.getInt("ID_REPONSE"));
        return element;
    }
}
