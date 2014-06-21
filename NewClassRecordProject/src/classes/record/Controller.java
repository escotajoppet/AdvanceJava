package classes.record;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageLocation = "";
		String btn = request.getParameter("btn");
		
		//class_list.jsp
		if(btn.equals("addnewclass")){
			pageLocation = "/AddClass";
		} else if(btn.equals("deleteclass")){
			pageLocation = "/ClassList";
		} else if(btn.startsWith("std ")){
			pageLocation = "/ClassList";
		}
		
		//add_class.jsp
		else if(btn.equals("addclass")){
			pageLocation = "/AddClass";
		} 
		
		//student_list.jsp
		else if(btn.equals("addnewstudent")){
			pageLocation = "/AddNewStudent";
		} else if(btn.equals("deletestudent")){
			pageLocation = "/StudentList";
		} else if(btn.startsWith("grd ")){
			pageLocation = "/StudentList";
		}
		
		//add_student.jsp
		else if(btn.equals("addstudent")){
			pageLocation = "/AddNewStudent";
		}
		
		//grade_sheet.jsp
		else if(btn.equals("setforms")){
			pageLocation = "/GradeSheet";
		} else if(btn.equals("updategradesheet")){
			pageLocation = "/GradeSheet";
		}
		
		////////////////
		else if(btn.equals("backtoclasslist")){
			pageLocation = "/ClassList";
		} else if(btn.equals("backtostudentlist")){
			pageLocation = "/StudentList";
		}
		
		request.getRequestDispatcher(pageLocation).forward(request, response);
	}
}
