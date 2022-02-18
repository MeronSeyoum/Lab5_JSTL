<%-- 
    Document   : register
    Created on : 17-Feb-2022, 8:56:57 PM
    Author     : Meron Seyoum
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="post">
            <lable for="username">Username:</lable>
            <input type="text" name="username" id="username"/>
            <input type="hidden" name="action" value="register">
            <button type="submit">Register Name</button>
        </form>
         <p>${message}</p> 
    </body>
</html>
