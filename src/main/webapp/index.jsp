<%-- 
    Document   : agregar
    Created on : 02-10-2022, 14:40:01
    Author     : demozath
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Mascotas</title>
    </head>
    <body>
        <h1>Registro de Mascotas</h1>
        <form name="form" action="MascotasController" method="GET">
            <button type="submit" name="accion" value="agregar" class="btn btn-success">Agregar</button> <br><br>
            <button type="submit" name="accion" value="editar" class="btn btn-success">Editar</button><br><br>
            <button type="submit" name="accion" value="eliminar" class="btn btn-success">Eliminar</button><br><br>
            <button type="submit" name="accion" value="listar" class="btn btn-success">Lista</button><br><br>
        </form>
    </body>
</html>
