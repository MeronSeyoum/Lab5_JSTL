<%-- 
    Document   : shoppingList
    Created on : 17-Feb-2022, 8:57:14 PM
    Author     : merya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
         <form action="shoppinglist" method="Post"></form>
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
