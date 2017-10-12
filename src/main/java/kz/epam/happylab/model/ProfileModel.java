package kz.epam.happylab.model;

import kz.epam.happylab.action.LoginAction;
import kz.epam.happylab.dao.UserDAO;
import kz.epam.happylab.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;

import static kz.epam.happylab.util.Constant.*;

public class ProfileModel implements Model{
    private final static Logger logger = Logger.getLogger(LoginAction.class);

    public ProfileModel() {
    }

    @Override
    public User show(Connection connection, HttpServletRequest request) {
        return edit(connection, request);
    }

    @Override
    public User add(Connection connection, HttpServletRequest request) {
        throw new UnsupportedOperationException();
    }

    @Override
    public User edit(Connection connection, HttpServletRequest request) {
        User user = new User();
        int userId = getUserID(request);

        try {
            UserDAO userDAO = new UserDAO(connection);
            user = userDAO.findById(userId);
        } catch (SQLException e) {
           logger.error(e);
        }
        return user;
    }

    @Override
    public User apply(Connection connection, HttpServletRequest request) {
        User user = new User();
        int userId = getUserID(request);

        try {
            UserDAO userDAO = new UserDAO(connection);
            user.setId(userId);
            user.setName(request.getParameter(NAME).trim());
            user.setUsername(request.getParameter(USERNAME).trim());
            user.setEmail(request.getParameter(EMAIL).trim());
            user.setPassword(request.getParameter(PASSWORD).trim());
            userDAO.updateProfile(user);
            user = userDAO.findById(userId);
        } catch (SQLException e) {
           logger.error(e);
        }

        return user;
    }

    @Override
    public User delete(Connection connection, HttpServletRequest request) {
        throw new UnsupportedOperationException();
    }

    private int getUserID(HttpServletRequest request){
        int userId=ZERO;

        if (request.getSession().getAttribute(USER) != null) {
            User user = (User) request.getSession().getAttribute(USER);
            userId = user.getId();
        }

        return  userId;
    }
}
