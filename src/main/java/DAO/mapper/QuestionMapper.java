package DAO.mapper;

import DAO.Mapper;
import model.Question;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements Mapper<Question> {

    Question element = null;
    String table = "QUESTION";

    @Override
    public String getTable() {
        return table;
    }

    @Override
    public Question mapping(ResultSet rs) throws SQLException {
        element = new Question();
        element.setId(rs.getInt("ID"));
        element.setTexte(rs.getString("TEXTE"));
        return element;
    }
}
