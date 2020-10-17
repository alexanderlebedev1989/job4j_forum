<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Авторизация</title>
    <meta charset="utf-8">
</head>
<body>
<div class="container">
    <div class="row">
        <ul class="nav">
            <a class="nav-link" href="<c:url value='/reg'/>">Регистрация</a>
        </ul>
    </div>
</div>
<h4>Авторизация</h4>
<form action="<c:url value='/'/>" method='POST'>
    <table>
        <tr>
            <td>Login:</td>
            <td><input type='text' name='login'></td>
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
