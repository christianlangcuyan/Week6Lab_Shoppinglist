<%-- 
    Document   : ShoppingList
    Created on : 18-Feb-2023, 5:24:34 PM
    Author     : Chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username} <a href="ShoppingList?action=logout">Logout</a></p>
        <form action="" method="post">
            <h2>List</h2>
                Add item: <input type="text" name="item">
                <input type="Submit" value="Add"><br><br>
                <input type="hidden" name="action" value="add">
        </form>
    
        <form action=""> 
            <table>
                <c:forEach items="${items}" var="item">
                    <tr>
                        <td>
                            <input type="radio" name="${item}" value="${item}">${item}
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="Submit" value="Delete">
            <input type="hidden" name="action" value="deleted">
        </form>
        
    </body>
</html>
