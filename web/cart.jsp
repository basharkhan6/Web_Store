<%-- 
    Document   : cart
    Created on : Feb 11, 2019, 6:41:08 PM
    Author     : Administrator
--%>

<%@page import="bd.edu.diu.webstore.model.Product"%>
<%@page import="java.util.Iterator"%>
<%@page import="bd.edu.diu.webstore.model.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Jsp</title>
    </head>
    <body>
        <a href="MainAction">Main</a> | <a href="CustomerAction">Customer List</a> | <a href="ProductAction">Product List</a> | <a href="CartAction">Your Cart</a>

        <h1>Cart</h1>
        
        
        
        
        
        <%
            Cart cart=(Cart)session.getAttribute("cart");
            Iterator it=cart.getItems();
            
            out.write("<table border='1'>");
            out.write("<tr><th>ID</th><th>Name</th><th>Price</th><th>Quantity</th><th>Reorder</th></tr>");
            
            while(it.hasNext()){
                Product product=(Product) it.next();
                out.write("<tr>");
                out.println("<td>"+product.getpID()+"</td>");
                out.println("<td>" +product.getpName()+ "</a></td>");
                out.println("<td>"+product.getPrice()+"</td>");
                out.println("<td>"+product.getQuantity()+"</td>");
                out.println("<td>"+product.getReorder()+"</td>");
                out.write("</tr>");
            }
            
            out.write("</table>");            
        %>
    </body>
</html>
