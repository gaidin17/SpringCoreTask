<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">

<head>
    <title>EventCenter</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
</head>
<body>
    <h2>User Description</h2>
    <c:forEach items="${users}" var="user">
        <p>User Name: ${user.getName()}</p>
        <p>User Email: ${user.getEmail()}</p>
        <p>User Birthdate s${user.getBirthDate()}</p>
        <br/>
    </c:forEach>
    <a href="/EventCenter/">back to main page</a>
 </body>
 </html>