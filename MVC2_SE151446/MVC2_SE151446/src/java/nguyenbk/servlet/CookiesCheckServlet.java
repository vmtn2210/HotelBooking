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
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name = "CookiesCheckServlet", urlPatterns = {"/CookiesCheckServlet"})
public class CookiesCheckServlet extends HttpServlet {

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
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties)context.getAttribute("SITEMAPS");
        String url = siteMaps.getProperty(MyApplicationConstants.CookiesController.LOGIN_PAGE);
        try {
            //1. get Cookies from Request
            Cookie cookies[] = request.getCookies();
            if(cookies != null){
                //2. get Last Cookie
                Cookie lastCookies = cookies[cookies.length - 1];
                
                //3. get usernam and password
                String username = lastCookies.getName();
                String password = lastCookies.getValue();
                //4. Check Login
                LoginDAO dao = new LoginDAO();
                LoginDTO dto = dao.checkLogin(username, password);
                
                if(dto != null){
                    System.out.println(lastCookies.getName() + "\n" + lastCookies.getValue());
                    url = siteMaps.getProperty(MyApplicationConstants.CookiesController.STATIC_SEARCH_PAGE);
                    HttpSession session = request.getSession();
                    session.setAttribute("FULLNAME", dto.getFullname());
                }//end if username and password are matched
            } //end if cookies is existed
        }catch(NamingException ex){
            log("CookiesCheckServlet _ Naming " + ex.getMessage());
        }catch(SQLException ex){
            log("CookiesSQLServlet _ SQL " + ex.getMessage());
        }finally{
//            RequestDispatcher rd = request.getRequestDispatcher(url);
//            rd.forward(request, response);
            response.sendRedirect(url);
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
