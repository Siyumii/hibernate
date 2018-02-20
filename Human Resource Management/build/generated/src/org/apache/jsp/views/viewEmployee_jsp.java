package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import HRM.Task;
import HRM.Employee;
import java.util.List;
import HRM.Role;

public final class viewEmployee_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Employees</title>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\" style=\"margin-top:2%; width: 1000px\">\n");
      out.write("            <div id=\"page-wrapper\">\n");
      out.write("\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("                <!-- Page Heading -->\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-12\">\n");
      out.write("                        <h1 class=\"page-header\">\n");
      out.write("                          Employees   \n");
      out.write("                        </h1>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"panel panel-primary\">\n");
      out.write("                        <div class=\"panel-heading\">Enter Employee Details</div>\n");
      out.write("                            <div class=\"panel-body\">                                \n");
      out.write("                              ");

         List<Employee> employees = (List<Employee>)request.getAttribute("employeesList");
         List<Role> roles = (List<Role>)request.getAttribute("rolesList");
         List<Task> tasks = (List<Task>)request.getAttribute("tasksList");
         
       
      out.write("\n");
      out.write("                                 <form action=\"EmployeesServlet\" method=\"POST\">\n");
      out.write("        \n");
      out.write("            \n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label>Name</label><br/>\n");
      out.write("                                        <input type=\"text\" name=\"name\" id=\"name\" />\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label>Role</label><br/>\n");
      out.write("                                        <select name=\"role\" id=\"role\">\n");
      out.write("                                        <option value=\"\" selected >Select Role</option>\n");
      out.write("                                            ");

                                                for(int i=0;i<roles.size();i++)
                                                {
                                                    Role role = roles.get(i) ;    
                                            
      out.write("\n");
      out.write("                                        <option value=\"");
      out.print( role.getRoleID());
      out.write('"');
      out.write('>');
      out.print( role.getTitle());
      out.write("</option>\n");
      out.write("                                            ");
 }
      out.write("\n");
      out.write("                                         </select>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                        <label>Role</label><br/>\n");
      out.write("                                        <table class=\"table table-bordered table-hover\">\n");
      out.write("                                            <thead>\n");
      out.write("                                                <tr style=\"background-color:lightblue\">\n");
      out.write("                                    \n");
      out.write("                                                <th>Task</th>\n");
      out.write("                                                <th>Assign</th>\n");
      out.write("                                    \n");
      out.write("                                                </tr>\n");
      out.write("                                            </thead>\n");
      out.write("                            \n");
      out.write("                            <tbody>\n");
      out.write("                              \n");
      out.write("                                ");

           for(int i=0;i<tasks.size();i++)
           {
            Task task = tasks.get(i) ;    

      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    \n");
      out.write("                                    <td>");
      out.print( task.getDescription());
      out.write("</td>\n");
      out.write("                                    <td><input type=\"checkbox\" class=\"largerCheckbox\" value=\"");
      out.print( task.getTaskID());
      out.write("\" name=\"tasks\"/></td>\n");
      out.write("                                    \n");
      out.write("                                </tr>\n");
      out.write("                                 ");
     
                                    }
                                    
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                            \n");
      out.write("                        </table>\n");
      out.write("                                 </div>\n");
      out.write("           <input type=\"submit\" value=\"Add\" id=\"add\" class=\"btn btn-lg btn-primary\"/> \n");
      out.write("           <input type=\"reset\" value=\"Cancel\" id=\"edit\" class=\"btn btn-lg btn-danger\" />   \n");
      out.write("      \n");
      out.write("     </form>\n");
      out.write("                                \n");
      out.write("                            \n");
      out.write("                            </div>\n");
      out.write("                                \n");
      out.write("                    </div>\n");
      out.write("                                \n");
      out.write("                            <div class=\"panel panel-primary\">\n");
      out.write("                                <div class=\"panel-heading\">Available Employee Details</div>\n");
      out.write("                                    <div class=\"panel-body\">                                \n");
      out.write("                                        <div class=\"table-responsive\">\n");
      out.write("                                  \n");
      out.write("                                            <table class=\"table table-bordered table-hover\">\n");
      out.write("                                                <thead>\n");
      out.write("                                                    <tr style=\"background-color:lightblue\">\n");
      out.write("                                                        <th>Employee ID</th>\n");
      out.write("                                                        <th>Name</th>\n");
      out.write("                                                        <th>Role</th>\n");
      out.write("                                                        <th>Edit</th>\n");
      out.write("\n");
      out.write("                                                    </tr>\n");
      out.write("                                                </thead>\n");
      out.write("                            \n");
      out.write("                                                <tbody>\n");
      out.write("                              \n");
      out.write("                                                        ");

                                                        for(int i=0;i<employees.size();i++)
                                                        {
                                                            Employee employee = employees.get(i) ;    
                                                        
      out.write("\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td>");
      out.print( employee.getEmployeeID());
      out.write("</td>\n");
      out.write("                                                        <td>");
      out.print( employee.getName());
      out.write("</td>\n");
      out.write("                                                                ");
 Role role = employee.getRole(); 
      out.write("\n");
      out.write("                                                        <td> ");
      out.print( role.getTitle());
      out.write(" </td>\n");
      out.write("                                                        <td><input type=\"Submit\" class=\"btn btn-lg btn-info\" value=\"View\" onclick=\"window.location.href='EmployeeDetailServlet?employeeID='+");
      out.print( employee.getEmployeeID());
      out.write("\"/> </td>\n");
      out.write("                                    \n");
      out.write("                                                    </tr>\n");
      out.write("                                                        ");
     
                                                        }
                                                        
      out.write("\n");
      out.write("                                                </tbody>\n");
      out.write("                            \n");
      out.write("                                            </table>\n");
      out.write("                                        </div>\n");
      out.write("                                \n");
      out.write("                                    </div>     \n");
      out.write("                                \n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- /.container-fluid -->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("                \n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("           \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
