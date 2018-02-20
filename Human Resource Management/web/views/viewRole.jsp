<%-- 
    Document   : viewRole
    Created on : Oct 14, 2017, 7:29:51 PM
    Author     : Kasuni
--%>

<%@page import="java.util.List"%>
<%@page import="HRM.Role"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script>
            function myFunction(roleID,title) {
                document.getElementById("roleID").value = roleID;
                document.getElementById("title").value = title;
                document.getElementById("add").disabled = true;
                document.getElementById("edit").disabled = false;
            }
            function reset() {
                document.getElementById("title").value = "";
                document.getElementById("add").disabled = false;
                document.getElementById("edit").disabled = true;
            }
          
        </script>
        <title>Roles</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    </head>

    <body>
        <div class="container" style="margin-top:2%; width: 1000px">

            <div class="panel panel-primary"> 
                <div class="panel-heading" align = "center" style="height: 60px; padding-top: 1px" >
                    <h3 style="margin-top: 15px"> Role Management</h3>
                </div> 

                <div class="panel-body"> 
                    <ol class="breadcrumb">
                        <li><a style="color: #0066ff" href="index.xhtml">Home</a></li>
                        <li><a style="color: #0066ff" href="RoleServlet">Role Management</a></li>
                        <li><a style="color: #0066ff" href="EmployeeServlet?key=viewEmployee">Employee Management</a></li>
                        <li><a style="color: #0066ff" href="TaskServlet?key=viewTask">Task Management</a></li>
                    </ol>
                    
                    <h4 style="color: darkblue; padding-top: 10px" >Enter Role Details</h4>
                    
                        <div class="panel-body">
                            <form action="RoleServlet" method="post">
                                <input type="text" name="roleID" id="roleID" hidden="true"/>
                                <div class="form-group">
                                <label>Title</label><br/>
                                <input type="text" name="title" id="title" required="true" required pattern="[A-Za-z]*" title="Only alpahabetical characters allowed"/>
                                
                                <input type="submit" value="Add" id="add" class="btn btn-primary"/>
                                </div>
                                
                                <input type="submit" value="Edit" id="edit" disabled="true" class="btn btn-primary"/>
                                <input type="reset" value="Cancel" id="clear" class="btn btn-primary" onclick="reset();"/>
                                </form>
                                
                                                    
                        </div>

                    
                </div>
            </div>
             <div class="panel panel-primary"> 
                        
                        
                        <h4 style="color: darkblue; padding-top: 10px" >List Roles</h4>
                    
                                   <%
                                    List<Role> roles = (List<Role>)request.getAttribute("rolesList");
                                  %>

                    <table class="table table-striped table-bordered table table-bordered table-hover">
                        <thead>
                            <tr style="background-color:lightblue">
                                <th>Role ID</th>
                                <th>Title</th>
                                <th>Edit</th>
                            </tr>
                        </thead>
                        <tbody>      
                            <%
                                for(int i=0;i<roles.size();i++)
                                {
                                    Role role = roles.get(i) ;    
                                %>
                            <tr>
                                <td><%= role.getRoleID() %></td>
                                <td><%= role.getTitle() %></td>
                                <td><input type="Submit" class="btn btn-warning" value="Edit" onclick="myFunction('<%= role.getRoleID() %>','<%= role.getTitle() %>');"/> </td>

                            </tr>
                            <%     
                            }
                            %>
                        </tbody>                    
                    </table>
                    
             </div>
        </div>
    </body>
</html>



