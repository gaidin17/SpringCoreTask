<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">

<head>
    <title>EventCenter</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
</head>
<body>
      <h2>Event Description</h2>
      <p>Event Name: ${event.getName()}</p>
      <p>Event Date: ${event.getDate()}</p>
      <p>Event Time: ${event.getTime()}</p>
      <p>Event Rating: ${event.getRating()}</p>
      <p>Event Base price: ${event.getBasePrice()}</p>
      <p>Event Auditorium: <a href="${pageContext.request.contextPath}/auditoriumsByName/${event.getAuditorium().getName()}/">${event.getAuditorium().getName()}</a></p>
      <br/>
      <a href="/EventCenter/">back to main page</a>
 </body>
 </html>