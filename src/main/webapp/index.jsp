<%@ page import="com.ceica.tareasweb.models.ModeloBase" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<%
  //Código para evitar el fallo de conexión con la base de datos.
  //Alternativa, configurar un pool de conexiones en el servidor tomcat
  ModeloBase modeloBase=new ModeloBase() {
    @Override
    protected String getNombreTabla() {
      return null;
    }
  };
  modeloBase.getConnection();
%>
<html>
<head>
  <title>TaskWeb</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <link rel="stylesheet" href="assets/css/index.css">
</head>
<body>
<div class="container">
  <header>
    <img src="assets/images/taskapp.png" alt="Logotipo TaskAppWeb">
    <div>
      <h1>AppTaskWeb</h1>
      <a href="login">Iniciar</a>
    </div>
  </header>
  <hr>

</div>

</body>
</html>