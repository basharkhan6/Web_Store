<%-- 
    Document   : main
    Created on : Jan 14, 2019, 7:52:17 PM
    Author     : Administrator
--%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="bd.edu.diu.webstore.model.Product"%>

<a href="MainAction">Main</a> | <a href="CustomerAction">Customer List</a> | <a href="ProductAction">Product List</a> | <a href="CartAction">Your Cart</a>

<h1>Main Action</h1>
<%
    HashMap products = (HashMap)application.getAttribute("products"); //get HashMap from Application Context
    Iterator it = products.values().iterator();  //read values of products sequencially
    out.write("<table border='1'>");
    out.write("<tr><th>ID</th><th>Name</th><th>Price</th><th>Quantity</th><th>Reorder</th><th>Action</th></tr>");
    
    while(it.hasNext()){
        Product product = (Product)it.next();
        
        out.write("<tr>");
        out.println("<td>"+product.getpID()+"</td>");
        out.println("<td>"+product.getpName()+ "</td>");
        out.println("<td>"+product.getPrice()+"</td>");
        out.println("<td>"+product.getQuantity()+"</td>");
        out.println("<td>"+product.getReorder()+"</td>");
        out.println("<td><a href='CartAction?add=true&id="+product.getpID()+"'>Add to Cart</a></td>");
        out.write("</tr>");

    }
    
    out.write("</table>");
%>