<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>Ha ocurrido un error</h1>
    <p>Lo sentimos, ha ocurrido un error procesando tu solicitud.</p>
    <p><%= request.getAttribute("error") %></p>
    <a href="view/index.jsp">Volver al inicio</a>
</body>
</html>
