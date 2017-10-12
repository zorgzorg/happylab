package kz.epam.happylab.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static kz.epam.happylab.util.Constant.*;

public class Probe {
    private int id;
    private int orderId;
    private int number;
    private int numberLab;
    private int numberCustomer;
    private Date dateReceiving;
    private String name;
    private String pointSampling;
    private Date dateSampling;
    private String remark;
    private List<Probe> probes;
    private List<Order> orders;
    private int filterOrder;

    public Probe() {
    }

    public Probe(ResultSet rs) throws SQLException {
        this.id = rs.getInt(ID);
        this.orderId = rs.getInt(ORDER_ID);
        this.number = rs.getInt(NUMBER);
        this.numberLab = rs.getInt(NUMBER_LAB);
        this.numberCustomer = rs.getInt(NUMBER_CUSTOMER);
        this.dateReceiving = rs.getDate(DATE_RECEIVING);
        this.name = rs.getString(NAME);
        this.pointSampling = rs.getString(POINT_SAMPLING);
        this.dateSampling = rs.getDate(DATE_SAMPLING);
        this.remark = rs.getString(REMARK);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberLab() {
        return numberLab;
    }

    public void setNumberLab(int numberLab) {
        this.numberLab = numberLab;
    }

    public int getNumberCustomer() {
        return numberCustomer;
    }

    public void setNumberCustomer(int numberCustomer) {
        this.numberCustomer = numberCustomer;
    }

    public Date getDateReceiving() {
        return dateReceiving;
    }

    public void setDateReceiving(Date dateReceiving) {
        this.dateReceiving = dateReceiving;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPointSampling() {
        return pointSampling;
    }

    public void setPointSampling(String pointSampling) {
        this.pointSampling = pointSampling;
    }

    public Date getDateSampling() {
        return dateSampling;
    }

    public void setDateSampling(Date dateSampling) {
        this.dateSampling = dateSampling;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Probe> getProbes() {
        return probes;
    }

    public void setProbes(List<Probe> probes) {
        this.probes = probes;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public int getFilterOrder() {
        return filterOrder;
    }

    public void setFilterOrder(int filterOrder) {
        this.filterOrder = filterOrder;
    }


}
