/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.diu.webstore.model;

/**
 *
 * @author Administrator
 */
public class Product {
    private int pID;
    private String pName;
    private double price;
    private int quantity;
    private int reorder;

    public Product() {
    }
    
    
    public Product(int pID, String pName, double price, int qyantity, int reorder) {
        this.pID = pID;
        this.pName = pName;
        this.price = price;
        this.quantity = qyantity;
        this.reorder = reorder;
    }

    public int getpID() {
        return pID;
    }

    public String getpName() {
        return pName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getReorder() {
        return reorder;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setReorder(int reorder) {
        this.reorder = reorder;
    }

    @Override
    public String toString() {
        return "Product{" + "pID=" + pID + ", pName=" + pName + ", price=" + price + ", quantity=" + quantity + ", reorder=" + reorder + '}';
    }
    
    
}
