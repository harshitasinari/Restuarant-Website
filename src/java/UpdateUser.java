/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.sql.*;

/**
 *
 * @author harshita
 */
@WebServlet(urlPatterns = {"/UpdateUser"})
public class UpdateUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        String usr=req.getParameter("x");
        try  {
           
                out.println("<table border=\"1\" align=\"center\" width=\"100%\" height=\"250\">\n" +
"<tr><td style=\"background-color: antiquewhite\">\n" +
"<h1 align=\"center\" ><font color=\"red\">Welcome to Restaurant</font></h1></td></tr>\n" +
"</table>");
               
                out.println("<html>");
               
            out.println("<body><form action=Updateuserdetails>");
            out.println("<table align=center>");
            out.println("<tr><td><input type=text value='"+usr+"' name=ur></td></tr>");
            out.println("<tr><td>First name:</td><td><input type=text name=fn></td></tr>");
            out.println("<tr><td>Last name:</td><td><input type=text name=ln></td></tr>");
            out.println("<tr><td>Address:</td><td><input type=text name=ad></td></tr>");
            out.println("<tr><td>pin code:</td><td><input type=text name=pc></td></tr>");
            out.println("<tr><td>contact number:</td><td><input type=text name=cn></td></tr>");
            out.println("<tr><td>email:</td><td><input type=text name=em></td></tr>");
            
            out.println("<tr><td>password:</td><td><input type=password name=pass></td></tr>");
            out.println("<tr><td>confirm password:</td><td><input type=password name=repass></td></tr>");
            out.println("<tr><td><input type=submit ></td></tr>");
            out.println("</table></form></body></html>");
            
        }
        catch(Exception e)
        {
            out.println(e);
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
