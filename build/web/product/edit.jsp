<%-- 
    Document   : edit
    Created on : Feb 17, 2019, 10:57:58 PM
    Author     : bashar
--%>

<%@page import="bd.edu.diu.webstore.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Edit Form</title>
    </head>
    <body>
        <h1>Edit Product:</h1>
        <pre>
            <form action="ProductAction" method="POST">
                <%
                    Product product = (Product)request.getSession().getAttribute("product");
                %>
                <input type="hidden" name="pID" value="<%=product.getpID()%>">
                Name: <input type="text" name="pName" value="<%=product.getpName()%>">
                
                Price: <input type="text" name="price" value="<%=product.getPrice()%>">
                
                Quantity: <input type="text" name="quantity" value="<%=product.getQuantity()%>">
                
                Reorder: <input type="text" name="reorder" value="<%=product.getReorder()%>">
                
                <input type="submit" name="btnUpdate" value="Update"> <input type="reset" value="Reset">
            </form>
        </pre>
    </body>
</html>

