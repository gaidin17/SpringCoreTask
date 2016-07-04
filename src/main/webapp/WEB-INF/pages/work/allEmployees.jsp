<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">

<head>
    <title>work module</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
</head>
<body>
 <h2>Events</h2>
 <c:forEach items="${employees}" var="emp">
    <p>${emp.getName()}</p>
 </c:forEach>
 <br/>
 <a href="/EventCenter/work.jsp">back to main page of work module</a>
 </body>
 </html>