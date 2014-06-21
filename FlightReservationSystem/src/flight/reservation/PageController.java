package flight.reservation;

import java.io.IOException;
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
     * @see HttpServlet#HttpServlet()
     */
    public PageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageLocation = "";
		String btn = request.getParameter("btn");
	
		//login_page.jsp
		if(btn.equals("register")){
			pageLocation = "/membership_form.jsp";
		} else if(btn.equals("login")){
			pageLocation = "/login_page.jsp";
		} else if(btn.equals("logasadmin")){
			pageLocation = "/admin_login_page.jsp";
		}
		
		//membership_form.jsp
		else if(btn.equals("registeruser")){
			pageLocation = "/membership_form.jsp";
		} else if(btn.equals("backtologin")){
			pageLocation = "/login_page.jsp";
		}
		
		//book_a_flight.jsp
		else if(btn.equals("logout")){
			pageLocation = "/login_page.jsp";
		} else if(btn.equals("booknow")){
			pageLocation = "/book_a_flight.jsp";
		}
		
		//official_receipt.jsp
		else if(btn.equals("backtoflightreservation")){
			pageLocation = "book_a_flight.jsp";
		}
		
		//admin_login_page.jsp
		else if(btn.equals("adminlogin")){
			pageLocation = "/admin_login_page.jsp";
		} else if(btn.equals("adminback")){
			pageLocation = "/login_page.jsp";
		}
		
		//admin_page.jsp
		else if(btn.equals("admintransactions")){
			pageLocation = "/admin_transactions.jsp";
		} else if(btn.equals("adminpromos")){
			pageLocation = "/admin_promos.jsp";			
		} else if(btn.equals("adminamounts")){
			pageLocation = "/admin_amounts.jsp";			
		} else if(btn.equals("adminlogout")){
			pageLocation = "/login_page.jsp";			
		}
		
		//admin_transactions.jsp
		else if(btn.startsWith("del ")){
			pageLocation = "/admin_transactions.jsp";
		} else if(btn.equals("updatetransaction")){
			pageLocation = "/admin_transactions.jsp";
		} else if(btn.equals("adminback")){
			pageLocation = "/admin_page.jsp";
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
