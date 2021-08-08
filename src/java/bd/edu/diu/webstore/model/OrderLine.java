/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.diu.webstore.model;

/**
 *
 * @author bashar
 */
public class OrderLine {
    private int lineID;
    private int orderID;
    private int pID;
    private double price;
    private int quantity;
    private int lineTotal;

    public OrderLine() {
        
    }

    public OrderLine(int lineID, int orderID, int pID, double price, int quantity, int lineTotal) {
        this.lineID = lineID;
        this.orderID = orderID;
        this.pID = pID;
        this.price = price;
        this.quantity = quantity;
        this.lineTotal = lineTotal;
    }

    public int getLineID() {
        return lineID;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getpID() {
        return pID;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getLineTotal() {
        return lineTotal;
    }

    public void setLineID(int lineID) {
        this.lineID = lineID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setLineTotal(int lineTotal) {
        this.lineTotal = lineTotal;
    }
    
    
}
