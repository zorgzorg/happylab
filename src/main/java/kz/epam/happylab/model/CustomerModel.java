package kz.epam.happylab.model;

import kz.epam.happylab.action.LoginAction;
import kz.epam.happylab.dao.CustomerDAO;
import kz.epam.happylab.entity.Customer;
import kz.epam.happylab.util.ParameterRequest;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static kz.epam.happylab.util.Constant.*;

public class CustomerModel implements Model {
    private final static Logger logger = Logger.getLogger(LoginAction.class);

    public CustomerModel() {
    }

    @Override
    public Customer show(Connection connection, HttpServletRequest request) {
        Customer customer = new Customer();
        try{
            CustomerDAO customerDAO = new CustomerDAO(connection);
            List<Customer> customers = customerDAO.findAll();
            customer.setCustomers(customers);
        } catch (SQLException e) {
           logger.error(e);
        }
        return customer;
    }

    @Override
    public Customer add(Connection connection, HttpServletRequest request){
        Customer customer = new Customer();
        customer.setId(ZERO);
        return customer;
    }

    @Override
    public Customer edit(Connection connection, HttpServletRequest request){
        Customer customer = new Customer();
        int customerId = ParameterRequest.getParameter(request, CUSTOMER_ID);

        try {
            CustomerDAO customerDAO = new CustomerDAO(connection);
            customer = customerDAO.findById(customerId);
        } catch (SQLException e) {
           logger.error(e);
        }
        return customer;
    }

    @Override
    public Customer apply(Connection connection, HttpServletRequest request) {
        Customer customer = new Customer();
        int customerId = ParameterRequest.getParameter(request, CUSTOMER_ID);
        String action = APPLY;

        if (request.getParameter(ACTION) != null) {
            action = request.getParameter(ACTION);
        }

        try {
            CustomerDAO customerDAO = new CustomerDAO(connection);
            customer.setId(customerId);
            customer.setName(request.getParameter(NAME).trim());
            customer.setCity(request.getParameter(CITY).trim());
            customer.setRemark(request.getParameter(REMARK).trim());

            if (customerId > ZERO) {
                customerDAO.update(customer);
            }
            else {
                customerId = customerDAO.insert(customer);
            }

            if(SAVE.equalsIgnoreCase(action)) {
                customer = show(connection, request);
            } else {
                customer = customerDAO.findById(customerId);
            }

        } catch (SQLException e) {
           logger.error(e);
        }

        return customer;
    }

    @Override
    public Customer delete(Connection connection, HttpServletRequest request){
        Customer customer = new Customer();
        int customerId = ParameterRequest.getParameter(request, CUSTOMER_ID);

        try {
            customer.setId(customerId);
            CustomerDAO customerDAO = new CustomerDAO(connection);
            customerDAO.delete(customer);
            customer = show(connection, request);
        } catch (SQLException e) {
           logger.error(e);
        }
        return customer;
    }
}
