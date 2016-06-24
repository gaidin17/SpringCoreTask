<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">

<head>
    <title>Movie Theater</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
</head>
<body>
    <c:forEach items="${users}" var="user">
      <p>${user.getName()}</p>
      <p>${user.getEmail()}</p>
      <p>${user.getBirthDate()}</p>
      <br/>
     </c:forEach>
 </body>
 </html>