<%-- 
    Document   : editar
    Created on : 02-10-2022, 14:53:02
    Author     : demozath
--%>

<%@page import="root.evuni02.entity.Mascotas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    Mascotas masc = (Mascotas) request.getAttribute("mascota");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Mascotas</title>
    </head>
    <body>
        <h1>Editar Mascota</h1>
        <form name="form" action="MascotasController" method="POST">
        ID:
        <input name="id" id="id" value="<%= masc.getId()%>"><br>
        Nombre:
        <input name="nombre" id="nombre" value="<%= masc.getNombre() %>"><br>
        Raza:
        <input name="raza" id="raza" value="<%= masc.getRaza() %>"><br>
        Edad:
        <input name="edad" id="edad" value="<%= masc.getEdad() %>"><br>
        Genero: <br>
        <input type="radio" name="genero" id="hembra" value="hembra">
        <label for="hembra">Hembra</label> <br>
        <input type="radio" name="genero" id="macho" value="macho">
        <label for="macho">Macho</label> <br>
        
        ¿Tiene sus vacunas al día?<br>
        <input type="radio" name="vacuna" id="si" value="true">
        <label for="si">Sí</label> <br>
        <input type="radio" name="vacuna" id="no" value="false">
        <label for="no">No</label> <br>
        <button type="submit" name="accion" value="editar" class="btn btn-success">Editar</button>
        </form>
    </body>
</html>
