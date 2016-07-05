<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">

<head>
    <title>work module</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
</head>
<body>
    <h2>Assign Employee to Job</h2>
    <c:choose>
        <c:when test="${jobs.size() > 0}">
            <form method="post" action="${pageContext.request.contextPath}/assignEmployee">
                <select name = "job">
                    <c:forEach items="${jobs}" var="job">
                        <option value="${job.getId()}">${job.getId()}</option>
                    </c:forEach>
                </select>
                <select name = "employee">
                    <c:forEach items="${employees}" var="employee">
                        <option value="${employee.getId()}">${employee.getName()}</option>
                    </c:forEach>
                </select>
                        <input type="submit" value="Assign employee to job">
                </form>
        </c:when>
        <c:otherwise>
            <p>Where is no one available job for assign</p>
        </c:otherwise>
    </c:choose>
 </br>
 <a href="/EventCenter/work.jsp">back to main page of work module</a>
 </body>
 </html>