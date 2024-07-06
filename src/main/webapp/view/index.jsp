<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registro de Proveedores</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Registrar Proveedor</h2>
    <form method="POST" action="/DesafioProveedores/ProveedorServlet" class="mb-3">
        <div class="form-group">
            <label>Nombre:</label>
            <input type="text" name="nombre" required class="form-control">
        </div>
        <div class="form-group">
            <label>RUT:</label>
            <input type="text" name="rut" required class="form-control">
        </div>
        <div class="form-group">
            <label>Dirección:</label>
            <input type="text" name="direccion" required class="form-control">
        </div>
        <div class="form-group">
            <label>Correo:</label>
            <input type="email" name="correo" required class="form-control">
        </div>
        <div class="form-group">
            <label>Teléfono:</label>
            <input type="text" name="telefono" required class="form-control">
        </div>
        <div class="form-group">
            <label>Contacto:</label>
            <input type="text" name="contacto" required class="form-control">
        </div>
        <div class="form-group">
            <label>Teléfono de Contacto:</label>
            <input type="text" name="telefono_contacto" required class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">Registrar Proveedor</button>
    </form>
</div>
</body>
</html>
