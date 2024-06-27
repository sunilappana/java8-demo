<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        .navbar {
            display: block;
            overflow: hidden;
            background-color: #333;
            font-family: Arial, Helvetica, sans-serif;
        }

        .navbar a {
            float: right;
            font-size: 25px;
            color: white;
            text-align: center;
            padding: 11px 16px;
            text-decoration: none;
        }

        .navbar h2 {
            float: left;
            font-size: 25px;
            color: white;
            text-align: center;
            padding: 11px 16px;
            text-decoration: none;
        }

        .navbar a:hover {
            background-color: #888888;
        }
    </style>
</head>
<body>

<div class="navbar">
    <h2>Resource Blocker</h2>
    <a href="logout"> Logout</a>
    <a href="/userResources">Resources</a>
    <a href="/profile">Profile</a>
</div>

<h1 style="margin-left: 43%;margin-top: 50px">Welcome ${displayName}</h1>
<c:if test="${profile}">
    <jsp:include page="userProfilePage.jsp"/>
</c:if>
<c:if test="${resources}">
    <jsp:include page="userResources.jsp"/>
</c:if>

</body>


</html>