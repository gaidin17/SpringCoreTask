<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">

<head>
    <title>EventCenter</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
</head>
<body>
<h2>Add User</h2>
<form method="post" action="${pageContext.request.contextPath}/addNewEvent">
    <div>
        <label>Event name:</label>
        <input type="text" name="name"/>
    </div>
    <label>Year:</label>
    <select name = "year">
    <script>
        var myDate = new Date();
        var year = myDate.getFullYear();
        for(var i = year; i < year+5; i++){
            document.write('<option value="'+i+'">'+i+'</option>');
        }
    </script>
    </select>
    <label>Month:</label>
    <select name = "month">
    <script>
        for(var i = 1; i < 13; i++){
            if (i < 10) {
                i = "0" + i;
            }
            document.write('<option value="'+i+'">'+i+'</option>');
        }
    </script>
    </select>
    <label>Day:</label>
    <select name = "day">
    <script>
        for(var i = 1; i < 32; i++){
            if (i < 10) {
                i = "0" + i;
            }
            document.write('<option value="'+i+'">'+i+'</option>');
        }
    </script>
    </select>
    <br/>
    <label>Hour:</label>
    <select name = "hour">
    <script>
        for(var i = 0; i < 24; i++){
            if (i < 10) {
                i = "0" + i;
            }
            document.write('<option value="'+i+'">'+i+'</option>');
        }
    </script>
    </select>
    <label>Minutes:</label>
    <select name = "minutes">
        <option value="15">00</option>
        <option value="15">15</option>
        <option value="15">30</option>
        <option value="15">45</option>
    </select>
    <div>
        <label>Event base price:</label>
        <input type="number" name="basePrice"/>
    </div>
    <br/>
    <label>Rating:</label>
    <select name = "rating">
        <option value="HIGHT">HIGHT</option>
        <option value="MID">MID</option>
        <option value="LOW">LOW</option>
    </select>
    <br/>
    <label>Auditorium:</label>
    <select name = "auditorium">
        <c:forEach items="${auditoriums}" var="auditorium">
            <option value="${auditorium.getName()}">${auditorium.getName()}</option>
        </c:forEach>
    </select>
    <br/>
    <input type="submit" value="Submit"/>
    <br/>
    <a href="/EventCenter/">back to main page</a>
</form>
</body>
</html>