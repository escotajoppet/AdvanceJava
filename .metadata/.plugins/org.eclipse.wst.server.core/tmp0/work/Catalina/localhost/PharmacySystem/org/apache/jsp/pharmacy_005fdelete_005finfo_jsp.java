/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.41
 * Generated at: 2014-03-17 16:37:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pharmacy_005fdelete_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Pharmacy System</title>\r\n");
      out.write("    <script src = 'js/jquery.js'></script>\r\n");
      out.write("    <script src = 'js/bootstrap.js'></script>\r\n");
      out.write("    <script src = 'js/handlebars.js'></script>\r\n");
      out.write("    <script src = 'js/app.js'></script>   \r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-theme.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-theme.min.css\">\r\n");
      out.write("    \r\n");
      out.write("</head>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("    body\r\n");
      out.write("    {\r\n");
      out.write("    padding-top: 0px;\r\n");
      out.write("    padding-bottom: 70px;\r\n");
      out.write("    background: #9c1f1e;\r\n");
      out.write("    background-image: url('Pills.jpg')\r\n");
      out.write("    }\r\n");
      out.write("    .container\r\n");
      out.write("    {\r\n");
      out.write("    margin:10px;\r\n");
      out.write("    color:white;\r\n");
      out.write("    font-style: italic;\r\n");
      out.write("    }\r\n");
      out.write("    span.bodyDiv\r\n");
      out.write("    {\r\n");
      out.write("     opacity:1;  \r\n");
      out.write("     color: white;\r\n");
      out.write("    }\r\n");
      out.write("    div.bodyBG\r\n");
      out.write("    {\r\n");
      out.write("    width:600px;\r\n");
      out.write("  \theight:150px;\r\n");
      out.write("  \tmargin:30px 50px;\r\n");
      out.write("    border:1px solid black;\r\n");
      out.write("  \tbackground-color: rgba(2,2,2,0.3); // Sets to 50% transparent\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    </style>\r\n");
      pharmacy.system.PharmacySystem pharmacy = null;
      synchronized (session) {
        pharmacy = (pharmacy.system.PharmacySystem) _jspx_page_context.getAttribute("pharmacy", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (pharmacy == null){
          pharmacy = new pharmacy.system.PharmacySystem();
          _jspx_page_context.setAttribute("pharmacy", pharmacy, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");

	String txtDeleteBrandName = request.getParameter("deletebrandname");
	
	if(session.getAttribute("username")== null) {
		pharmacy.setLogOut(1);
		request.getRequestDispatcher("/signIn.jsp").forward(request, response);
	} else {
		if(request.getParameter("btn")!=null && request.getParameter("btn").equals("sign_out_delete")) {
			session.removeAttribute("username");
			session.invalidate();
			request.getRequestDispatcher("/signIn.jsp").forward(request, response);			
		}		
	}
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("deleteinfo")){
		pharmacy.deleteInfo(txtDeleteBrandName);
		request.getRequestDispatcher("/pharmacy_main_page.jsp").forward(request, response);
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<form action=\"Controller\" method=\"post\">\r\n");
      out.write("\t<center>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<nav class=\"navbar navbar-inverse\" role=\"navigation\">\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("  \t\t\t\t\t<a class=\"navbar-brand\" href=\"#\">Pharmacy</a>\r\n");
      out.write("  \t\t\t\t\t\t<li><button type=\"submit\" name=\"btn\" value=\"home\">Home</button></li>\r\n");
      out.write("\t\t\t\t\t\t  <li><button type=\"submit\" name=\"btn\" value=\"add_info\">Add</button></li>\r\n");
      out.write("\t\t\t\t\t\t  <li class=\"active\"><button type=\"submit\" name=\"btn\" value=\"delete_info\">Delete</button></li>\r\n");
      out.write("\t\t\t\t\t\t  <li><button type=\"submit\" name=\"btn\" value=\"view\">View</button></li>\r\n");
      out.write("\t\t\t\t\t\t  <li><button type=\"submit\" name=\"btn\" value=\"search\">Search</button></li> \r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<p class=\"navbar-text navbar-right\">\r\n");
      out.write("\t<button type=\"submit\" class=\"btn btn-default btn-danger btn-sm\" name=\"btn\" value=\"sign_out_delete\">Sign Out</button></p>\r\n");
      out.write("\t\t\t</nav>\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t<br> <br> <br>\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t<div style=\"position: absolute; left: 250px; top: 40px;\"> \r\n");
      out.write("\t\t\t<img src=\"delete.png\" alt=\"\" >\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"position: absolute; left: 595px; top: 400px;\"> \r\n");
      out.write("\t\t\t<img src=\"redcross.png\" alt=\"\" >\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"bodyBG\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<span class=\"bodyDiv\">\r\n");
      out.write("\t\t\t<br><br>\r\n");
      out.write("\t\t\tBrand Name: <i><font color=\"black\"><input size=\"50\" type=\"text\" placeholder=\" Input Brand Name\" name=\"deletebrandname\"/></i></font>\r\n");
      out.write("\t\t\t<button type=\"submit\" class=\"btn btn-default navbar-btn btn-danger\" name=\"btn\" value=\"deleteinfo\">Delete</button><br /><br />\r\n");
      out.write("\t\t\t</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<nav class=\"navbar navbar-inverse navbar-fixed-bottom\" role=\"navigation\">\r\n");
      out.write("  \t\t\t<div class=\"container\">\r\n");
      out.write("  \t\t\tCopyright 2014. Polytechnic University of the Philippines. \"The Country's First Polytechnic U\"\r\n");
      out.write("  \t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</center>\r\n");
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
