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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kasuni
 */
@WebServlet(name = "EmployeeDetailsServlet", urlPatterns = {"/EmployeeDetailsServlet"})
public class EmployeeDetailsServlet extends HttpServlet {
    
    DBHandler DH = new DBHandler ();
    Employee employee;
    Task task;

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
            out.println("<title>Servlet EmployeeDetailsServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmployeeDetailsServlet at " + request.getContextPath() + "</h1>");
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
        int employeeID = Integer.parseInt(request.getParameter("employeeID"));
        DH = new DBHandler();
         List employeeList = DH.getEmployeeById(employeeID);
        DH = new DBHandler();
        List rolesList = DH.listValidRoles();
        request.setAttribute("rolesList", rolesList);
        DH = new DBHandler();
        List tasksList = DH.listValidTasks();
        request.setAttribute("tasksList", tasksList);
        employee = (Employee)employeeList.get(0);
        request.setAttribute("employee",employee );
        request.getRequestDispatcher("/views/viewEmployeeDetail.jsp").forward(request, response);
        
        
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
        
        int employeeID = Integer.parseInt(request.getParameter("employeeID"));
            
            String name = request.getParameter("name");
            int role = Integer.parseInt(request.getParameter("role"));
            //String [] tasks = request.getParameterValues("tasks");
            
            employee.setEmployeeID(employeeID);
            
            employee.setName(name);
            
            if(role==0){
                employee.setRole(null);
            }else{
                 DH = new DBHandler();
            List roleList = DH.getRoleById(role);
            employee.setRole((Role)roleList.get(0));
            }
            
//            if (tasks.length==0)
//            {
//                employee.addTask(null);
//            }
//            else{
//              for(int i=0;i<tasks.length;i++){
//                DH = new DBHandler();
//                List taskList = DH.getTaskById(Integer.parseInt(tasks[i]));
//                //Task task = (Task)taskList.get(0);
//            
//                    employee.addTask((Task)taskList.get(0));
//               
//                
//                 
//            }
//            
//            }
            
            
//            String[] tasks = request.getParameterValues("tasks");
//            for(int i=0;i<tasks.length;i++){
//                DH = new DBHandler();
//                List taskList = DH.getTaskByemployeeId(employeeID);
//                employee.addTask((Task)taskList.get(0));
//                 
//            }
//              List tasksList = DH.listValidTasks();
//              
//              employee.addTask((Task)tasksList.get(0));
        //request.setAttribute("tasksList", tasksList);
            
//            Set assignedTasks = employee.getTasks();
//            List assignedTasksList = new ArrayList();
//              
//           for (Iterator iter = assignedTasks.iterator(); iter.hasNext();) {
//            assignedTasksList.add((Task) iter.next());
//           }
//            String[] tasks = request.getParameterValues("tasks");
//            for(int i=0;i<tasks.length;i++){
//                DH = new DBHandler();
//                List taskList = DH.getTaskById(Integer.parseInt(tasks[i]));
//                Task task = (Task)taskList.get(0);
            
//                if(!assignedTasks.contains(task)){
//                    employee.addTask((Task)taskList.get(0));
//                }
//                
//                 
//            }
            
            
            
            DH = new DBHandler();
            DH.editEmployee(employee);
            

        response.sendRedirect("EmployeeDetailsServlet?employeeID="+employee.getEmployeeID());
        
        
       
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
