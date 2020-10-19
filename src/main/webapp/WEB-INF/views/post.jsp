<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <title>Форум job4j</title>
</head>
<body>
<div class="container">
<div class="row">
    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link" href="<c:url value='/index'/>">Вернуться на главную</a>
        </li>
    </ul>
</div>
</div>
<div class="container pt-3">
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                Обсуждение темы
            </div>
            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Название</th>
                        <th scope="col">Описание</th>
                        <th scope="col">Дата создания</th>
                        <th scope="col">#</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><c:out value="${post.name}"/></td>
                        <td><c:out value="${post.description}"/></td>
                        <td><c:out value="${post.created.time}"/></td>
                        <td><a href="<c:url value='/edit?id=${post.id}'/>">Редактировать</a></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<div class="container pt-3">
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                Комментарии
            </div>
            <div class="card-body">
                <table id="table" class="table">
                    <thead>
                    <tr>
                        <th>Описание</th>
                        <th>Дата создания</th>
                        <th>#</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${comments}" var="comment">
                        <tr>
                            <td><c:out value="${comment.description}"/></td>
                            <td><c:out value="${comment.calendar.time}"/></td>
                            <td><a href="<c:url value='/deleteComment?idComm=${comment.id}&idPost=${post.id}'/>">Удалить</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<div class="container pt-3">
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
               Комментарии
            </div>
            <div class="card-body">
                <form action="<c:url value='/addComment'/>" method="POST">
                    <div class="form-group">
                        <label>Добавить комментарий</label>
                        <input type="text" name="description" class="form-control">
                        <input type="hidden" name="id" value="${post.id}">
                    </div>
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>