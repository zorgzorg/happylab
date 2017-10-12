package kz.epam.happylab.action;

import kz.epam.happylab.connection.ConnectionPool;
import kz.epam.happylab.entity.User;
import kz.epam.happylab.model.LoginModel;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static kz.epam.happylab.util.Constant.*;

public class LoginAction implements Action {
    private final static Logger logger = Logger.getLogger(LoginAction.class);
    private static final String UNKNOWN_USER="unknown_user";
    private static final String PROFILE = "profile";

    public LoginAction() {
    }

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException  {
        ConnectionPool pool;
        Connection connection;
        String view = LOGIN_PATH;
        String message = new String();
        User user = null;
        LoginModel model = new LoginModel();

        pool = ConnectionPool.getInstance();
        connection = pool.takeConnection();

        try {
            user = model.authenticate(connection, request);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        }

        if (user.getId() != 0) {
            request.getSession().setAttribute(USER, user);
            request.getSession().setAttribute(DATA, user);
            view = BASE_PATH + PROFILE + FORM_LAYOUT;
        } else {
            message = UNKNOWN_USER;
        }

        request.setAttribute(MESSAGE, message);
        return view;
    }
}


