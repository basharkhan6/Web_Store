<%-- 
    Document   : product
    Created on : Feb 17, 2019, 10:02:32 PM
    Author     : bashar
--%>

<%@page import="bd.edu.diu.webstore.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bd.edu.diu.webstore.dao.ProductDAOimplement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<a href="MainAction">Main</a> | <a href="CustomerAction">Customer List</a> | <a href="ProductAction">Product List</a> | <a href="CartAction">Your Cart</a>

<h1>Product List:</h1>
<%
    ArrayList<Product> al = (ArrayList<Product>)request.getSession().getAttribute("products");

    out.write("<a href='ProductAction?input' style='text-decoration: none; display: inline-block; color: green; margin: 20px; padding: 10px; background: yellow'/> Add New Product </a>");
    out.write("<table border='1'");
    out.write("<tr><th>ID</th><th>Name</th><th>Price</th><th>Quantity</th><th>Reorder</th><th>Action</td></tr>");
    
    for(Product product: al){
        out.write("<tr>");
        out.write("<td>"+product.getpID()+"</td>");
        out.write("<td>"+product.getpName()+"</td>");
        out.write("<td>"+product.getPrice()+"</td>");
        out.write("<td>"+product.getQuantity()+"</td>");
        out.write("<td>"+product.getReorder()+"</td>");
        out.println("<td><a href='ProductAction?edit="+product.getpID()+"'>Edit</a> | <a href='ProductAction?delete="+product.getpID()+"'> Delete </a></td>");
        out.write("</tr>");
    }
    
    out.write("</table>");
%>

