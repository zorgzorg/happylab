package kz.epam.happylab.model;

import kz.epam.happylab.dao.UserDAO;
import kz.epam.happylab.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;

import static kz.epam.happylab.util.Constant.*;

public class LoginModel {
    public User authenticate(Connection connection, HttpServletRequest request) throws SQLException {
        String username = request.getParameter(USERNAME);
        String password = request.getParameter(PASSWORD);

        UserDAO userDAO = new UserDAO(connection);
        User user = userDAO.findByLogin(username, password);

        return user;
    }
}
