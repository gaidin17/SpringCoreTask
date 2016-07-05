<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">

<head>
    <title>Work Module</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
</head>
<body>
<h2>Add Employee</h2>
<form method="post" action="${pageContext.request.contextPath}/addEmployee">
    <div>
        <label>Employee name:</label>
        <input type="text" name="name"/>
    </div>
    <br/>
    <input type="submit" value="Submit"/>
    <br/>
</form>
<br/>
<a href="/EventCenter/work.jsp">back to main page of work module</a>
</body>
</html>