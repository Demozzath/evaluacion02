<%-- 
    Document   : editar
    Created on : 02-10-2022, 14:55:37
    Author     : demozath
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="root.evuni02.entity.Mascotas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    List<Mascotas> lista = (List<Mascotas>) request.getAttribute("lista");
    Iterator<Mascotas> itMascotas = lista.iterator();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Mascotas</title>
    </head>
    <body>
        <h1>Lista de Mascotas</h1>
        <form name="form" action="MascotasController" method="GET">
            <table border="2">
                <th> ID </th>
                <th> Nombre </th>
                <th> Edad </th>
                <th> Raza </th>
                <th> Genero </th>
                <th> Vacuna </th>
                <th>Editar / Eliminar</th>
                    <% while (itMascotas.hasNext()) {
                            Mascotas masc = itMascotas.next();%>

                <tr>
                    <td> <%= masc.getId()%> </td>
                    <td> <%= masc.getNombre()%> </td>
                    <td> <%= masc.getEdad()%> </td>
                    <td> <%= masc.getRaza()%> </td>
                    <td> <%= masc.getGenero()%> </td>
                    <td> <%= masc.getVacuna()%> </td>
                    <td> <input type="radio" name="seleccion" value="<%= masc.getId()%>"> </td>
                </tr>
                <%}%>
            </table>
            <button type="submit" name="accion" value="cambiar"> Editar registro </button>
            <button type="submit" name="accion" value="borrar"> Eliminar registro </button>
            <button type="submit" name="accion" value="volver"> Volver </button>
        </form>
    </body>
</html>
