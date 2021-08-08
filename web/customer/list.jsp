<%-- 
    Document   : customer
    Created on : Feb 15, 2019, 4:39:53 PM
    Author     : Administrator
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="bd.edu.diu.webstore.model.Customer"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<a href="MainAction">Main</a> | <a href="CustomerAction">Customer List</a> | <a href="ProductAction">Product List</a> | <a href="CartAction">Your Cart</a>

<h1>Customer List:</h1>

<%
    ArrayList<Customer> customers = (  ArrayList<Customer>)session.getAttribute("customers"); //get HashMap from Application Context
    
    out.write("<a href='CustomerAction?input' style='text-decoration: none; display: inline-block; color: green; margin: 20px; padding: 10px; background: yellow'/> Add New Customer </a>");
    out.write("<table border='1'>");
    out.write("<tr><th>ID</th><th>Name</th><th>Phone</th><th>Email</th><th>Addres</th><th>Action</td></tr>");
    
    for (Customer customer : customers) {
        out.write("<tr>");
        out.println("<td>"+customer.getcID()+"</td>");
        out.println("<td>" +customer.getcName()+ "</td>");
        out.println("<td>"+customer.getPhone()+"</td>");
        out.println("<td>"+customer.getEmail()+"</td>");
        out.println("<td>"+customer.getAddress()+"</td>");
        out.println("<td><a href='CustomerAction?edit="+customer.getcID()+"'>Edit</a> | <a href='CustomerAction?delete="+customer.getcID()+"'> Delete </a></td>");
        out.write("</tr>");

    }
    
    out.write("</table>");
%>