package kz.epam.happylab.model;

import kz.epam.happylab.action.LoginAction;
import kz.epam.happylab.dao.EmployeeDAO;
import kz.epam.happylab.dao.PositionDAO;
import kz.epam.happylab.entity.Employee;
import kz.epam.happylab.entity.Position;
import kz.epam.happylab.util.ParameterRequest;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kz.epam.happylab.util.Constant.*;

public class EmployeeModel implements Model {
    private final static Logger logger = Logger.getLogger(LoginAction.class);

    public EmployeeModel() {
    }

    @Override
    public Employee show(Connection connection, HttpServletRequest request) {
        Employee employee = new Employee();
        try{
            EmployeeDAO employeeDAO = new EmployeeDAO(connection);
            List<Employee> employees = employeeDAO.findAll();
            employee.setEmployees(employees);
        } catch (SQLException e) {
           logger.error(e);
        }
        return employee;
    }

    @Override
    public Employee add(Connection connection, HttpServletRequest request) {
        Employee employee = new Employee();
        employee.setId(ZERO);
        employee.setPositions(getPositions(connection));
        return employee;
    }

    @Override
    public Employee edit(Connection connection, HttpServletRequest request) {
        Employee employee = new Employee();
        int employeeId = ParameterRequest.getParameter(request, EMPLOYEE_ID);

        try {
            EmployeeDAO employeeDAO = new EmployeeDAO(connection);
            employee = employeeDAO.findById(employeeId);
            employee.setPositions(getPositions(connection));
        } catch (SQLException e) {
           logger.error(e);
        }
        return employee;
    }

    @Override
    public Employee apply(Connection connection, HttpServletRequest request) {
        Employee employee = new Employee();
        int employeeId = ParameterRequest.getParameter(request, EMPLOYEE_ID);
        int positionId = ParameterRequest.getParameter(request, POSITION_ID);
        String action = APPLY;

        if (request.getParameter(ACTION) != null) {
            action = request.getParameter(ACTION);
        }

        try {
            EmployeeDAO employeeDAO = new EmployeeDAO(connection);
            employee.setId(employeeId);
            employee.setLastname(request.getParameter(LASTNAME).trim());
            employee.setName(request.getParameter(NAME).trim());
            employee.setSurname(request.getParameter(SURNAME).trim());
            employee.setPositionId(positionId);
            employee.setAssistant(Integer.parseInt(request.getParameter(ASSISTANT).trim()));
            employee.setSignature(Integer.parseInt(request.getParameter(SIGNATURE).trim()));
            employee.setRemark(request.getParameter(REMARK).trim());

            if (employeeId > ZERO) {
                employeeDAO.update(employee);
            }
            else {
                employeeId = employeeDAO.insert(employee);
            }

            if(SAVE.equalsIgnoreCase(action)) {
                employee = show(connection, request);
            } else {
                employee = employeeDAO.findById(employeeId);
                employee.setPositions(getPositions(connection));
            }

        } catch (SQLException e) {
           logger.error(e);
        }

        return employee;
    }

    public Employee saveAssistant(Connection connection, HttpServletRequest request) {
        Employee employee = new Employee();
        int employeeId = ParameterRequest.getParameter(request, EMPLOYEE_ID);

        try {
            EmployeeDAO employeeDAO = new EmployeeDAO(connection);
            employee.setId(employeeId);
            employee.setAssistant(Integer.parseInt(request.getParameter(ASSISTANT).trim()));
            employeeDAO.updateAssistant(employee);
            employee = show(connection, request);
        } catch (SQLException e) {
           logger.error(e);
        }

        return employee;
    }

    public Employee saveSignature(Connection connection, HttpServletRequest request) {
        Employee employee = new Employee();
        int employeeId = ParameterRequest.getParameter(request, EMPLOYEE_ID);

        try {
            EmployeeDAO employeeDAO = new EmployeeDAO(connection);
            employee.setId(employeeId);
            employee.setSignature(Integer.parseInt(request.getParameter(SIGNATURE).trim()));
            employeeDAO.updateSignature(employee);
            employee = show(connection, request);
        } catch (SQLException e) {
           logger.error(e);
        }

        return employee;
    }

    @Override
    public Employee delete(Connection connection, HttpServletRequest request) {
        Employee employee = new Employee();
        int employeeId = ParameterRequest.getParameter(request, EMPLOYEE_ID);

        try {
            employee.setId(employeeId);
            EmployeeDAO employeeDAO = new EmployeeDAO(connection);
            employeeDAO.delete(employee);
            employee = show(connection, request);
        } catch (SQLException e) {
           logger.error(e);
        }
        return employee;
    }

    private List<Position> getPositions(Connection connection){
        List<Position> positions = new ArrayList<>();
        try {
            PositionDAO positionDAO = new PositionDAO(connection);
            positions = positionDAO.findAll();
        } catch (SQLException e) {
           logger.error(e);
        }
        return positions;
    }
}
