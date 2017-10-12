package kz.epam.happylab.model;

import kz.epam.happylab.action.LoginAction;
import kz.epam.happylab.dao.UserDAO;
import kz.epam.happylab.dao.UsertypeDAO;
import kz.epam.happylab.entity.User;
import kz.epam.happylab.entity.Usertype;
import kz.epam.happylab.util.DateFormatter;
import kz.epam.happylab.util.ParameterRequest;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static kz.epam.happylab.util.Constant.*;

public class UserModel implements Model {
    private final static Logger logger = Logger.getLogger(LoginAction.class);

    public UserModel() {
    }

    @Override
    public User show(Connection connection, HttpServletRequest request) {
        User user = new User();
        try{
            UserDAO userDAO = new UserDAO(connection);
            List<User> users = userDAO.findAll();
            user.setUsers(users);
        } catch (SQLException e) {
           logger.error(e);
        }
        return user;
    }

    @Override
    public User add(Connection connection, HttpServletRequest request) {
        User user = new User();
        user.setId(ZERO);
        user.setDateRegistration(new Date());
        user.setBlock(ZERO);
        user.setUsertypes(getUsertypes(connection));
        return user;
    }    
    
    @Override
    public User edit(Connection connection, HttpServletRequest request) {
        User user = new User();
        int userId = ParameterRequest.getParameter(request, USER_ID);

        try {
            UserDAO userDAO = new UserDAO(connection);
            user = userDAO.findById(userId);
            user.setUsertypes(getUsertypes(connection));
        } catch (SQLException e) {
           logger.error(e);
        }
        return user;
    }

    @Override
    public User apply(Connection connection, HttpServletRequest request) {
        User user = new User();
        int userId = ParameterRequest.getParameter(request, USER_ID);
        String action = APPLY;

        if (request.getParameter(ACTION) != null) {
            action = request.getParameter(ACTION);
        }

        try {
            UserDAO userDAO = new UserDAO(connection);
            user.setId(userId);
            user.setName(request.getParameter(NAME).trim());
            user.setUsername(request.getParameter(USERNAME).trim());
            user.setEmail(request.getParameter(EMAIL).trim());
            user.setPassword(request.getParameter(PASSWORD).trim());

            if(request.getParameter(DATE_REGISTRATION)!= null) {
                user.setDateRegistration(java.sql.Date.valueOf(DateFormatter.formatDate(request.getParameter(DATE_REGISTRATION).trim())));
            }
            if(request.getParameter(USERTYPE)!= null) {
                user.setUsertype(request.getParameter(USERTYPE).trim());
            }
            if(request.getParameter(BLOCK)!= null) {
                user.setBlock(Integer.parseInt(request.getParameter(BLOCK).trim()));
            }
            if(request.getParameter(REMARK)!= null) {
                user.setRemark(request.getParameter(REMARK).trim());
            }

            if (userId > ZERO) {
                userDAO.update(user);
            }
            else {
                userId = userDAO.insert(user);
            }

            if(SAVE.equalsIgnoreCase(action)) {
                user = show(connection, request);
            } else {
                user = userDAO.findById(userId);
                user.setUsertypes(getUsertypes(connection));
            }

        } catch (SQLException e) {
           logger.error(e);
        }

        return user;
    }

    @Override
    public User delete(Connection connection, HttpServletRequest request) {
        User user = new User();
        int userId = ParameterRequest.getParameter(request, USER_ID);

        try {
            user.setId(userId);
            UserDAO userDAO = new UserDAO(connection);
            userDAO.delete(user);
            user = show(connection, request);
        } catch (SQLException e) {
           logger.error(e);
        }
        return user;
    }

    public User saveBlock(Connection connection, HttpServletRequest request) {
        User user = new User();
        int userId = ParameterRequest.getParameter(request, USER_ID);

        try {
            UserDAO userDAO = new UserDAO(connection);
            user.setId(userId);
            user.setBlock(Integer.parseInt(request.getParameter(BLOCK).trim()));
            userDAO.updateBlock(user);
            user = show(connection, request);
        } catch (SQLException e) {
           logger.error(e);
        }

        return user;
    }

    private List<Usertype> getUsertypes(Connection connection){
        List<Usertype> usertype = new ArrayList<>();
        try {
            UsertypeDAO usertypeDAO = new UsertypeDAO(connection);
            usertype = usertypeDAO.findAll();
        } catch (SQLException e) {
           logger.error(e);
        }
        return usertype;
    }
}
