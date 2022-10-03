
package root.evuni02.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import root.evuni02.MascotasDAO.MascotasDAO;
import root.evuni02.MascotasDAO.exceptions.NonexistentEntityException;
import root.evuni02.entity.Mascotas;

@WebServlet(name = "MascotasController", urlPatterns = {"/MascotasController"})
public class MascotasController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MascotasController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MascoasController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String boton = request.getParameter("accion");
        MascotasDAO dao = new MascotasDAO();

        if (boton.equals("editar") || boton.equals("eliminar") || boton.equals("listar")) {
            List<Mascotas> lista = dao.findMascotasEntities();
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("listar.jsp").forward(request, response);
        }

        if (boton.equals("agregar")) {
            request.getRequestDispatcher("agregar.jsp").forward(request, response);
        }

        if (boton.equals("volver")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        if (boton.equals("cambiar")) {
            String seleccion = request.getParameter("seleccion");
            Integer seleccionInt = Integer.parseInt(seleccion);
            Mascotas masc = dao.findMascotas(seleccionInt);
            request.setAttribute("mascota", masc);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        
        if (boton.equals("borrar")) {
            try {
                String seleccion = request.getParameter("seleccion");
                Integer seleccionInt = Integer.parseInt(seleccion);
                dao.destroy(seleccionInt);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(MascotasController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            List<Mascotas> lista = dao.findMascotasEntities();
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("listar.jsp").forward(request, response);
            
            
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String boton = request.getParameter("accion");
            MascotasDAO dao = new MascotasDAO();

            String id = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String raza = request.getParameter("raza");
            String edad = request.getParameter("edad");
            String genero = request.getParameter("genero");
            String vacuna = request.getParameter("vacuna");

            Integer idInt = Integer.parseInt(id);
            boolean vacunas = Boolean.parseBoolean(vacuna);

            Mascotas mascota = new Mascotas();
            mascota.setId(idInt);
            mascota.setNombre(nombre);
            mascota.setRaza(raza);
            mascota.setEdad(edad);
            mascota.setGenero(genero);
            mascota.setVacunas(vacunas);

            if (boton.equals("grabar")) {
                dao.create(mascota);
            }
            if (boton.equals("editar")){
                dao.edit(mascota);
            }

        } catch (Exception ex) {
            Logger.getLogger(MascotasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
