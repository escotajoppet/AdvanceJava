/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.41
 * Generated at: 2014-04-02 16:07:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class location_005finformation_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      hotel.reservation.HotelReservation hotelReservation = null;
      synchronized (session) {
        hotelReservation = (hotel.reservation.HotelReservation) _jspx_page_context.getAttribute("hotelReservation", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (hotelReservation == null){
          hotelReservation = new hotel.reservation.HotelReservation();
          _jspx_page_context.setAttribute("hotelReservation", hotelReservation, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");

	hotelReservation.clearViewLocation();
	hotelReservation.setHotelLocation();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<center>\r\n");
      out.write("\t\t<form action=\"Controller\">\r\n");
      out.write("\t\t\t<h1>Hotel Accommodation System</h1>\r\n");
      out.write("\t\t\t<button type=\"submit\" name=\"btn\" value=\"accommodation\">Accommodation</button>\r\n");
      out.write("\t\t\t<button type=\"submit\" name=\"btn\" value=\"sightsandactivities\">Sights and Activities</button>\r\n");
      out.write("\t\t\t<button type=\"submit\" name=\"btn\" value=\"planyourvisit\">Plan Your Visit</button>\r\n");
      out.write("\t\t\t<button type=\"submit\" name=\"btn\" value=\"contactus\">Contact Us</button>\r\n");
      out.write("\t\t\t");

				if(hotelReservation.getLoggedIn().equals("")){
			
      out.write("\r\n");
      out.write("\t\t\t\t<button type=\"submit\" name=\"btn\" value=\"adminback\">Back</button>\r\n");
      out.write("\t\t\t");

				} else{
			
      out.write("\r\n");
      out.write("\t\t\t\t<button type=\"submit\" name=\"btn\" value=\"addnewhotel\">Add New Hotel</button>\r\n");
      out.write("\t\t\t\t<button type=\"submit\" name=\"btn\" value=\"logout\">Log Out</button>\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<h2>Hotel Location And Contact Information</h2>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<strong>Hotel Name:</strong> ");
      out.print(hotelReservation.getViewHotelName() );
      out.write(" <br /><br />\r\n");
      out.write("\t\t<strong>Hotel Location:</strong> ");
      out.print(hotelReservation.getViewHotelLocation() );
      out.write("<br /><br />\r\n");
      out.write("\t\t<strong>Hotel Address:</strong> ");
      out.print(hotelReservation.getViewHotelAddress() );
      out.write("<br /><br />\r\n");
      out.write("\t\t<strong>Hotel Contact:</strong> ");
      out.print(hotelReservation.getViewHotelContact() );
      out.write("<br /><br />\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<br /><br />\r\n");
      out.write("\t\t<form action=\"Controller\"><button name=\"btn\" value=\"customerback\">Back</button></form>\r\n");
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
