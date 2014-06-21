/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.41
 * Generated at: 2014-03-31 03:24:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class student_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/bootstrap.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/main.css\" />\r\n");
      out.write("<title>Class Record Project: Students Page</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      classes.record.ClassRecord classrecord = null;
      synchronized (session) {
        classrecord = (classes.record.ClassRecord) _jspx_page_context.getAttribute("classrecord", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (classrecord == null){
          classrecord = new classes.record.ClassRecord();
          _jspx_page_context.setAttribute("classrecord", classrecord, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");

	String message = "";

	String[] students = request.getParameterValues("students");
	String getStudent = request.getParameter("getstudent");
	String back = request.getParameter("back");
	String addNewStudent = request.getParameter("addnewstudent");
	String deleteStudent = request.getParameter("deletestudent");
	
	if(back!=null){
		
      if (true) {
        _jspx_page_context.forward("ClassList");
        return;
      }

	} else if(getStudent!=null){
		classrecord.setNameOfStudent(getStudent);
		classrecord.setStudent(getStudent);
		
      if (true) {
        _jspx_page_context.forward("GradeSheet");
        return;
      }

	} else if(addNewStudent!=null){
		
      if (true) {
        _jspx_page_context.forward("AddNewStudent");
        return;
      }

	} else if(deleteStudent!=null){
		classrecord.deleteStudent(students);
	}
	
	message = classrecord.getMessage();
	
	classrecord.setStudents();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<center>\r\n");
      out.write("\t\t<div class=\"panel panel-info tabled\">\r\n");
      out.write("\t\t\t<div class=\"panel-heading\">\r\n");
      out.write("\t\t\t\t<h4>Class ");
      out.print(classrecord.getClassSection() );
      out.write("</h4>\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"panel-body\">\r\n");
      out.write("\t\t\t\t<form action=\"StudentList\">\r\n");
      out.write("\t\t\t\t\t<table class=\"table table-bordered table-hover\">\r\n");
      out.write("\t\t\t\t\t\t<tr class=\"active\">\r\n");
      out.write("\t\t\t\t\t\t\t<th><input type=\"checkbox\" id=\"checkAllStudents\" ");
      out.print(classrecord.getStudentRow()==0 ? "DISABLED" : "" );
      out.write("/></th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Student ID</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Name</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Address</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Gender</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Contact</th>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t");
for(int i = 0; i<classrecord.getStudentId().size(); i++){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"active\"><input type=\"checkbox\" name=\"students\" value=\"");
      out.print(classrecord.getStudentId().get(i) );
      out.write("\" class=\"checkbox\"/></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type=\"submit\" name=\"getstudent\" value=\"");
      out.print(classrecord.getStudentId().get(i));
      out.write("\" class=\"btn btn-success buton-class\"/></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(classrecord.getStudentName().get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(classrecord.getStudentAddress().get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(classrecord.getStudentGender().get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(classrecord.getStudentContact().get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t");
}
							classrecord.clearLists();
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<hr />\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" name=\"addnewstudent\" value=\"Add New Student\" class=\"btn btn-primary buton\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" name=\"back\" value=\"Back to Class List\" class=\"btn btn-info buton\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" name=\"deletestudent\" value=\"Delete Student\" ");
      out.print(classrecord.getStudentRow()==0 ? "DISABLED" : "" );
      out.write(" class=\"btn btn-danger buton\"/>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");
if(!message.equals("")){
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"alert alert-danger\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(message );
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\t\t\r\n");
      out.write("\t\t\t\t");

						classrecord.setMessage("");
					}
				
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</center>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tdocument.getElementById(\"checkAllStudents\").onclick = function(){\r\n");
      out.write("\t\t\tvar classes = document.getElementsByName(\"students\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(document.getElementById(\"checkAllStudents\").checked){\r\n");
      out.write("\t\t\t\tfor(var i = 0; i< classes.length; i++){\r\n");
      out.write("\t\t\t\t\tclasses[i].checked  = true;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t} else{\t\t\t\r\n");
      out.write("\t\t\t\tfor(var i = 0; i< classes.length; i++){\r\n");
      out.write("\t\t\t\t\tclasses[i].checked  = false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t};\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
