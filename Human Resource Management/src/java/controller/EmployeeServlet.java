/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import HRM.DBHandler;
import HRM.Employee;
import HRM.Role;
import HRM.Task;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Kasuni
 */
@WebServlet(name = "EmployeeServlet", urlPatterns = {"/EmployeeServlet"})
public class EmployeeServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmployeeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmployeeServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        DBHandler DH = new DBHandler();
        List employeesList = DH.listEmployees();
        request.setAttribute("employeesList", employeesList);
        DH = new DBHandler();
        List rolesList = DH.listValidRoles();
        request.setAttribute("rolesList", rolesList);
        DH = new DBHandler();
        List tasksList = DH.listValidTasks();
        request.setAttribute("tasksList", tasksList);
        request.getRequestDispatcher("/views/viewEmployee.jsp").forward(request, response);
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
        
            String name = request.getParameter("name");
            int role = Integer.parseInt(request.getParameter("role"));
            DBHandler DH = new DBHandler();
            List roleList = DH.getRoleById(role);
            
            Employee employee = new Employee();

            employee.setName(name);
            employee.setRole((Role)roleList.get(0));
            
            
            String[] tasks = request.getParameterValues("tasks");
            for(int i=0;i<tasks.length;i++){
                DH = new DBHandler();
                List taskList = DH.getTaskById(Integer.parseInt(tasks[i]));
                employee.addTask((Task)taskList.get(0));
                 
            }
            
            DH = new DBHandler();
            DH.addEmployee(employee);

        response.sendRedirect("EmployeeServlet");
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
