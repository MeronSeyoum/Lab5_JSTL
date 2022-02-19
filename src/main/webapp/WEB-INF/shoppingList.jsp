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
        <link rel="stylesheet"   type="text/css" href="Style/shoppinglist.css">
        <title>Shopping List Page</title>
    </head>
    <body>
        <div class="main">
            <div class="inner">
                <h1>Shopping List</h1>
                Hello, ${username}
                <a href="ShoppingList?logout">Log Out</a>

                <h2>List</h2>
                <form action="ShoppingList" method="Post">
                    <lable for="list">Add Item: </lable>
                    <input type="text" name="list" id="list"/>
                    <input type="hidden" name="action" value="add">
                    <button type="submit">Add</button>
                </form>
                <br>
                <form action="ShoppingList" method="Post">

                    <c:forEach items="${items}" var="item">
                        <p>
                            <input type="radio" name="list" value="${item}">
                            <c:out value="${item}"></c:out>
                            </p>
                    </c:forEach>
                    <br>
                    <input type="hidden" name="action" value="delete">
                    <button type="submit">Delete</button>
                </form> 
            </div>
        </div>
    </body>
</html>
