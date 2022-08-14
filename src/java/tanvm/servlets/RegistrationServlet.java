/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanvm.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tanvm.login.UserDTO;
import tanvm.registration.RegistrationCreateError;
import tanvm.registration.RegistrationDAO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/RegistrationServlet"})
public class RegistrationServlet extends HttpServlet {
    private final String REGISTRATION_ERROR_PAGE = "registrationError.jsp";
    private final String LOGIN_PAGE = "login.jsp";
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
        String email = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String name = request.getParameter("txtFullname");
        String phone = request.getParameter("txtPhone");
        String address = request.getParameter("txtAddress");
        String url = REGISTRATION_ERROR_PAGE;
        RegistrationCreateError errors = new RegistrationCreateError();
        boolean foundErr = false;
        try {
            if (email.trim().length() < 6 ||
                    email.trim().length() > 20) {
                foundErr = true;
                errors.setUsernameLengthError("Username is required from 6 to 20 chars");
            }
            if (password.trim().length() < 6 ||
                    email.trim().length() > 30) {
                foundErr = true;
                errors.setPasswordLengthError("Password is required from 6 to 30 chars");
            }
            else if (!confirm.trim().equals(password.trim())) {
                foundErr = true;
                errors.setConfirmNotMatched("Confirm must match password");
            }
            if (name.trim().length() < 2 || name.trim().length() > 50) {
                foundErr = true;
                errors.setNameLengthError("Fullname is required from 6 to 50 chars");
            }
            if (phone.trim().length() < 2 || phone.trim().length() > 50) {
                foundErr = true;
                errors.setPhoneLengthError("Phone is required from 6 to 50 chars");
            }
            if (address.trim().length() < 2 || phone.trim().length() > 50) {
                foundErr = true;
                errors.setAddressLengthError("Address is required from 6 to 50 chars");
            }
            
            //2.process
            if (foundErr) {
                //2.1 Forward errors to createAccount erros to notify
                request.setAttribute("CREATEERRORS", errors);
            } else {
                //2.2 call DAO
                RegistrationDAO dao = new RegistrationDAO();
                UserDTO dto = new UserDTO(email, password, name, address, phone);
                boolean result = dao.createNewAccount(dto);
                
                if (result){
                    url = LOGIN_PAGE;
                }
            }
        }catch(SQLException ex){
            String msg = ex.getMessage();
            log("CreateAccountServlet _ SQL " + msg);
            if (msg.contains("duplicate")) {
                errors.setUsernameIsExisted(email + " is existed");
                request.setAttribute("CREATEERRORS", errors);
            } //username is existed
        }catch(ClassNotFoundException ex){
            log("CreateAccountServlet _ Naming " + ex.getMessage());
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
