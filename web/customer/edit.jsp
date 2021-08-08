<%-- 
    Document   : customerEdit
    Created on : Feb 15, 2019, 6:36:46 PM
    Author     : Administrator
--%>

<%@page import="bd.edu.diu.webstore.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Edit Form</title>
    </head>
    <body>
        <h1>Customer Edit Form:</h1>
        <pre>
            <form action="CustomerAction" method="POST">
                <%
                    Customer customer= (Customer)session.getAttribute("customer");
                %>
                <input type="hidden" name="cID" value="<%=customer.getcID()%>">
                Name: <input type="text" name="cName" value="<%=customer.getcName()%>">
                
                Phone: <input type="text" name="phone" value="<%=customer.getPhone()%>">
                
                Email: <input type="text" name="email" value="<%=customer.getEmail()%>">
                
                Address: <input type="text" name="address" value="<%=customer.getAddress()%>">
                
                <input type="submit" name="btnUpdate" value="Update"> <input type="reset" value="Reset">
            </form>
        </pre>
    </body>
</html>
