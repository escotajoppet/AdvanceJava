/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.41
 * Generated at: 2014-03-24 09:25:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class official_005freceipt_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      flight.reservation.FlightReservation flightReservation = null;
      synchronized (session) {
        flightReservation = (flight.reservation.FlightReservation) _jspx_page_context.getAttribute("flightReservation", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (flightReservation == null){
          flightReservation = new flight.reservation.FlightReservation();
          _jspx_page_context.setAttribute("flightReservation", flightReservation, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<center>\r\n");
      out.write("\t\t<h1>Z-Airlines</h1>\r\n");
      out.write("\t\t<h3>Thank you for choosing to fly with us!</h3>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tGuest Details: ");
      out.print(flightReservation.getUser() );
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<br /><br />\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tFlight Details: <br />\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
      out.print(flightReservation.getFrom() );
      out.write(" to ");
      out.print(flightReservation.getTo() );
      out.write(" <br />\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tDeparture:\r\n");
      out.write("\t\t");
      out.print(flightReservation.getDepartureDateTime() );
      out.write(" <br />\r\n");
      out.write("\t\tArrival:\r\n");
      out.write("\t\t");
      out.print(flightReservation.getArrivalDateTime() );
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<br /><br />\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tRETURN <br />\r\n");
      out.write("\t\t");
      out.print(flightReservation.getTo() );
      out.write(" to ");
      out.print(flightReservation.getFrom() );
      out.write(" <br />\r\n");
      out.write("\t\tDeparture:\r\n");
      out.write("\t\t");
      out.print(flightReservation.getDepartureDateTime() );
      out.write(" <br />\r\n");
      out.write("\t\tArrival:\r\n");
      out.write("\t\t");
      out.print(flightReservation.getArrivalDateTime() );
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<br /><hr /><br />\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tFLIGHT DETAILS\r\n");
      out.write("\t\t<br /><br />\r\n");
      out.write("\t\tBASE FARE: <br />\r\n");
      out.write("\t\t# of Persons: ");
      out.print(flightReservation.getNumberOfPersons() );
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<hr />\r\n");
      out.write("\t\tSUBTOTAL: \r\n");
      out.write("\t\t<hr />\r\n");
      out.write("\t\tADD ONS: <br />\r\n");
      out.write("\t\t\tTravel Insurance: 325.00 <br />\r\n");
      out.write("\t\t\tBaggage Allowance: 360.00 <br />\r\n");
      out.write("\t\t\tSeat Reservation: 260.00 <br />\r\n");
      out.write("\t\t<hr />\r\n");
      out.write("\t\tSUBTOTAL: 945.00\r\n");
      out.write("\t\t<hr />\r\n");
      out.write("\t\tTAXES AND FEES: 1422.56\r\n");
      out.write("\t\t<hr />\r\n");
      out.write("\t\tTOTAL: ");
      out.print(flightReservation.getTotalAmount() );
      out.write("\r\n");
      out.write("\t\t<hr />\r\n");
      out.write("\t\tPayment Status <br /><br />\r\n");
      out.write("\t\tPayment Type: Credit Card <br />\r\n");
      out.write("\t\tStatus: CONFIRMED <br />\r\n");
      out.write("\t\tDate: ");
      out.print(flightReservation.getBookingDate() );
      out.write(" <br />\r\n");
      out.write("\t\tAmount: ");
      out.print(flightReservation.getTotalAmount() );
      out.write(" <br /><br />\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<form action=\"PageController\">\r\n");
      out.write("\t\t\t<button type=\"submit\" name=\"btn\" value=\"backtoflightreservation\">Back</button>\r\n");
      out.write("\t\t\t<button type=\"submit\" name=\"btn\" value=\"logout\">Log Out</button>\r\n");
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
