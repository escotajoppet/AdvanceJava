/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.41
 * Generated at: 2014-04-02 07:54:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class update_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<title>Student Insurance System</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/all.css\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/reset.css\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/name.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      student.information.system.StudentInfomationSystem sis = null;
      synchronized (session) {
        sis = (student.information.system.StudentInfomationSystem) _jspx_page_context.getAttribute("sis", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (sis == null){
          sis = new student.information.system.StudentInfomationSystem();
          _jspx_page_context.setAttribute("sis", sis, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");

	boolean info = false;

	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String address = request.getParameter("address");
	String contact = request.getParameter("contactNum");
	
	String insuranceType = request.getParameter("insuranceType");
	
	String accountNumber = request.getParameter("code");
	
	if(request.getParameter("button")!=null && request.getParameter("button").equals("setaccountnumber")){
		sis.setTableName(insuranceType);
		sis.setUpdateAccountNumber(accountNumber);
		info = true;		
	} else if(request.getParameter("button")!=null && request.getParameter("button").equals("updateSubmit")){
		sis.setTransactionAccountNumber(Integer.parseInt(sis.getUpdateAccountNumber()));
		sis.setTransactionCommited("Update Account");
		sis.updateAccountInfo(firstName, lastName, address, contact, insuranceType);
	}

      out.write("\r\n");
      out.write("<body style =background-image:url(img/bg.png);>\r\n");
      out.write("\t<div id=\"main\">\r\n");
      out.write("\t\t<div id=\"form1\">\r\n");
      out.write("\t\t\t<div id=\"title\"><p>STUDENT INSURANCE SYSTEM</p></div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tWELCOME, <strong>");
      out.print(sis.getAdminUsername().toUpperCase() );
      out.write("</strong><br>\r\n");
      out.write("\t\t\t<div id=\"title\"><p>CHANGE MEMBER DETAILS</p></div>\t\r\n");
      out.write("\t\t\t\t<br />\r\n");
      out.write("\t\t\t<form action=\"hrcontroller\" method=\"Post\">\r\n");
      out.write("\t\t\t\t<label for=\"\" class=\"label\">Insurance Type: </label>\r\n");
      out.write("\t\t\t\t<select name=\"insuranceType\" class = \"name4\">\r\n");
      out.write("\t\t\t\t\t<option value=\"carinsurance\">Car Insurance</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"healthinsurance\">Health Insurance</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"lifeinsurance\">Life Insurance</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"travelinsurance\">Travel Insurance</option>\r\n");
      out.write("\t\t\t\t</select>\t\r\n");
      out.write("\t\t\t\t <br><br>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<label for=\"\" class = \"label\">Account Number: </label><input type=\"text\" name=\"code\" class=\"name1\" required />\r\n");
      out.write("\t\t\t\t<button type=\"submit\" name=\"button\"  value=\"setaccountnumber\">Set Account</button>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");

				if(info){
					String insurance =  sis.getUpdateInsuranceType();
			
      out.write("\r\n");
      out.write("\t\t\t\t<h2>Customer Information</h2>\r\n");
      out.write("\t\t\t\t<form action=\"hrcontroller\" method = \"Post\">\t\r\n");
      out.write("\t\t\t\t\t<label for=\"\" class = \"label\">First Name: </label><input type=\"text\" name=\"firstName\" class=\"name1\" value=\"");
      out.print(sis.getUpdateFirstName() );
      out.write("\" required /> <br><br>\t\r\n");
      out.write("\t\t\t\t\t<label for=\"\" class = \"label\">Last Name: </label><input type=\"text\" name=\"lastName\" class=\"name1\" value=\"");
      out.print(sis.getUpdateLastName() );
      out.write("\" required /> <br><br>\r\n");
      out.write("\t\t\t\t\t<label for=\"\" class = \"label\">Address: </label><input type=\"text\" name=\"address\" class=\"name1\" value=\"");
      out.print(sis.getUpdateAddress() );
      out.write("\" size=\"");
      out.print(sis.getUpdateAddress().length() );
      out.write("\"required /> <br><br>\r\n");
      out.write("\t\t\t\t\t<label for=\"\" class = \"label\">Contact No.: </label><input type=\"text\" name=\"contactNum\" class=\"name1\" value=\"");
      out.print(sis.getUpdateContact() );
      out.write("\" required /> <br><br>\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<br /><br />\r\n");
      out.write("\t\t\t\t\t<button name=\"button\" value = \"updateSubmit\">Update</button>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t");

				} info = false;
			
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
      out.print(sis.getMessage() );
      out.write("\r\n");
      out.write("\t\t\t");
sis.setMessage(""); 
      out.write("\r\n");
      out.write("\t\t\t");

				sis.setUpdateAddress("");
				sis.setUpdateContact("");
				sis.setUpdateFirstName("");
				sis.setUpdateLastName("");
			
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<form action=\"hrcontroller\" method = \"Post\">\r\n");
      out.write("\t\t\t\t<button name=\"button\" value = \"updateBack\">Back</button>\r\n");
      out.write("\t\t\t\t<button name=\"button\" value = \"logout\">Log Out</button>\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\t");
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
