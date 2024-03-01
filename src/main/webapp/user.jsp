<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>User</title>
    <link rel="stylesheet" href="assets/css/user.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <header>
        <p>${name}</p>
        <a href="?logout=salir">salir</a>
    </header>
    <hr>
    <div class="datos">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Title</th>
                <th scope="col">Description</th>
                <th scope="col">Create Date</th>
                <th scope="col">Date</th>
                <th scope="col">OP</th>
            </tr>
            </thead>

            <tbody>
            <c:choose>
                <c:when test="${empty tasks}">
                    <tr>
                        <td colspan="3">No hay tareas disponibles.</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${tasks}" var="task">
                        <tr>
                            <td><c:out value="${task.idtask}"/></td>
                            <td><c:out value="${task.title}"/></td>
                            <td><c:out value="${task.description}"/></td>
                            <fmt:formatDate value="${task.create_time}" pattern="dd-MM-yyyy" var="formattedCreate_time" />
                            <td><c:out value="${formattedCreate_time}" /></td>
                            <fmt:formatDate value="${task.deadline}" pattern="dd-MM-yyyy" var="formattedDeadline" />
                            <td><c:out value="${formattedDeadline}" /></td>
                            <td></td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>
        <hr>
        <h3>New Task</h3>
        <form action="" method="post">
            <input type="text" placeholder="Title" name="title">
            <input type="text" placeholder="Description" name="description">
            <input type="date" name="deadline" placeholder="Deadline">
            <input type="submit" name="New">
        </form>
    </div>
</div>

</body>
</html>