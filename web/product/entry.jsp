<%-- 
    Document   : entry
    Created on : Feb 17, 2019, 10:28:10 PM
    Author     : bashar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Entry Form</title>
    </head>
    <body>
        <h1>Entry Product:</h1>
        <pre>
            <form action="ProductAction" method="POST">
                Name: <input type="text" name="pName">
                
                Price: <input type="text" name="price">
                
                Quantity: <input type="text" name="quantity">
                
                Reorder: <input type="text" name="reorder">
                
                <input type="submit" name="btnSave" value="Save"> <input type="reset" value="Reset">
            </form>
        </pre>
    </body>
</html>
