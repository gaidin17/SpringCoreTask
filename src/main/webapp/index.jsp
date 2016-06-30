<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">

<head>
    <title>EventCenter</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
</head>
<body>
   <a href="${pageContext.request.contextPath}/allUsers">All Users</a><br/>
   <a href="${pageContext.request.contextPath}/allAuditoriums">All Auditoriums</a><br/>
   <a href="${pageContext.request.contextPath}/allEvents">All Events</a><br/><br/>
   <a href="${pageContext.request.contextPath}/addUser.jsp">Add User</a><br/>
   <a href="${pageContext.request.contextPath}/addEvent">Add Event</a><br/><br/>


   <form enctype="multipart/form-data" action="${pageContext.request.contextPath}/uploadFile" method="post">
       <h2>Select newEvents.json file</h2>
       <input type="file" name="events"/>
       <button type="submit">Upload</button>
   </form>
   <form enctype="multipart/form-data" action="${pageContext.request.contextPath}/uploadFile" method="post">
       <h2>Select newUsers.json file</h2>
       <input type="file" name="users"/>
       <button type="submit">Upload</button>
   </form>
</body>
</html>