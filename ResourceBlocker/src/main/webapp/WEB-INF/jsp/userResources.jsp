<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>All Students</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
</head>

<body>
<div class="container my-2 ">
    <div class="card">
        <div class="card-body">
            <div class="container my-5">
                <div class="row-cols-md-6">
                    <form action="/search" method="POST">
                        <input type="text" name="keyword" placeholder="Find by Equipment Name or Category"
                               size="50">
                        <button type="submit" class="btn btn-dark m-1">Search</button>
                        <button type="submit" class="btn btn-dark m-1">Reset</button>
                    </form>
                    <br><br>
                    <c:if test="${equipments.size() gt 0 }">
                        <div>
                            <table class="table table-striped table-responsive-md">
                                <thead>
                                <tr>
                                    <th>Equipment Name</th>
                                    <th>Category</th>
                                    <th>Price</th>
                                    <th>Request</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="equipment" items="${equipments}">
                                    <c:if test="${equipment.quantity gt 0}">
                                        <tr>
                                            <td>${equipment.equipmentName}</td>
                                            <td>${equipment.category}</td>
                                            <td>${equipment.price}</td>
                                            <td>
                                                <a href="/sendRequest/${equipment.id}"
                                                   class="btn btn-dark">
                                                    <i class="fas fa-plus"></i></a>
                                            </td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
</body>
</html>