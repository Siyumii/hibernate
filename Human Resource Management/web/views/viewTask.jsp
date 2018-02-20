<%-- 
    Document   : viewTask
    Created on : Oct 15, 2017, 2:27:02 PM
    Author     : Kasuni
--%>

<%@page import="java.util.List"%>
<%@page import="HRM.Task"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tasks</title>
         <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        
        <script>
            function TaskFunction(taskID,description) {
                document.getElementById("taskID").value = taskID;
                document.getElementById("description").value = description;
                document.getElementById("add").disabled = true;
                document.getElementById("edit").disabled = false;
            }
            function reset() {
                document.getElementById("description").value = "";
                document.getElementById("add").disabled = false;
                document.getElementById("edit").disabled = true;
            }
        </script>
        
        
    </head>
    <body>
        <div class="container" style="margin-top:2%; width:1000px">
            <div class="panel panel-primary">
                
                <div class="panel-heading" align = "center" style="height: 60px; padding-top: 1px" >
                    <h3 style="margin-top: 15px"> Task Management</h3>
                </div> 
                
                
                    <div class="panel-body">  
                        
                        <ol class="breadcrumb">
                            <li><a style="color: #0066ff" href="index.xhtml">Home</a></li>
                            <li><a style="color: #0066ff" href="RoleServlet">Role Management</a></li>
                            <li><a style="color: #0066ff" href="EmployeeServlet?key=viewEmployee">Employee Management</a></li>
                            <li><a style="color: #0066ff" href="TaskServlet?key=viewTask">Task Management</a></li>
                        </ol>
                            
                        <h4 style="color: darkblue; padding-top: 10px">Enter Task Details</h4>
                        <form action="TaskServlet" method="POST">
        
                            <input type="text" name="taskID" id="taskID" hidden="true"/>
                            <div class="form-group">
                            <label>Description</label><br/>
                            <input type="text" name="description" id="description" required="true" required pattern="[A-Za-z]*" title="Only alpahabetical characters allowed"/>
                            </div>


                            <input type="submit" value="Add" id="add" class="btn btn-lg btn-primary"/>
                            <input type="submit" value="Edit" id="edit" disabled="true" class="btn btn-lg btn-primary"/> 
                            <input type="reset" value="Clear" id="cancel" class="btn btn-lg btn-primary" onclick="reset();"/> 
           
      
                        </form>
                        
                                            
                    </div>
                              
            </div>
            
            <div class="panel panel-primary">
                    <div class="panel-heading">Available Tasks Details</div>
                        <div class="panel-body">                                
                            <div class="table-responsive">
                              <%
                                List<Task> tasks = (List<Task>)request.getAttribute("tasksList");
                              %>
                                <table class="table table-bordered table-hover">
                                    <thead>
                                        <tr style="background-color:lightblue">
                                            <th>Task ID</th>
                                            <th>Description</th>
                                            <th>Edit</th>

                                        </tr>
                                    </thead>

                                    <tbody>

                                        <%
                                           for(int i=0;i<tasks.size();i++)
                                           {
                                            Task task = tasks.get(i) ;    
                                        %>
                                        <tr>
                                            <td><%= task.getTaskID()%></td>
                                            <td><%= task.getDescription()%></td>
                                            <td><input type="Submit" class="btn btn-warning" value="Edit" onclick="TaskFunction('<%= task.getTaskID()%>','<%= task.getDescription()%>');"/> </td>

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
