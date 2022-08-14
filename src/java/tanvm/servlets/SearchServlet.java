/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanvm.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tanvm.user.HotelDAO;
import tanvm.user.HotelDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {
    private final String USER_PAGE_ERROR = "user.jsp";
    private final String USER_PAGE_SUCCESS = "user.jsp";
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
        String searchValue = request.getParameter("txtSearchValue");
        String searchOption = request.getParameter("cboSearch");
        String url = USER_PAGE_ERROR;
        try {
            if(searchValue.trim().length() > 0){
                HotelDAO dao = new HotelDAO();
                List<HotelDTO> hotels = null;
                switch(searchOption){
                    case "HotelArea":
                        hotels = dao.getHotelByArea(searchValue);
                        if(hotels.size() > 0){
                            request.setAttribute("HOTELS", hotels);
                            url = USER_PAGE_SUCCESS;
                        }else{
                            request.setAttribute("ERROR", "NOT RECORD MATCHED");
                        }
                        break;
                    case "HotelName":
                        hotels = dao.getHotelByName(searchValue);
                        if(hotels.size() > 0){
                            request.setAttribute("HOTELS", hotels);
                            url = USER_PAGE_SUCCESS;
                        }else{
                            request.setAttribute("ERROR", "NOT RECORD MATCHED");
                        }
                        break;
                    case "checkInDate":
                        hotels = dao.getHotelByCheckInDate(searchValue);
                        if(hotels.size() > 0){
                            request.setAttribute("HOTELS", hotels);
                            url = USER_PAGE_SUCCESS;
                        }else{
                            request.setAttribute("ERROR", "NOT RECORD MATCHED");
                        }
                        break;
                    case "checkOutDate":
                        hotels = dao.getHotelByCheckOutDate(searchValue);
                        if(hotels.size() > 0){
                            request.setAttribute("HOTELS", hotels);
                            url = USER_PAGE_SUCCESS;
                        }else{
                            request.setAttribute("ERROR", "NOT RECORD MATCHED");
                        }
                        break;
                    case "AmountOfRoom":
                        int searchResult = Integer.parseInt(searchValue);
                        hotels = dao.getHotelByAmountOfRoom(searchResult);
                        if(hotels.size() > 0){
                            request.setAttribute("HOTELS", hotels);
                            url = USER_PAGE_SUCCESS;
                        }else{
                            request.setAttribute("ERROR", "NOT RECORD MATCHED");
                        }
                        break;
                }
            }
        }catch(ClassNotFoundException ex){
            log("SearchUserController _ ClassNotFoundException " + ex.getMessage());
        }catch(SQLException ex){
            log("SearchUserController _ SQLException " + ex.getMessage());
        }
        finally{
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
