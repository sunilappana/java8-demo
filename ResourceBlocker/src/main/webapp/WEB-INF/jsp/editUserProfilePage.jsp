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
<form:form action="/editUser" style="border:1px solid #ccc" class="center" method="POST" modelAttribute="command">
    <form:hidden path="id"/>
    <form:hidden path="userPassword"/>
    <form:hidden path="userEmail"/>

    <div class="container">
        <h1>Edit Profile</h1>
        <p>Edit User Details</p>
        <hr>

        <form:label path="firstName"><b>First Name</b></form:label>
        <form:input type="text" path="firstName" required="required"/>

        <form:label path="lastName"><b>Last Name</b></form:label>
        <form:input type="text" path="lastName" required="required"/>

        <form:label path="mobileNo"><b>Mobile No.</b></form:label>
        <form:input type="text" path="mobileNo" required="required"/>

        <form:label path="address"><b>Address</b></form:label>
        <form:input type="text" path="address" required="required"/>

        <div class="clearfix">
            <button type="submit" class="signupbtn">Save</button>
        </div>
    </div>
</form:form>

</body>
</html>