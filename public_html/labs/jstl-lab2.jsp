<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
    <title>Lab 2-4</title>
</head>
<body>
<ul>
    <c:forEach var="someListItems" items="${listOfBops}">
        <li>${someListItems}</li>
    </c:forEach>
</ul>
</body>
</html>