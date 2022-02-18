<%-- 
    Document   : shoppingList
    Created on : 17-Feb-2022, 8:57:14 PM
    Author     :Meron Seyoum
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello, ${username}
        <a href="ShoppingList?logout">Log Out</a>

        <h2>List</h2>
        <form action="add" method="Post">
            <lable for="list">Add List</lable>
            <input type="text" name="list" id="lsit"/>
            <button type="submit">Add</button>

        </form>
        <ul>
            <c:forEach items="${items}" var="item">
                <li><c:out value="${item}" /></li>
                </c:forEach>
        </ul>
    </body>
</html>
