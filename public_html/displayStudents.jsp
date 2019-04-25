<!-- this tag is important! need it for anything usint the tab lib -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
    <title>Student List Demo</title>
</head>
<body>
<ul>
    <c:forEach var="flower" items="${listOfStudents}">
        <li>${flower}</li>
    </c:forEach>
</ul>
</body>
</html>
