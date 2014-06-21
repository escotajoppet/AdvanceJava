package thesis.management;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
public class MainPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String btn = request.getParameter("btn");
		String pageLocation = "";
		
		//add.jsp
		if(btn.equals("addnewtitle")){
			pageLocation = "/add.jsp";
		} 
		
		//admin.jsp
		else if(btn.equals("logoutadmin")){
			pageLocation = "/asadmin.jsp";
		} else if(btn.equals("update")){
			pageLocation = "/admin.jsp";
		} else if(btn.equals("delete")){
			pageLocation = "/admin.jsp";
		} else if(btn.equals("passed")){
			pageLocation = "/admin.jsp";
		} else if(btn.equals("redefense")){
			pageLocation = "/admin.jsp";
		} else if(btn.equals("pending")){
			pageLocation = "/admin.jsp";
		} else if(btn.equals("passed with modification")){
			pageLocation = "/admin.jsp";
		} else if(btn.equals("all")){
			pageLocation = "/admin.jsp";
		} else if(btn.equals("confirmupdate")){
			pageLocation = "/admin.jsp";
		}
		
		//asadmin.jsp
		else if(btn.equals("adminsignin")){
			pageLocation = "/asadmin.jsp";
		}
		
		//asguest.jsp
		else if(btn.equals("add")){
			pageLocation = "/add.jsp";
		} else if(btn.equals("guestcheck")){
			pageLocation = "/check.jsp";
		}
		
		//aspanelist.jsp
		else if(btn.equals("panelistsignin")){
			pageLocation = "/aspanelist.jsp";
		}
		
		//check.jsp
		if(btn.equals("gpassed")){
			pageLocation = "/check.jsp";
		} else if(btn.equals("gredefense")){
			pageLocation = "/check.jsp";
		} else if(btn.equals("gpending")){
			pageLocation = "/check.jsp";
		} else if(btn.equals("gpassed with modification")){
			pageLocation = "/check.jsp";
		} else if(btn.equals("gall")){
			pageLocation = "/check.jsp";
		} 
		
		//mainmenu.jsp
		else if(btn.equals("asadmin")){
			pageLocation = "/asadmin.jsp";
		} else if(btn.equals("aspanelist")){
			pageLocation = "/aspanelist.jsp";
		} else if(btn.equals("asguest")){
			pageLocation = "/asguest.jsp";
		}
		
		//panelist.jsp
		else if(btn.equals("set")){
			pageLocation = "/panelist.jsp";
		} else if(btn.equals("submitverdict")){
			pageLocation = "/panelist.jsp";
		} else if(btn.equals("panelistlogout")){
			pageLocation = "/aspanelist.jsp";
		}
		
		////////
		else if(btn.equals("backtomainpage")){
			pageLocation = "/mainmenu.html";
		} else if(btn.equals("backtoguest")){
			pageLocation = "/asguest.jsp";
		}	

		request.getRequestDispatcher(pageLocation).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
