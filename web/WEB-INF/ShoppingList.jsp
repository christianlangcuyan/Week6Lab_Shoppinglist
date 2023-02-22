<%-- 
    Document   : ShoppingList
    Created on : 18-Feb-2023, 5:24:34 PM
    Author     : Chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username}<a href="logout">Logout</a></p>
        <form action="add" method="post">
            <h2>List</h2>
                Add item: <input type="text" name="item">
                <input type="Submit" value="Add"><br><br>
        </form>
        
        <input type="Submit" value="Delete">
    </body>
</html>
