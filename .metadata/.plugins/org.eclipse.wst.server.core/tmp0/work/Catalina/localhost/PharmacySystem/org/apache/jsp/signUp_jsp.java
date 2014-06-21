/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.41
 * Generated at: 2014-03-17 16:35:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signUp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	String err = "";

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      pharmacy.system.PharmacySystem pharmacy = null;
      synchronized (session) {
        pharmacy = (pharmacy.system.PharmacySystem) _jspx_page_context.getAttribute("pharmacy", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (pharmacy == null){
          pharmacy = new pharmacy.system.PharmacySystem();
          _jspx_page_context.setAttribute("pharmacy", pharmacy, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');

	String username = request.getParameter("userName");
	String password = request.getParameter("password");

	if(request.getParameter("btn") != null && request.getParameter("btn").equals("signup")) {
		String stat = pharmacy.checkUser(username);
		if(stat.equals("error")) {
			err = "This username is already in use.";
		} else {
			pharmacy.createAccount(username, password);
				request.getRequestDispatcher("/signIn.jsp").forward(request, response);
		}
	}
	


      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html lang=\"en-US\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Pharmacy System</title>\r\n");
      out.write("    <script src = 'js/jquery.js'></script>\r\n");
      out.write("    <script src = 'js/bootstrap.js'></script>\r\n");
      out.write("    <script src = 'js/handlebars.js'></script>\r\n");
      out.write("    <script src = 'js/app.js'></script>   \r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-theme.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-theme.min.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("   body\r\n");
      out.write("    {\r\n");
      out.write("    padding-top: 0px;\r\n");
      out.write("    padding-bottom: 70px;\r\n");
      out.write("    background-image: url('Pills.jpg')\r\n");
      out.write("    }\r\n");
      out.write("    .container\r\n");
      out.write("    {\r\n");
      out.write("    margin:10px;\r\n");
      out.write("    color:white;\r\n");
      out.write("    font-style: italic;\r\n");
      out.write("    }\r\n");
      out.write("    div.main\r\n");
      out.write("    {\r\n");
      out.write("    \r\n");
      out.write("    }\r\n");
      out.write("    </style>\r\n");
      out.write("    </head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<form action=\"Controller\" method = \"Post\">\r\n");
      out.write("\t<nav class=\"navbar navbar-inverse\" role=\"navigation\">\r\n");
      out.write("\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("  <a class=\"navbar-brand\" href=\"#\">Pharmacy</a>\r\n");
      out.write("  <li class=\"active\"><button type=\"submit\" name=\"btn\" value=\"signupp\" class=\"active\">Sign Up</button></li>\r\n");
      out.write("  <li><button type=\"submit\" value=\"signinn\" name=\"btn\">Sign In</button></li>\r\n");
      out.write("  \t\t</ul>\r\n");
      out.write("\t<div id=\"main\">\r\n");
      out.write("\t\t<div id=\"form1\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"navbar-text navbar-right\">\r\n");
      out.write("\t\t\t\t\t<label for=\"\" class = \"label\">");
      out.print(err);
      out.write("</label>\r\n");
      out.write("\t\t\t\t\t<label for=\"\" class = \"label\">Username: </label><input type=\"text\" name=\"userName\" class=\"name1\" required/> \r\n");
      out.write("\t\t\t\t\t<label for=\"\" class = \"label\">Password: </label><input type=\"password\" name=\"password\" class=\"name2\" required /> \t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" value=\"signup\" name=\"btn\" class=\"btn btn-default navbar-btn btn-primary btn-sm submit1\">Sign Up</button>\r\n");
      out.write("\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<center>\r\n");
      out.write("\t\t\t\t<nav class=\"navbar navbar-inverse navbar-fixed-bottom\" role=\"navigation\">\r\n");
      out.write("  \t\t\t<div class=\"container\">\r\n");
      out.write(" \r\n");
      out.write("  \t\t\tCopyright 2014. Polytechnic University of the Philippines. \"The Country's First Polytechnic U\"\r\n");
      out.write("  \t\t\t\t</nav>\r\n");
      out.write("  \t\t\t</center>\r\n");
      out.write("  \t\t\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
