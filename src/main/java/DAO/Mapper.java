package main.java.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<T> {

    public  String getTable();

    public T mapping(ResultSet rs) throws SQLException;
}
