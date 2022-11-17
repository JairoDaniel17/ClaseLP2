/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package tienda.controlador.usuario;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tienda.modelo.bean.Empleado;
import tienda.modelo.bean.Usuario;
import tienda.modelo.dao.EmpleadoDAO;
import tienda.modelo.dao.UsuarioDAO;

@WebServlet(name = "ServletUsuario", urlPatterns =
{
    "/ServletUsuario", "/login", "/cerrarSesion"
})
public class ServletUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            String path = request.getServletPath();
            if (path.equals("/login"))
            {
                //capturar valotres del formulario
                String us = request.getParameter("us");
                String cl = request.getParameter("cl");
                //verificar is usuario esta en la base de datos
                Usuario user = UsuarioDAO.login(us, cl);
                if (user != null)
                {
                    //asignar usuario a un atributo usuario y ala vez a es una variable de serssion
                    request.getSession().setAttribute("usuario", user);

                    int idemp = user.getIdemp();
                    Empleado emp = EmpleadoDAO.login(idemp);
                    request.setAttribute("empleado", emp);
                    //ir a la pagina principal
                    request.getRequestDispatcher("WEB-INF/principal.jsp").forward(request, response);
                } else
                {
                    request.setAttribute("mensaje", "Usuario y/o clave incorrecto...");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
            if (path.equals("/cerrarSesion"))
            {
                //CERRAR SESION
                request.getSession().invalidate();
                //ir al login
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
