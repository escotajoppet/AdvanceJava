/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.41
 * Generated at: 2014-03-24 09:29:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_005ftransactions_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	String[] status = request.getParameterValues("status");

	if(request.getParameter("btn")!=null && request.getParameter("btn").startsWith("del")){
		System.out.println("delete");
		flightReservation.deleteTransaction(request.getParameter("btn").substring(4));
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").equals("updatetransaction")){
		System.out.println("update");
		flightReservation.updateTransaction(status);
	}

	flightReservation.clearTransactionInfo();
	flightReservation.setTransactionInformation();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<center>\r\n");
      out.write("\t\t<form action=\"PageController\">\r\n");
      out.write("\t\t\t<h1>Z-Airlines</h1>\r\n");
      out.write("\t\t\t<h3>Login Administrator</h3>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<table border=\"1\" cellpadding=\"5\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>FROM</th>\r\n");
      out.write("\t\t\t\t\t<th>TO</th>\r\n");
      out.write("\t\t\t\t\t<th>DEPARTURE</th>\r\n");
      out.write("\t\t\t\t\t<th>RETURN</th>\r\n");
      out.write("\t\t\t\t\t<th>STATUS</th>\r\n");
      out.write("\t\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");

					for(int i = 0; i<flightReservation.getTransactionEmailAddress().size(); i++){
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(flightReservation.getTransactionFromLocation().get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(flightReservation.getTransactionToLocation().get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(flightReservation.getTransactionDeparture().get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(flightReservation.getTransactionArrival().get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<select name=\"status\" id=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"Cancelled\" ");
      out.print(flightReservation.getTransactionStatus().get(i).equals("Confirmed") ? "SELECTED" : "" );
      out.write(">Confirmed</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"Cancelled\" ");
      out.print(flightReservation.getTransactionStatus().get(i).equals("Cancelled") ? "SELECTED" : "" );
      out.write(">Cancelled</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"Boarding\" ");
      out.print(flightReservation.getTransactionStatus().get(i).equals("Boarding") ? "SELECTED" : "" );
      out.write(">Boarding</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"On Board\" ");
      out.print(flightReservation.getTransactionStatus().get(i).equals("On Board") ? "SELECTED" : "" );
      out.write(">On Board</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"Arrived\" ");
      out.print(flightReservation.getTransactionStatus().get(i).equals("Arrived") ? "SELECTED" : "" );
      out.write(">Arrived</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"Departed\" ");
      out.print(flightReservation.getTransactionStatus().get(i).equals("Departed") ? "SELECTED" : "" );
      out.write(">Departed</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td><button type=\"submit\" name=\"btn\" value=\"del ");
      out.print(flightReservation.getTransactionTimeOfBooking().get(i) );
      out.write("\">DELETE TRANSACTION</button></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</table>\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<br /><br />\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<button type=\"submit\" name=\"btn\" value=\"adminback\">Back</button>\r\n");
      out.write("\t\t\t<button type=\"submit\" name=\"btn\" value=\"updatetransaction\">Update Transaction</button>\r\n");
      out.write("\t\t\t<button type=\"submit\" name=\"btn\" value=\"adminlogout\">Log Out</button>\r\n");
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
