package kz.epam.happylab.model;

import kz.epam.happylab.action.LoginAction;
import kz.epam.happylab.dao.OrderDAO;
import kz.epam.happylab.dao.ProbeDAO;
import kz.epam.happylab.entity.Order;
import kz.epam.happylab.entity.Probe;
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

public class ProbeModel implements Model {
    private final static Logger logger = Logger.getLogger(LoginAction.class);

    public ProbeModel() {
    }

    @Override
    public Probe show(Connection connection, HttpServletRequest request) {
        Probe probe = new Probe();
        int filter_order = ParameterRequest.getParameter(request, FILTER_ORDER);

        try{
            ProbeDAO probeDAO = new ProbeDAO(connection);
            List<Probe> probes = probeDAO.findAll(filter_order);
            probe.setProbes(probes);
            probe.setOrders(getOrders(connection));
            probe.setFilterOrder(filter_order);
        } catch (SQLException e) {
           logger.error(e);
        }
        return probe;
    }
    
    @Override
    public Probe add(Connection connection, HttpServletRequest request) {
        Probe probe = new Probe();
        int filter_order = ParameterRequest.getParameter(request, FILTER_ORDER);

        probe.setId(0);
        probe.setOrderId(filter_order);
        probe.setDateReceiving(new Date());
        probe.setOrders(getOrders(connection));
        probe.setFilterOrder(filter_order);
        return probe;
    }
    
    @Override
    public Probe edit(Connection connection, HttpServletRequest request) {
        Probe probe = new Probe();
        int probeId = ParameterRequest.getParameter(request, PROBE_ID);
        int filter_order = ParameterRequest.getParameter(request, FILTER_ORDER);

        try {
            ProbeDAO probeDAO = new ProbeDAO(connection);
            probe = probeDAO.findById(probeId);
            probe.setOrders(getOrders(connection));
            probe.setFilterOrder(filter_order);
        } catch (SQLException e) {
           logger.error(e);
        }
        return probe;
    }

    @Override
    public Probe apply(Connection connection, HttpServletRequest request) {
        Probe probe = new Probe();
        int probeId = ParameterRequest.getParameter(request, PROBE_ID);
        int orderId = ParameterRequest.getParameter(request, ORDER_ID);
        int filter_order = ParameterRequest.getParameter(request, FILTER_ORDER);
        String action = APPLY;

        if (request.getParameter(ACTION) != null) {
            action = request.getParameter(ACTION);
        }

        try {
            ProbeDAO probeDAO = new ProbeDAO(connection);
            probe.setId(probeId);
            probe.setOrderId(orderId);
            probe.setNumberLab(Integer.parseInt(request.getParameter(NUMBER_LAB).trim()));
            probe.setNumberCustomer(Integer.parseInt(request.getParameter(NUMBER_CUSTOMER).trim()));
            probe.setDateReceiving(java.sql.Date.valueOf(DateFormatter.formatDate(request.getParameter(DATE_RECEIVING).trim())));
            probe.setPointSampling(request.getParameter(POINT_SAMPLING).trim());
            probe.setDateSampling(java.sql.Date.valueOf(DateFormatter.formatDate(request.getParameter(DATE_SAMPLING).trim())));
            probe.setRemark(request.getParameter(REMARK).trim());

            if (probeId > 0) {
                probeDAO.update(probe);
            }
            else {
                probeId = probeDAO.insert(probe);
            }

            if(SAVE.equalsIgnoreCase(action)) {
                probe = show(connection, request);
            } else {
                probe = probeDAO.findById(probeId);
                probe.setOrders(getOrders(connection));
                probe.setFilterOrder(filter_order);
            }

        } catch (SQLException e) {
           logger.error(e);
        }

        return probe;
    }

    @Override
    public Probe delete(Connection connection, HttpServletRequest request) {
        Probe probe = new Probe();
        int probeId = ParameterRequest.getParameter(request, PROBE_ID);

        try {
            probe.setId(probeId);
            ProbeDAO probeDAO = new ProbeDAO(connection);
            probeDAO.delete(probe);
            probe = show(connection, request);
        } catch (SQLException e) {
           logger.error(e);
        }
        return probe;
    }

    private List<Order> getOrders(Connection connection){
        List<Order> orders = new ArrayList();

        try {
            OrderDAO orderDAO = new OrderDAO(connection);
            orders = orderDAO.findAll();
        } catch (SQLException e) {
           logger.error(e);
        }
        return orders;
    }
}
