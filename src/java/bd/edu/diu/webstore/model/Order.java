/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.diu.webstore.model;

import java.util.Date;

/**
 *
 * @author bashar
 */
public class Order {
    private int orderID;
    private int cID;
    private Date orderDate;
    private String orderType;
    private double amount;
    private double discount;
    private double tax;

    public Order() {
        
    }

    public Order(int orderID, int cID, Date orderDate, String orderType, double amount, double discount, double tax) {
        this.orderID = orderID;
        this.cID = cID;
        this.orderDate = orderDate;
        this.orderType = orderType;
        this.amount = amount;
        this.discount = discount;
        this.tax = tax;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getcID() {
        return cID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getOrderType() {
        return orderType;
    }

    public double getAmount() {
        return amount;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTax() {
        return tax;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
    
    
}
