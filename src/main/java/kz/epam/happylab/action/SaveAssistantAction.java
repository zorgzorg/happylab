package kz.epam.happylab.action;

import kz.epam.happylab.connection.ConnectionPool;
import kz.epam.happylab.entity.Employee;
import kz.epam.happylab.model.EmployeeModel;
import kz.epam.happylab.model.ModelFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;

import static kz.epam.happylab.util.Constant.*;

public class SaveAssistantAction implements Action {
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        ConnectionPool pool;
        Connection connection;
        String option = request.getParameter(OPTION);
        String view;
        String layout = FORM_LAYOUT;

        pool = ConnectionPool.getInstance();
        connection = pool.takeConnection();

        EmployeeModel employeeModel = (EmployeeModel) ModelFactory.createModel(option);
        Employee data = employeeModel.saveAssistant(connection, request);
        request.setAttribute(DATA, data);

        pool.releaseConnection(connection);
        view = BASE_PATH + option + layout;

        return view;
    }
}