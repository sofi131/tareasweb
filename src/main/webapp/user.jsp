<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Descripción</th>
            </tr>
            </thead>
            <tbody>
            <!-- Etiquetas JTSL-->
            <!-- Esto es para elegir opciones -> si está vacío que ponga que no está disponible, sino poner task   -->
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
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>

    </div>
</div>

</body>
</html>