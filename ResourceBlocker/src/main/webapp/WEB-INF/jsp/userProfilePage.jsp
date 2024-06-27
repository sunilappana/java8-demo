<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>All Students</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
</head>

<body>
<div class="container my-2">
    <div class="card m-5">
        <div class="card-body ">
            <div class="container my-5">
                <div class="col-md-10">
                    <h2 style="align-items: center;margin-left: 40%;padding: 25px;margin-top: -50px">My Profile</h2>
                    <div>
                        <table class="table table-striped table-responsive-md">

                            <tbody>
                            <tr>
                                <th>First Name</th>
                                <td><c:out value="${user.firstName}"/></td>
                            </tr>
                            <tr>
                                <th>Last Name</th>
                                <td><c:out value="${user.lastName}"/></td>
                            </tr>
                            <tr>
                                <th>Email</th>
                                <td><c:out value="${user.userEmail}"/></td>
                            </tr>
                            <tr>
                                <th>Address</th>
                                <td><c:out value="${user.address}"/></td>
                            </tr>
                            <tr>
                                <th>Mobile Number</th>
                                <td><c:out value="${user.mobileNo}"/></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>

                    <p class="my-5">
                        <a href="/editProfilePage/${user.id}" class="btn btn-dark">
                            <i class="fas ml-2">Edit Profile</i>
                        </a>
                    </p>
                    <p class="my-5">
                        <a href="/changePasswordPage/${user.id}" class="btn btn-dark">
                            <i class="fas ml-2">Change Password</i>
                        </a>
                    </p>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
</body>
</html>