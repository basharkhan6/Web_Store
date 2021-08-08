<%-- 
    Document   : customerForm
    Created on : Feb 15, 2019, 5:41:08 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Input Form</title>
    </head>
    <body>
        <h1>Customer Form:</h1>
        <pre>
            <form action="CustomerAction" method="POST">
                Name: <input type="text" name="cName">
                
                Phone: <input type="text" name="phone">
                
                Email: <input type="text" name="email">
                
                Address: <input type="text" name="address">
                
                <input type="submit" name="btnSave" value="Save"> <input type="reset" value="Reset">
            </form>
        </pre>
    </body>
</html>
