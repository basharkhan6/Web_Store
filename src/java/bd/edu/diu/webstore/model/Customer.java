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
public class Customer {
    private int cID;
    private String cName;
    private String phone;
    private String email;
    private String address;
    
    public Customer(){
        
    }
    
    public Customer(int cID, String cName, String phone, String email, String address) {
        this.cID = cID;
        this.cName = cName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
    public int getcID() {
        return cID;
    }

    public String getcName() {
        return cName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Customer{" + "cID=" + cID + ", cName=" + cName + ", phone=" + phone + ", email=" + email + ", address=" + address + '}';
    }  
    
}
