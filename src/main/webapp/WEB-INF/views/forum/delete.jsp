<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Удалить</title>
</head>
<body>
<form action="<c:url value='delete'/>" method='POST'>
    <strong>Название:</strong><br><br>
        <c:out value="${post.name}"/>
        <input type="hidden" name="id" value="${post.id}">
        <input name="submit" type="submit" value="Удалить" /><br><br>
</form>
</body>
</html>
