<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <spring:url value="../resources/css/signUpStyle.css" var="styleCss"></spring:url>
    <link rel="stylesheet" href="${styleCss}">
</head>
<body>
<form:form action="/changePassword" style="border:1px solid #ccc" class="center" method="POST" modelAttribute="command">

    <form:hidden path="id"/>
    <div class="container">
        <h1>Change Password</h1>
        <hr>

        <form:label path="oldPassword"><b>Current Password</b></form:label>
        <form:input type="password" path="oldPassword" required="required"/>

        <form:label path="newPassword"><b>New Password</b></form:label>
        <form:input type="password" path="newPassword" required="required"/>


        <div class="clearfix">
            <button type="submit" class="signupbtn">Save</button>
        </div>
    </div>
</form:form>

</body>
</html>