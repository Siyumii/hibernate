<%-- 
    Document   : viewEmployee
    Created on : Oct 14, 2017, 7:46:08 PM
    Author     : Kasuni
--%>

<%@page import="HRM.Task"%>
<%@page import="HRM.Employee"%>
<%@page import="java.util.List"%>
<%@page import="HRM.Role"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employees</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    </head>

    <body>
        <div class="container" style="margin-top:2%; width: 1000px">
            
                <div class="panel panel-primary">
                    <div class="panel-heading" align = "center" style="height: 60px; padding-top: 1px" >
                    <h3 style="margin-top: 15px"> Employee Management</h3>
                    </div> 
                    
                     
                       
                            <div class="panel-body"> 
                                <ol class="breadcrumb">
                                    <li><a style="color: #0066ff" href="index.xhtml">Home</a></li>
                                    <li><a style="color: #0066ff" href="RoleServlet">Role Management</a></li>
                                    <li><a style="color: #0066ff" href="EmployeeServlet?key=viewEmployee">Employee Management</a></li>
                                    <li><a style="color: #0066ff" href="TaskServlet?key=viewTask">Task Management</a></li>
                                </ol>
                                
                                
                              <%
                                    List<Employee> employees = (List<Employee>)request.getAttribute("employeesList");
                                    List<Role> roles = (List<Role>)request.getAttribute("rolesList");
                                    List<Task> tasks = (List<Task>)request.getAttribute("tasksList");
         
                               %>
                               
                               <h4 style="color: darkblue; padding-top: 10px" >Enter Employee Details</h4>
                                <form action="EmployeeServlet" method="POST">
        
            
                                    <div class="form-group">
                                        <label>Name</label><br/>
                                        <input type="text" name="name" id="name" required="true" required pattern="[A-Za-z]*" title="Only alpahabetical characters allowed" />
                                    </div>
                                    
                                    <div class="form-group">
                                        <label>Role</label><br/>
                                        <select name="role" id="role" required="true">
                                                <option value="" selected >Select Role</option>
                                                        <%
                                                            for(int i=0;i<roles.size();i++)
                                                            {
                                                                Role role = roles.get(i) ;    
                                                        %>
                                                <option value="<%= role.getRoleID()%>"><%= role.getTitle()%></option>
                                                         <% }%>
                                            </select>
                                     </div>
                                            
                                    <div class="form-group">
                                        <label>Role</label><br/>
                                            <table class="table table-bordered table-hover">
                                                <thead>
                                                    <tr style="background-color:lightblue">

                                                        <th>Task</th>
                                                        <th>Assign</th>

                                                    </tr>
                                                </thead>

                                                <tbody>

                                                    <%
                                                        for(int i=0;i<tasks.size();i++)
                                                        {
                                                                Task task = tasks.get(i) ;    
                                                    %>
                                                    
                                                    <tr>

                                                        <td><%= task.getDescription()%></td>
                                                        <td><input type="checkbox" class="largerCheckbox" value="<%= task.getTaskID()%>" name="tasks"/></td>

                                                    </tr>
                                                    <%     
                                                    }
                                                    %>
                                                </tbody>

                                            </table>
                                    </div>
                                        <input type="submit" value="Add" id="add" class="btn btn-lg btn-primary"/> 
                                        <input type="reset" value="Cancel" id="edit" class="btn btn-lg btn-primary"/>   
      
                                </form>
                                
                            
                            </div>
                                
                </div>
                                
                            <div class="panel panel-primary">
                                <div class="panel-heading">Available Employee Details</div>
                                    <div class="panel-body">                                
                                        <div class="table-responsive">
                                  
                                            <table class="table table-bordered table-hover">
                                                <thead>
                                                    <tr style="background-color:lightblue">
                                                        <th>Employee ID</th>
                                                        <th>Name</th>
                                                        <th>Role</th>
                                                        <th>View</th>

                                                    </tr>
                                                </thead>
                            
                                                <tbody>
                              
                                                        <%
                                                        for(int i=0;i<employees.size();i++)
                                                        {
                                                            Employee employee = employees.get(i) ;    
                                                        %>
                                                    <tr>
                                                        <td><%= employee.getEmployeeID()%></td>
                                                        <td><%= employee.getName()%></td>
                                                                <% Role role = employee.getRole(); %>
                                                        <td> <%= role.getTitle()%> </td>
                                                        <td><input type="Submit" class="btn btn-lg btn-info" value="View" onclick="window.location.href='EmployeeDetailsServlet?employeeID='+<%= employee.getEmployeeID()%>"/> </td>
                                    
                                                    </tr>
                                                        <%     
                                                        }
                                                        %>
                                                </tbody>
                            
                                            </table>
                                        </div>
                                
                                    </div>     
                                
                            </div>

           

 
                

        </div>
           
    </body>
</html>
