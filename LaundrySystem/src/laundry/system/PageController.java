package laundry.system;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PageController
 */
public class PageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PageController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageLocation = "/laundry_main_page.html";
		String btn = request.getParameter("btn");
		
		//login_as_user.jsp
		if(btn.equals("asuser")){
			pageLocation = "/laundry_login_page_as_user.jsp";
		} else if(btn.equals("asadmin")){
			pageLocation = "/laundry_login_page_as_admin.jsp";			
		}
		
		//login_as_admin.jsp
		else if(btn.equals("userlogin")){
			pageLocation = "/laundry_login_page_as_user.jsp";			
		} else if(btn.equals("register")){
			pageLocation = "/laundry_register_user.jsp";			
		}
		
		//laundry_register_user.jsp
		else if(btn.equals("registeruser")){
			pageLocation = "/laundry_register_user.jsp";			
		}
		
		//laundry_information_page.jsp
		else if(btn.equals("confirmorder")){
			pageLocation = "/laundry_information_page.jsp";			
		} else if(btn.equals("userrecenttransactions")){
			pageLocation = "/laundry_information_page.jsp";			
		} else if(btn.equals("ibacktologinuser")){
			pageLocation = "/laundry_information_page.jsp";			
		}
		
		//laundry_transaction_summary.jsp
		else if(btn.equals("tbacktologinuser")){
			pageLocation = "/laundry_transaction_summary.jsp";			
		} else if(btn.equals("cancel")){
			pageLocation = "/laundry_transaction_summary.jsp";			
		} else if(btn.equals("confirminfo")){
			pageLocation = "/laundry_transaction_summary.jsp";			
		}
		
		//laundry_recent_transaction.jsp
		else if(btn.equals("backtoinformationpage")){
			pageLocation = "/laundry_information_page.jsp";
		} 
		
		//laundry_login_page_as_admin.jsp
		else if(btn.equals("adminlogin")){
			pageLocation = "/laundry_login_page_as_admin.jsp";
		}
		
		//laundry_information_page_as_admin.jsp
		else if(btn.equals("adminlogout")){
			pageLocation = "/laundry_information_page_as_admin.jsp";
		} else if(btn.startsWith("de ")){
			pageLocation = "/laundry_information_page_as_admin.jsp";
		} else if(btn.equals("Update Status") || btn.equals("Confirm Update")){
			pageLocation = "/laundry_information_page_as_admin.jsp";
		}
		
		/////
		else if(btn.equals("backtomain")){
			pageLocation = "/laundry_main_page.html";			
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
