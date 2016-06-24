<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">

<head>
    <title>Movie Theater</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
</head>
<body>
<h2>Add User</h2>
<form method="post" action="${pageContext.request.contextPath}/addUser">
    <div class="row">
        <label>User name:</label>
        <input type="text" name="name"/>
        <label>Email:</label>
        <input type="text" name="email"/>
    </div>
    <label>Year:</label>
    <select name = "year">
    <script>
        var myDate = new Date();
        var year = myDate.getFullYear();
        for(var i = 1900; i < year+1; i++){
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
    <input type="submit" value="Submit"/>
</form>
</body>
</html>