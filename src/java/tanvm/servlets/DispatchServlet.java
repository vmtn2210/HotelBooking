/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanvm.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class DispatchServlet extends HttpServlet {

    private final String LOGIN_CONTROLLER = "LoginServlet";
    private final String LOGIN_PAGE = "login.jsp";
    private final String REGISTRATION_CONTROLLER = "RegistrationServlet";
    private final String SEARCH_CONTROLLER = "SearchServlet";
    private final String CONFIRM_ROOM_CONTROLLER = "AddRoomServlet";
    private final String SEARCH_AD_CONTROLLER = "SearchAdminServlet";
    private final String ADD_TO_CART_CONTROLLER = "AddToCart";
    private final String VIEW_CART_PAGE = "showCart.jsp";
    private final String REMOVE_ITEMS_CONTROLLER = "RemoveItemFromCartServlet";
    private final String UPDATE_CONTROLLER = "UpdateController";
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
        
        String url = LOGIN_PAGE;
        try {
            String btn = request.getParameter("btAction");
            if(btn.equals("Login")){
                url = LOGIN_CONTROLLER;
            }else if(btn.equals("Create New Account")){
                url = REGISTRATION_CONTROLLER;
            }else if(btn.equals("Search")){
                url =  SEARCH_CONTROLLER;
            }else if (btn.equals("Search ADMIN")){
                url = SEARCH_AD_CONTROLLER;
            }else if(btn.equals("Confirm booking")){
                url = CONFIRM_ROOM_CONTROLLER;
            }else if(btn.equals("Booking")){
                url = ADD_TO_CART_CONTROLLER;
            }else if(btn.equals("View Booking")){
                url = VIEW_CART_PAGE;
            }else if(btn.equals("Remove Your Choice Items")){
                url = REMOVE_ITEMS_CONTROLLER;
            }else if(btn.equals("Update amount of room")){
                url = UPDATE_CONTROLLER;
            }
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
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
