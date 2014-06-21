package loan.system;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
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
		String btn = request.getParameter("btn");
		String pageLocation = "";
		
		if(btn.equals("signin")){
			pageLocation = "/loginpage.jsp";
		} else if(btn.equals("signup")){
			pageLocation = "/membership_form.jsp";
		} else if(btn.equals("setcustomer")){
			pageLocation = "/set_customer.jsp";
		}
		
		else if(btn.equals("registeruser")){
			pageLocation = "/membership_form.jsp";
		} else if(btn.equals("backtologin")){
			pageLocation = "/set_customer.jsp";
		}
		
		else if(btn.equals("loan")){
			pageLocation = "/loan.jsp";
		} else if(btn.equals("payment")){
			pageLocation = "/payment.jsp";			
		} else if(btn.equals("balance")){
			pageLocation = "/balance.jsp";			
		}
		
		else if(btn.equals("getloan")){
			pageLocation = "/loan.jsp";
		}
		
		else if(btn.equals("pay")){
			pageLocation = "/payment.jsp";
		}
		
		else if(btn.equals("logout")){
			pageLocation = "/loginpage.jsp";
		}
		
		else if(btn.equals("setanothercustomer")){
			pageLocation = "/set_customer.jsp";
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
