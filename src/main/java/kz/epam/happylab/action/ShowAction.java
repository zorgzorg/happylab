package kz.epam.happylab.action;

import kz.epam.happylab.connection.ConnectionPool;
import kz.epam.happylab.model.Model;
import kz.epam.happylab.model.ModelFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;

import static kz.epam.happylab.util.Constant.*;

public class ShowAction implements Action{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        String option = request.getParameter(OPTION);
        String view;

        if(option != null) {
            ConnectionPool pool;
            Connection connection;
            String layout = FORM_LAYOUT;

            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();

            Model model = ModelFactory.createModel(option);
            Object data = model.show(connection, request);

            request.setAttribute(DATA, data);
            pool.releaseConnection(connection);
            view = BASE_PATH + option + layout;
        } else {
            view = LOGIN_PATH;
        }

        return view;
    }
}
