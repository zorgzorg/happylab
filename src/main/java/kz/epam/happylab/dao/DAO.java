package kz.epam.happylab.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO <T> {
    int insert(T t) throws SQLException;
    void update(T t) throws SQLException;
    void delete(T t) throws SQLException;
    List<T> findAll() throws SQLException;
    T findById(int id) throws SQLException;
}
