package classes.record;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn = request.getParameter("btn");
		String pageDispatch = "";
		
		//login_page.jsp
		if(btn.equals("facultylogin")){
			pageDispatch = "/login_page.jsp";
		} else if(btn.equals("facultyregister")){
			pageDispatch = "/faculty_registration_page.jsp";
		}
		
		//class_list_page.jsp
		else if(btn.startsWith("vcs ")){
			pageDispatch = "/class_list_page.jsp";
		} else if(btn.startsWith("del ")){
			pageDispatch = "/class_list_page.jsp";
		} else if(btn.equals("addnewclass")){
			pageDispatch = "/add_class_page.jsp";
		} else if(btn.equals("classlogout")){
			pageDispatch = "/class_list_page.jsp";
		}	
		
		//student_list_page.jsp
		else if(btn.startsWith("grd ")){
			pageDispatch = "/student_list_page.jsp";
		} else if(btn.startsWith("dls ")){
			pageDispatch = "/student_list_page.jsp";
		} else if(btn.equals("addnewstudent")){
			pageDispatch = "/add_student_page.jsp";
		} else if(btn.equals("backtoclasslist")){
			pageDispatch = "/class_list_page.jsp";
		} else if(btn.equals("studentlogout")){
			pageDispatch = "/student_list_page.jsp";
		}
		
		//grade_sheet_page.jsp
		else if(btn.equals("backtostudentlist")){
			pageDispatch = "/student_list_page.jsp";
		} else if(btn.equals("gradelogout")){
			pageDispatch = "/grade_sheet_page.jsp";
		} else if(btn.equals("Update Grade(s)")){
			pageDispatch = "/grade_sheet_page.jsp";
		} else if(btn.equals("Confirm Update")){
			pageDispatch = "/grade_sheet_page.jsp";
		}
		
		//faculty_registration.jsp
		else if(btn.equals("register")){
			pageDispatch = "/faculty_registration_page.jsp";
		} else if(btn.equals("backtologin")){
			pageDispatch = "/login_page.jsp";
		}
		
		//add_class_page.jsp
		else if(btn.equals("addclass")){
			pageDispatch = "/add_class_page.jsp";			
		} else if(btn.equals("backtoclass")){
			pageDispatch = "/class_list_page.jsp";
		}
		
		//add_student_page.jsp
		else if(btn.equals("addstudent")){
			pageDispatch = "/add_student_page.jsp";
		}
		
		request.getRequestDispatcher(pageDispatch).forward(request, response);
	}
}
