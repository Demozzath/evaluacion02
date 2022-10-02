<%-- 
    Document   : agregar
    Created on : 02-10-2022, 14:41:14
    Author     : demozath
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de mascotas</title>
    </head>
    <body>
        <h1>Agregar mascota:</h1>
        <form name="form" action="MascotasController" method="POST">
        ID:
        <input name="id" id="id" > <br>
        Nombre:
        <input name="nombre" id="nombre" ><br>
        Raza:
        <input name="raza" id="raza"><br>
        Edad:
        <input name="edad" id="edad"><br>
        
        Genero: <br>
        <input type="radio" name="genero" id="si" value="si">
        <label for="si">Hembra</label> <br>
        <input type="radio" name="genero" id="no" value="no">
        <label for="si">Macho</label> <br>
        
        ¿Tiene sus vacunas al día?<br>
        <input type="radio" name="vacuna" id="si" value="si">
        <label for="si">Sí</label> <br>
        <input type="radio" name="vacuna" id="no" value="no">
        <label for="si">No</label> <br>
        <button type="submit" name="accion" value="crear" class="btn btn-success">Crear</button>
            
            
        </form>
    </body>
</html>
