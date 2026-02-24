/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.UniversityDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.University;

/**
 *
 * @author AN
 */
public class insertUniversity extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String error = "";
        String megs = "";
        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String shortName = request.getParameter("shortname");
            String description = request.getParameter("description");
            int foundedYear = Integer.parseInt(request.getParameter("foundedYear"));
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String region = request.getParameter("region");
            String type = request.getParameter("type");
            int totalStudents = Integer.parseInt(request.getParameter("totalStudents"));
            int totalFaculties = Integer.parseInt(request.getParameter("totalFaculties"));
            boolean draft = request.getParameter("draft") == null ? false : true;
            University u = new University(id, name, shortName, description, foundedYear, address, city, region, type, totalStudents, totalFaculties, draft);
            UniversityDAO  uDAO = new UniversityDAO();
            if(uDAO.searchByID(id).size() > 0){
                error += "Id da ton tai <br>";
            }
            if(foundedYear <= 0){
                error += "Nam thanh lap khong duoc be hon 0 <br>";
            }
            if(totalStudents <= 0 || totalFaculties <= 0){
                error += "So luong khong duoc la so am <br>";
            }
            if(!error.equals("")){
                request.setAttribute("error", error);
                request.setAttribute("u", u);
                request.getRequestDispatcher("university-from.jsp").forward(request, response);
            }else{
                int result = uDAO.insert(u);
                if(result != 0){
                    megs += "Them thanh cong";
                    request.setAttribute("megs", megs);
                    request.getRequestDispatcher("university-from.jsp").forward(request, response);
                }else{
                    megs += "Them khong thanh cong";
                    request.setAttribute("megs", megs);
                    request.getRequestDispatcher("university-from.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
