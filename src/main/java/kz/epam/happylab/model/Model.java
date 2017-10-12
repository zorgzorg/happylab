package kz.epam.happylab.model;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

public interface Model <T>{
    T show(Connection connection, HttpServletRequest request);
    T add(Connection connection, HttpServletRequest request);
    T edit(Connection connection, HttpServletRequest request);
    T apply(Connection connection, HttpServletRequest request);
    T delete(Connection connection, HttpServletRequest request);
}
