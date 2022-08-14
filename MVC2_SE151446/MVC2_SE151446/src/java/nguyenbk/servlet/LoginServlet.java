/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenbk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nguyenbk.login.LoginDAO;
import nguyenbk.login.LoginDTO;
import nguyenbk.utils.MyApplicationConstants;

/**
 *
 * @author buikh
 */
public class LoginServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        //get Context Scope
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String url = siteMaps.getProperty(MyApplicationConstants.LoginFeature.INVALID_PAGE);
        try {

            //1. call Model
            LoginDAO dao = new LoginDAO();
            LoginDTO dto = dao.checkLogin(username, password);
            //2. process result
            if (dto != null) {
                
                Cookie[] ownCookie = request.getCookies();
                if (ownCookie != null) {
                    url = siteMaps.getProperty(MyApplicationConstants.SearchLastNameFeature.STATIC_SEARCH_PAGE);
                } else {
                    url = siteMaps.getProperty(MyApplicationConstants.LoginFeature.SEARCH_PAGE);
                    //WriteCookie
                    //1.Create Cookie
                    Cookie cookie = new Cookie(username, password);
                    cookie.setMaxAge(60 * 1);
                    response.addCookie(cookie);                    
                }
                //check authorization
                HttpSession session = request.getSession();
                session.setAttribute("FULLNAME", dto.getFullname());
                session.setAttribute("USERNAME", dto.getUsername());
                session.setAttribute("PASSWORD", dto.getPassword());
            }//end if username and password are matched!!

        } catch (SQLException ex) {
            log("LoginServlet _ SQL " + ex.getMessage());
        } catch (NamingException ex) {
            log("LoginServlet _ Naming " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
