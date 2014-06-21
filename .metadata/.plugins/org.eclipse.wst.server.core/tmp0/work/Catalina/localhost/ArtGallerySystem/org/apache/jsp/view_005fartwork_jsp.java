/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.41
 * Generated at: 2014-04-04 07:29:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class view_005fartwork_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      art.gallery.ArtGallery artgallery = null;
      synchronized (session) {
        artgallery = (art.gallery.ArtGallery) _jspx_page_context.getAttribute("artgallery", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (artgallery == null){
          artgallery = new art.gallery.ArtGallery();
          _jspx_page_context.setAttribute("artgallery", artgallery, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");

	String btn = request.getParameter("btn");
	String searchBy = request.getParameter("searchby");
	String searchKeyword = request.getParameter("searchartwork");
	String viewerComment = request.getParameter("viewercomment");
	
	if(searchBy==null || searchBy.equals("")){
		artgallery.searchArtwork("", "");
	} else if(btn!=null && btn.equals("searchart")){
		artgallery.searchArtwork(searchKeyword, searchBy);
	} 
	
	if(btn!=null && btn.startsWith("com")){
		artgallery.postComment(btn, viewerComment);
	}

	

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<center>\r\n");
      out.write("\t\t<h1>Art Gallery System</h1>\r\n");
      out.write("\t\t<form action=\"Controller\">\r\n");
      out.write("\t\t\t<input type=\"text\" size=\"50\" name=\"searchartwork\" placeholder=\"Enter Keyword Here\"/>\r\n");
      out.write("\t\t\t<select name=\"searchby\" id=\"\">\r\n");
      out.write("\t\t\t\t<option value=\"arttitle\">Art Title</option>\r\n");
      out.write("\t\t\t\t<option value=\"author\">Author</option>\r\n");
      out.write("\t\t\t</select> \r\n");
      out.write("\t\t\t<button type=\"submit\" name=\"btn\" value=\"searchart\">Search</button>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");

				for(int i = 0; i<artgallery.getArtEntryNumber().size(); i++){
			
      out.write("\r\n");
      out.write("\t\t\t\t<table border=\"2\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th colspan=\"5\">");
      out.print(artgallery.getArtEntryTitle().get(i) );
      out.write("</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>Art Id</th>\r\n");
      out.write("\t\t\t\t\t\t<th>Author</th>\r\n");
      out.write("\t\t\t\t\t\t<th>Category</th>\r\n");
      out.write("\t\t\t\t\t\t<th>Entry Date</th>\r\n");
      out.write("\t\t\t\t\t\t<th>Gallery Location</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(artgallery.getArtEntryNumber().get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(artgallery.getArtAuthor().get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(artgallery.getArtCategory().get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(artgallery.getArtEntryDate().get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(artgallery.getArtLocation().get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"5\"><form action=\"Controller\"><input type=\"text\" name=\"viewercomment\" size=\"70%\"/><button type=\"submit\" name=\"btn\" value=\"com/");
      out.print(artgallery.getArtEntryNumber().get(i) );
      out.write('/');
      out.print(artgallery.getArtEntryTitle().get(i) );
      out.write('/');
      out.print(artgallery.getArtAuthor().get(i) );
      out.write("\">Submit Comment</button></form></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t<br />\r\n");
      out.write("\t\t\t");

				} artgallery.clearArtInfo();
			
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<form action=\"Controller\"><button type=\"submit\" name=\"btn\" value=\"backtomainpage\">Back to Main Page</button></form>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<br /><br />\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
      out.print(artgallery.getMessage() );
      out.write("\r\n");
      out.write("\t\t");
artgallery.setMessage(""); 
      out.write("\r\n");
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