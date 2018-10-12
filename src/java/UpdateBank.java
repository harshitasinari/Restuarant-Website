/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author harshita
 */
@WebServlet(urlPatterns = {"/UpdateBank"})
public class UpdateBank extends HttpServlet {

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
        String acnumber=req.getParameter("x");
        try  {
            /* TODO output your page here. You may use following sample code. */
             out.println("<table border=\"1\" align=\"center\" width=\"100%\" height=\"250\">\n" +
"<tr><td style=\"background-color: antiquewhite\">\n" +
"<h1 align=\"center\" ><font color=\"red\">Welcome to Restaurant</font></h1></td></tr>\n" +
"</table>");
               
                out.println("<html>");
               
            out.println("<body><form action=Updatebankdetails>");
            out.println("<table align=center>");
            out.println("<tr><td>Account Number:</td><td><input type=text value='"+acnumber+"' name=ac></td></tr>");
            out.println("<tr><td>Account Holder Name:</td><td><input type=text name=an></td></tr>");
            out.println("<tr><td>Bank Name:</td><td><input type=text name=bn></td></tr>"); 
            out.println("<tr><td>IFSC code:</td><td><input type=text name=ic></td></tr>");
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
