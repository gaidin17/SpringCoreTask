<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">

<head>
    <title>work module</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
</head>
<body>
<h2>Employee Jobs</h2>
<p>${employee.getName()}</p>
<c:choose>
    <c:when test="${jobs.size() > 0}">
        <table border="1">
        <c:forEach items="${jobs}" var="job">
            <tr>
                <td>${job.getId()}</td>
                <td>${job.getDescription()}</td>
                <td>${job.getDeadLineDate().toString()}</td>
            </tr>
        </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <p>This employee does not have jobs</p>
    </c:otherwise>
</c:choose>
</br>
<a href="/EventCenter/work.jsp">back to main page of work module</a>
</body>
</html>