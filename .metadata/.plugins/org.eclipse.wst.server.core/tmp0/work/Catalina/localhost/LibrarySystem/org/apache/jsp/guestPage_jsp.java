/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.41
 * Generated at: 2014-04-01 04:24:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class guestPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html lang=\"en-US\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>Library System</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/main.css\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/guestlogin.css\" />\r\n");
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

	String guestsearch = request.getParameter("guestSearch");
	String category = request.getParameter("category");
	String btn = request.getParameter("btn");
	
	String[] bookstoborrow = request.getParameterValues("checkedborrow");
	
	if(btn != null && btn.equals("guestsearch")){
		librarySystem.search(guestsearch, category);
	}else if(btn != null && btn.equals("borrowbook")){
		librarySystem.clear();
		librarySystem.setBooksToBorrow(bookstoborrow);
		request.getRequestDispatcher("/borrowBook.jsp").forward(request, response);
	}else if(btn != null && btn.equals("viewallbooksguest")){
		librarySystem.viewAllBooks();
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"main\">\r\n");
      out.write("\t<div id=\"header\">\r\n");
      out.write("\t\t<img src=\"img/logo.png\" alt=\"\" />\r\n");
      out.write("\t\t<h1>Library</h1>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"GuestLoggedIn\">\r\n");
      out.write("\t\t<h1>Welcome Guest! </h1> <br />\r\n");
      out.write("\t\t<form action=\"Controller\" method=\"get\" id=\"guest1\">\r\n");
      out.write("\t\t<input type=\"text\" class=\"guestSearch\" name=\"guestSearch\" placeholder=\"Search Book\" REQUIRED/>\r\n");
      out.write("\t\t<select name=\"category\" id=\"category\">\r\n");
      out.write("\t\t\t<option value=\"control_number\">Control Number</option>\r\n");
      out.write("\t\t\t<option value=\"book_title\" SELECTED>Book Title</option>\r\n");
      out.write("\t\t\t<option value=\"author\">Author</option>\r\n");
      out.write("\t\t\t<option value=\"year_published\">Year Published</option>\r\n");
      out.write("\t\t</select>\r\n");
      out.write("\t\t<button type=\"submit\" name=\"btn\" value=\"guestsearch\" class=\"guestsearch\"></button>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<form action=\"Controller\">\r\n");
      out.write("\t\t\t<table border=\"1\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th><input type=\"checkbox\" id=\"checkall\" /></th>\r\n");
      out.write("\t\t\t\t\t<th>Control No.</th>\r\n");
      out.write("\t\t\t\t\t<th>Book Title</th>\r\n");
      out.write("\t\t\t\t\t<th>Author</th>\r\n");
      out.write("\t\t\t\t\t<th>Year Published</th>\r\n");
      out.write("\t\t\t\t\t<th>Availability</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");

					for(int i = 0; i<librarySystem.getControlNumber().size(); i++){
						String ifAvailable = librarySystem.getAvailability().size()==0 ? "" : librarySystem.getAvailability().get(i);
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"checkbox\" name=\"checkedborrow\" value=\"");
      out.print(librarySystem.getControlNumber().get(i));
      out.write('"');
      out.write(' ');
      out.print(ifAvailable.equals("Available") ? "" : "DISABLED" );
      out.write("/></td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(librarySystem.getControlNumber().get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(librarySystem.getBook_title().get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(librarySystem.getAuthor().get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(librarySystem.getYear_published().get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(ifAvailable );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

					} librarySystem.setMessage(""); librarySystem.clear();
				
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\t\t\t<button type=\"submit\" name=\"btn\" value=\"borrowbook\" class=\"borrowbook\"></button>\r\n");
      out.write("\t</center>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\t\t<form action=\"Controller\" method=\"get\" id=\"guest1\">\r\n");
      out.write("\t\t<button type=\"submit\" name=\"btn\" value=\"viewallbooksguest\" class=\"viewallbooks\" ></button>\r\n");
      out.write("\t\t\t<button type=\"submit\" name=\"btn\" value=\"returnbook\" class=\"returnbook\"></button><br /> <br />\r\n");
      out.write("\t\t\t<span><a href=\"index.jsp\" class=\"backtomainpage\">Back to Main Page</a></span>\r\n");
      out.write("\t\t\t</center>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"footer\">\r\n");
      out.write("\t\t");
      out.print(librarySystem.getMessage() );
      out.write("\r\n");
      out.write("\t\t");
librarySystem.setMessage(""); 
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\twindow.onload = function(){\r\n");
      out.write("\t\t\tcheckAll();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\tfunction checkAll(){\r\n");
      out.write("\t\t\tvar classes = document.getElementsByName(\"checkedborrow\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tdocument.getElementById(\"checkall\").onclick = function(){\t\t\t\t\r\n");
      out.write("\t\t\t\tif(document.getElementById(\"checkall\").checked){\r\n");
      out.write("\t\t\t\t\tfor(var i = 0; i< classes.length; i++){\r\n");
      out.write("\t\t\t\t\t\tclasses[i].checked  = true;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t} else{\t\t\t\r\n");
      out.write("\t\t\t\t\tfor(var i = 0; i< classes.length; i++){\r\n");
      out.write("\t\t\t\t\t\tclasses[i].checked  = false;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
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
