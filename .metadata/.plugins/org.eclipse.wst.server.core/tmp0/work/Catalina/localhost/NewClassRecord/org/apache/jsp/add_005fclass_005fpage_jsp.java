/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.41
 * Generated at: 2014-03-30 14:06:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_005fclass_005fpage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Class Record Project: Add Class</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      classes.record.ClassRecordManager classRecord = null;
      synchronized (session) {
        classRecord = (classes.record.ClassRecordManager) _jspx_page_context.getAttribute("classRecord", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (classRecord == null){
          classRecord = new classes.record.ClassRecordManager();
          _jspx_page_context.setAttribute("classRecord", classRecord, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");

	if(session.getAttribute("id")==null || classRecord.getLoggedId().equals("")){
		session.invalidate();
		request.getRequestDispatcher("/login_page.jsp").forward(request, response);
	}
	
	String message = "";
	String btn = request.getParameter("btn");

	String classYear = request.getParameter("classyear");
	String classSection = request.getParameter("classsection");
	String classSYFrom = request.getParameter("sy1");
	String classSYTo = request.getParameter("sy2");
	String classSemester = request.getParameter("sem");
	String subjectCode = request.getParameter("subjectcode");
	String subjectName = request.getParameter("subjectname");
	
	String[] days = request.getParameterValues("days");
	String[] fromTime0 = request.getParameterValues("fromtime0");
	String[] fromTime1 = request.getParameterValues("fromtime1");
	String[] from = request.getParameterValues("from");
	String[] toTime0 = request.getParameterValues("totime0");
	String[] toTime1 = request.getParameterValues("totime1");
	String[] to = request.getParameterValues("to");

	if(btn!=null && btn.equals("addclass")){
		String[] fieldValues = {classYear + "-" + classSection, classSYFrom + "-" + classSYTo, classSemester, subjectCode, subjectName};
		
		classRecord.setScheduleOfNewClass(days, fromTime0, fromTime1, from, toTime0, toTime1, to);		
		classRecord.add("class", fieldValues);
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<center>\r\n");
      out.write("\t\t<h1>Class Record</h1>\r\n");
      out.write("\t\t<h3>Add New Class</h3>\r\n");
      out.write("\t\t<form action=\"ClassController\" method=\"post\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<select name=\"classyear\" id=\"\" class=\"btn btn-default\">\r\n");
      out.write("\t\t\t\t<option value=\"\">Class Year...</option>\r\n");
      out.write("\t\t\t\t");

					for(int i = 1; i<6; i++){
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<option value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</option>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<span> - </span>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<select name=\"classsection\" id=\"\" class=\"btn btn-default\">\r\n");
      out.write("\t\t\t\t<option value=\"\">Section...</option>\r\n");
      out.write("\t\t\t\t");

					for(int i = 1; i<6; i++){
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<option value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</option>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<br /><br />\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tSchool Year: \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<select name=\"sy1\" id=\"\">\r\n");
      out.write("\t\t\t\t");

					for(int i = 2012; i<2021; i++){
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<option value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</option>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<span> - </span>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<select name=\"sy2\" id=\"\">\r\n");
      out.write("\t\t\t\t");

					for(int i = 2012; i<2021; i++){
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<option value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</option>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<br /><br />\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tSemester: \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<select name=\"sem\" id=\"\">\r\n");
      out.write("\t\t\t\t<option value=\"1st\">1st</option>\r\n");
      out.write("\t\t\t\t<option value=\"2nd\">2nd</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<br /><br />\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tSubject Code: <input type=\"text\" name=\"subjectcode\"/><br /><br />\r\n");
      out.write("\t\t\tSubject Name: <input type=\"text\" name=\"subjectname\"/>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div id=\"schedule\">\r\n");
      out.write("\t\t\t\t<h3>Schedule for the Class</h3>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"form-inline schedules\" id=\"original\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<select name=\"days\" id=\"\" class=\"btn btn-default\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"Monday\">Monday</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"Tuesday\">Tuesday</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"Wednesday\">Wednesday</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"Thursday\">Thursday</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"Friday\">Friday</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"Saturday\">Saturday</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<br /><br />\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<span id=\"from\">From:</span> <select name=\"fromtime0\" id=\"\" class=\"btn btn-default\" id=\"from\">\r\n");
      out.write("\t\t\t\t\t\t\t");

								for(int i = 1; i<13; i++){
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"");
      out.print(i<10 ? "0"+i : i );
      out.write('"');
      out.write('>');
      out.print(i<10 ? "0"+i : i );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t");

								}
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<span> : </span>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<select name=\"fromtime1\" id=\"\" class=\"btn btn-default\">\r\n");
      out.write("\t\t\t\t\t\t\t");

								for(int i = 0; i<61; i++){
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"");
      out.print(i<10 ? "0"+i : i );
      out.write('"');
      out.write('>');
      out.print(i<10 ? "0"+i : i );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t");

								}
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<select name=\"from\" id=\"\" class=\"btn btn-default\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"AM\">AM</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"AM\">PM</option>\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<span id=\"to\">To:</span> <select name=\"totime0\" id=\"\" class=\"btn btn-default\">\r\n");
      out.write("\t\t\t\t\t\t\t");

								for(int i = 1; i<13; i++){
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"");
      out.print(i<10 ? "0"+i : i );
      out.write('"');
      out.write('>');
      out.print(i<10 ? "0"+i : i );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t");

								}
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<span> : </span>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<select name=\"totime1\" id=\"\" class=\"btn btn-default\">\r\n");
      out.write("\t\t\t\t\t\t\t");

								for(int i = 0; i<61; i++){
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"");
      out.print(i<10 ? "0"+i : i );
      out.write('"');
      out.write('>');
      out.print(i<10 ? "0"+i : i );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t");

								}
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<select name=\"to\" id=\"\" class=\"btn btn-default\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"AM\">AM</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"AM\">PM</option>\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<br /><br />\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"Add Time\"  id=\"addschedule\"/>\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"Remove Time\"  id=\"removeschedule\"/>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<hr />\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<button type=\"submit\" name=\"btn\" value=\"addclass\" >Add Class</button>\r\n");
      out.write("\t\t\t<button type=\"submit\" name=\"btn\" value=\"backtoclass\" >Back to Class List</button>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
      out.print(classRecord.getMessage() );
      out.write("\r\n");
      out.write("\t\t");
classRecord.setMessage(""); 
      out.write("\r\n");
      out.write("\t</center>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tvar divCount = 1; \r\n");
      out.write("\t\tvar scheduleDiv = document.getElementById(\"schedule\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"addschedule\").onclick = function(){\r\n");
      out.write("\t\t\tvar original = document.getElementById(\"original\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar clone = original.cloneNode(true);\r\n");
      out.write("\t\t\tclone.id = \"duplicate\" + divCount;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar hr = document.createElement(\"hr\");\r\n");
      out.write("\t\t\thr.id = \"hr\" + divCount;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tscheduleDiv.appendChild(hr);\r\n");
      out.write("\t\t\tscheduleDiv.appendChild(clone);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tdivCount++;\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"removeschedule\").onclick = function(){\r\n");
      out.write("\t\t\tdocument.getElementById(\"duplicate\" + (divCount - 1)).remove();\r\n");
      out.write("\t\t\tdocument.getElementById(\"hr\" + (divCount - 1)).remove();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tdivCount--;\r\n");
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
