/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.41
 * Generated at: 2014-03-31 17:30:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class guestLogs_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Library System</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/main.css\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/guestlogs.css\" /> \r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      library.system.LibrarySystem librarySystem = null;
      synchronized (session) {
        librarySystem = (library.system.LibrarySystem) _jspx_page_context.getAttribute("librarySystem", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (librarySystem == null){
          librarySystem = new library.system.LibrarySystem();
          _jspx_page_context.setAttribute("librarySystem", librarySystem, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");

	librarySystem.clearLogs();
	librarySystem.viewGuestLogs();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"main\">\r\n");
      out.write("\t<div id=\"header\">\r\n");
      out.write("\t\t<img src=\"img/logo.png\" alt=\"\" />\r\n");
      out.write("\t\t<h1>Library</h1>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t<div id=\"table\">\r\n");
      out.write("\t\t<h1>Guests Logs</h1> <br />\r\n");
      out.write("\t\t<table border=\"1\" cellpadding=\"5\" >\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>Transaction Date</th>\r\n");
      out.write("\t\t\t\t<th>Student ID</th>\r\n");
      out.write("\t\t\t\t<th>Student Name</th>\r\n");
      out.write("\t\t\t\t<th>Transaction</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");

				for(int i = 0; i<librarySystem.getLogsDateTime().size(); i++){
			
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(librarySystem.getLogsDateTime().get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(librarySystem.getLogsStudentNumber().get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(librarySystem.getLogsName().get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(librarySystem.getLogsTransaction().get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br /><br />\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\t\t<form action=\"Controller\"><button type=\"submit\" name=\"btn\" value=\"back\" class=\"back\"></button></form>\r\n");
      out.write("\t\t</center>\r\n");
      out.write("<div id=\"footer\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
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
