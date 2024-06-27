<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <spring:url value="../resources/css/signUpStyle.css" var="styleCss"></spring:url>
    <link rel="stylesheet" href="${styleCss}">
</head>
<body>
<form action="/signUp" style="border:1px solid #ccc" class="center" method="POST">
    <div class="container">
        <h1>Sign Up</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>
        <c:if test="${showDiv}">
            <div class="errorDiv"><span class="errorMsg">${errorMsg}</span></div>
        </c:if>

        <label for="firstName"><b>First Name</b></label>
        <input type="text" name="firstName" required>

        <label for="lastName"><b>Last Name</b></label>
        <input type="text" name="lastName" required>


        <label for="userEmail"><b>Email</b></label>
        <input type="text" name="userEmail" required>

        <label for="userPassword"><b>Password</b></label>
        <input type="password" name="userPassword" required>

        <label for="mobileNo"><b>Mobile No.</b></label>
        <input type="text" name="mobileNo" required>

        <label for="address"><b>Address</b></label>
        <input type="text" name="address" required>

        <!--     <label for="psw-repeat"><b>Repeat Password</b></label>
            <input type="password" placeholder="Repeat Password" name="psw-repeat" required> -->

        <div class="clearfix">
            <button type="submit" class="signupbtn">Sign Up</button>
        </div>
    </div>
</form>

</body>
</html>