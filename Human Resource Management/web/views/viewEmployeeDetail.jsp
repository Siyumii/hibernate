<%-- 
    Document   : viewEmployeeDetail
    Created on : Oct 24, 2017, 7:38:34 PM
    Author     : Kasuni
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="HRM.Employee"%>
<%@page import="HRM.Task"%>
<%@page import="java.util.List"%>
<%@page import="HRM.Role"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Details</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        
        <script>
            function myFunction(employeeID) {
                document.getElementById("name").disabled = false;
                document.getElementById("role").disabled = false;
                document.getElementById("update").disabled = false;
                document.getElementById("edit").disabled = true;
                document.getElementById("taskTable").style.display = "none";
                document.getElementById("assignTable").style.display = "inline-table";
                
                
            }
            function reset() {
                document.getElementById("description").value = "";
                document.getElementById("update").disabled = true;
                document.getElementById("edit").disabled = false;
                
            }
        </script>
    </head>
    <body>
        <div class="container" style="margin-top:2%; width: 1000px">
          <div class="panel panel-primary">
                        <div class="panel-heading">Employee Details</div>
                            <div class="panel-body">     
                                 <ol class="breadcrumb">
                                    <li><a style="color: #0066ff" href="index.xhtml">Home</a></li>
                                    <li><a style="color: #0066ff" href="RoleServlet">Role Management</a></li>
                                    <li><a style="color: #0066ff" href="EmployeeServlet?key=viewEmployee">Employee Management</a></li>
                                    <li><a style="color: #0066ff" href="TaskServlet?key=viewTask">Task Management</a></li>
                                </ol>
                       
                              <%
                                List<Role> roles = (List<Role>)request.getAttribute("rolesList");
                                List<Task> tasks = (List<Task>)request.getAttribute("tasksList");
                                Employee employee = (Employee)request.getAttribute("employee");
         
                             %>
                                 <form action="EmployeeDetailsServlet?employeeID=<%= employee.getEmployeeID()%>" method="POST">
        
                                    <div class="form-group">
                                        <label>Employee ID</label><br/>
                                        <label><%= employee.getEmployeeID()%></label><br/>
                
                                    </div>
                                    <div class="form-group">
                                        <label>Name</label><br/>
                                        <input type="text" name="name" id="name" value="<%= employee.getName()%>" disabled="true"/>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label>Role</label><br/>
                                         <select name="role" id="role" disabled="true">
                                            <%
                         
                                                Role role = employee.getRole() ;    
                                            %>
                                         <option value="0" selected >Select Role</option>
                                         <option value="<%= role.getRoleID()%>" selected ><%= role.getTitle()%></option>
                            
                                            <%
                                            for(int i=0;i<roles.size();i++)
                                            {
                                                Role valiRole = roles.get(i) ;    
                                            %>
                                            <option value="<%= valiRole.getRoleID()%>"><%= valiRole.getTitle()%></option>
                                                <% }%>
                                         </select>
                                    </div>
                                         
                                    <div class="form-group">
                                        <label>Task</label><br/>
                                            <table id="taskTable" class="table table-bordered table-hover">
                                                <thead>
                                                    <tr style="background-color:lightblue">
                                    
                                                        <th>Tasks</th>
                                                        <th hidden="true">Assign</th>
                                    
                                                    </tr>
                                                </thead>
                            
                                                <tbody>
                              
                                                    <%
 
                                                        Set taskList = employee.getTasks() ;  
                                                        for (Iterator iter = taskList.iterator(); iter.hasNext();) {
                                                        Task task = (Task) iter.next();

         
                                                    %>
                                                    <tr>

                                                        <td><%= task.getDescription()%></td>
                                                        <td hidden="true"><input disabled="true" type="checkbox" class="largerCheckbox" value="<%= task.getTaskID()%>" name="assignedTasks" checked="true"/></td>

                                                    </tr>
                                                    <%     
                                                       }
                                                    %>
                                                </tbody>
                            
                                            </table>
                            <table id="assignTable" style="display: none" id="tt" class="table table-bordered table-hover">
                                <thead>
                                    <tr style="background-color:lightblue">

                                        <th>Tasks</th>
                                        <th>Assign</th>

                                    </tr>
                                </thead>
                            
                                 <tbody>
                              
                                <%

                                    for (Iterator iter = taskList.iterator(); iter.hasNext();) {
                                     tasks.add((Task) iter.next());
                                    }
                                             for(int i=0;i<tasks.size();i++)
                                    {
                                     Task task = tasks.get(i) ; 
                                %>
                                <tr>
                                    
                                    <td><%= task.getDescription()%></td>
                                    
                                    <td>
                                        <%
                                        if(task.getEmployee()==null){
                                        
                                    %>
                                        <input type="checkbox" class="largerCheckbox" value="<%= task.getTaskID()%>" name="tasks"/></td>
                                    <%
                                        
                                        }else{

                                    %>
                                        <input type="checkbox" class="largerCheckbox" value="<%= task.getTaskID()%>" name="tasks" checked="true"/></td>
                                    <%
                                        
                                        }
                                    %>
                                </tr>
                                    <%     
                                    }
                                    %>
                            </tbody>
                            
                            </table>
                                 </div>
           
           <input type="button" value="Edit" id="edit" class="btn btn-lg btn-primary" onclick="myFunction();"/> 
           <input type="submit" value="Update" id="update" class="btn btn-lg btn-primary" disabled="true"/> 
           <input type="reset" value="Cancel" id="cancel" class="btn btn-lg btn-primary" />   
      
     </form>
                                
                            
                            </div>
                                
                    </div>  
            
            
            
        </div>
    </body>
</html>
