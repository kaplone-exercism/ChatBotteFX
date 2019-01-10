package util;

import DAO.Check;
import DAO.Mapper;
import DAO.mapper.QuestionMapper;
import DAO.Reader;
import model.Question;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class SQLiteJDBCTest {


    @Test
    public void isTablePresenteTestFalse(){
        assertFalse(Check.isTablePresente("REPONSES"));
    }

    @Test
    public void isTablePresenteTestTrue(){
        assertTrue(Check.isTablePresente("REPONSE"));
    }

    @Test
    public void getQuestionTest(){
        Reader reader = new Reader();
        Mapper<Question> mapper = new QuestionMapper();
        Question question = reader.getElement("ID = 1", mapper);
        System.out.println(question.getTexte());
    }
}
