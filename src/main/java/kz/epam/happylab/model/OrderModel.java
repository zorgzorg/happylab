package kz.epam.happylab.model;

import kz.epam.happylab.action.LoginAction;
import kz.epam.happylab.dao.CustomerDAO;
import kz.epam.happylab.dao.DAO;
import kz.epam.happylab.dao.OrderDAO;
import kz.epam.happylab.entity.Customer;
import kz.epam.happylab.entity.Order;
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

public class OrderModel implements Model {
    private final static Logger logger = Logger.getLogger(LoginAction.class);

    public OrderModel() {
    }

    @Override
    public Order show(Connection connection, HttpServletRequest request) {
        int filter_customer = ParameterRequest.getParameter(request, FILTER_CUSTOMER);
        Order order = new Order();

        try{
            OrderDAO orderDAO = new OrderDAO(connection);
            List<Order> orders = orderDAO.findAll(filter_customer);
            order.setOrders(orders);
            order.setCustomers(getCustomers(connection));
            order.setFilter(filter_customer);
        } catch (SQLException e) {
           logger.error(e);
        }

        return order;
    }

    @Override
    public Order add(Connection connection, HttpServletRequest request){
        Order order = new Order();
        int filter_customer = ParameterRequest.getParameter(request, FILTER_CUSTOMER);

        order.setId(ZERO);
        order.setDate(new Date());
        order.setCustomerId(filter_customer);
        order.setCustomers(getCustomers(connection));
        order.setFilter(filter_customer);

        return order;
    }

    @Override
    public Order edit(Connection connection, HttpServletRequest request){
        Order order = new Order();
        int orderId = ParameterRequest.getParameter(request, ORDER_ID);;
        int filter_customer = ParameterRequest.getParameter(request, FILTER_CUSTOMER);

        try {
            OrderDAO orderDAO = new OrderDAO(connection);
            order = orderDAO.findById(orderId);
            order.setCustomers(getCustomers(connection));
            order.setFilter(filter_customer);
        } catch (SQLException e) {
           logger.error(e);
        }

        return order;
    }

    @Override
    public Order apply(Connection connection, HttpServletRequest request){
        Order order = new Order();
        int orderId = ParameterRequest.getParameter(request, ORDER_ID);
        int customerId = ParameterRequest.getParameter(request, CUSTOMER_ID);
        int filter_customer = ParameterRequest.getParameter(request, FILTER_CUSTOMER);
        String action = APPLY;

        if (request.getParameter(ACTION) != null) {
            action = request.getParameter(ACTION);
        }
        
        try {
            OrderDAO orderDAO = new OrderDAO(connection);
            order.setId(orderId);
            order.setCustomerId(customerId);
            order.setNumber(request.getParameter(NUMBER).trim());
            order.setDate(java.sql.Date.valueOf(DateFormatter.formatDate(request.getParameter(DATE).trim())));
            order.setRemark(request.getParameter(REMARK).trim());
            
            if (orderId > ZERO) {
                orderDAO.update(order);
            }
            else {
                orderId = orderDAO.insert(order);
            }

            if(SAVE.equalsIgnoreCase(action)) {
                order = show(connection, request);
            } else {
                order = orderDAO.findById(orderId);
                order.setCustomers(getCustomers(connection));
                order.setFilter(filter_customer);
            }
        } catch (SQLException e) {
           logger.error(e);
        }

        return order;
    }

    @Override
    public Order delete(Connection connection, HttpServletRequest request){
        Order order = new Order();
        int orderId =  ParameterRequest.getParameter(request, ORDER_ID);

        try {
            order.setId(orderId);
            DAO orderDAO = new OrderDAO(connection);
            orderDAO.delete(order);
            order = show(connection, request);
        } catch (SQLException e) {
           logger.error(e);
        }
        return order;
    }

    private List<Customer> getCustomers(Connection connection){
        List<Customer> customers= new ArrayList();

        try {
            CustomerDAO customerDAO = new CustomerDAO(connection);
            customers = customerDAO.findAll();
        } catch (SQLException e) {
           logger.error(e);
        }

        return customers;
    }
}
