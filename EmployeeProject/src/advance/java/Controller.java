package advance.java;

import employee.manager.EmployeeManager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String add = request.getParameter("add");
		String del = request.getParameter("delete");
		String update = request.getParameter("update");
		String info = request.getParameter("info");
		
		String pageLocation = "/error.html";
		
		if(add!=null){
			pageLocation = "/add_employee.jsp";
		} else if(del!=null){
			pageLocation = "/delete_employee.jsp";
		} else if(update!=null){
			pageLocation = "/update_employee.jsp";
		} else if(info!=null){
			pageLocation = "/employee_info.jsp";
		}
		
		RequestDispatcher reqdis = request.getRequestDispatcher(pageLocation);
		reqdis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
