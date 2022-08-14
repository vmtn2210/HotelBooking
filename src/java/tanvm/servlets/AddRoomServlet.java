/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanvm.servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tanvm.booking.BookingDAO;
import tanvm.booking.BookingDTO;

/**
 *
 * @author ASUS
 */

public class AddRoomServlet extends HttpServlet {

    private final String USER_PAGE = "user.jsp";
    private final String SHOPPING_PAGE = "showCart.jsp";

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
        String url = SHOPPING_PAGE;
        try {
            String BookingID = request.getParameter("txtBookingID");
            String HotelName = request.getParameter("txtHotelName");
            int price = Integer.parseInt(request.getParameter("txtPrice"));
            int amount = Integer.parseInt(request.getParameter("txtAmount"));
            String roomID = request.getParameter("txtRoomID");
            Date checkInDate = Date.valueOf(request.getParameter("txtCheckInDate"));
            Date checkOutDate =Date.valueOf(request.getParameter("txtCheckOutDate"));
            String email = request.getParameter("txtEmail");

            BookingDTO dto = new BookingDTO(BookingID, HotelName, amount, checkInDate, checkOutDate, roomID, price, email);
            BookingDAO dao = new BookingDAO();
            boolean result = dao.createBookingOrder(dto);
            if (result) {
                HttpSession session = request.getSession();
                session.setAttribute("ORDER", dto);
                url = USER_PAGE;
            }
        } catch (ClassNotFoundException ex) {
            log("AddRoomServlet _ ClassNotFoundException" + ex.getMessage());
        } catch (SQLException ex) {
            log("AddRoomServlet _ SQLException" + ex.getMessage());
        } finally {
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
