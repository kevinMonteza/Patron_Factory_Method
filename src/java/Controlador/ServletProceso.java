package Controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloControl.AccesoDatos;

public class ServletProceso extends HttpServlet {

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
            String pais = request.getParameter("ComboBox");
            
            AccesoDatos data = new AccesoDatos();
            List<String> lista = new ArrayList<String>();
            lista = data.pedirData(pais);
            //Vector<String> clientes = new Vector<String>();
            //clientes.add("POST");
            //response.sendRedirect("vista/JSPMostrarDatos.jsp?dato="+cliente);
            request.setAttribute("lista", lista);
            RequestDispatcher rd = request.getRequestDispatcher("vista/Datos.jsp");
            rd.forward(request, response);
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
