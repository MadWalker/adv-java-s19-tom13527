<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
    <title>Lab 2-4</title>
</head>
<body>
    <c:set var="someVariable" value="iDontKnow" scope="session" />
    <c:out value="${someVariable}" />
</body>
</html>