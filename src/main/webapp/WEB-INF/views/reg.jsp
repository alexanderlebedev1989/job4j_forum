<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Регистрация</title>
    <meta charset="utf-8">
</head>
<body>
<c:if test="${not empty errorMessage}">
    <div style="color:#ff0000; font-weight: bold; margin: 30px 0px;">
            ${errorMessage}
    </div>
</c:if>
<h4>Регистрация</h4>
<form action="<c:url value='/reg'/>" method='POST'>
    <table>
        <tr>
            <td>Login:</td>
            <td><input type='text' name='name'></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password'/></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>
</form>
</body>
</html>
