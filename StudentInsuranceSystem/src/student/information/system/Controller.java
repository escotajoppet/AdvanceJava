package student.information.system;

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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String button = request.getParameter("button");
		String pageLocation = "";
		
		//login.jsp
		if(button.equals("login")){
			pageLocation = "/login.jsp";
		} else if(button.equals("signup")){
			pageLocation = "/signup.jsp";
		}
		
		//signup.jsp
		else if(button.equals("confirmsignup")){
			pageLocation = "/signup.jsp";
		} else if(button.equals("backtologin")){
			pageLocation = "/login.jsp";
		}
		
		//mainpage.jsp
		else if(button.equals("indexCreate")){
			pageLocation = "/new.jsp";
		} else if(button.equals("indexEdit")){
			pageLocation = "/update.jsp";
		} else if(button.equals("indexDelete")){
			pageLocation  = "/delete.jsp";
		} else if(button.equals("indexView")){
			pageLocation = "/search.jsp";
		} else if(button.equals("indexAll")){
			pageLocation = "/viewall.jsp";
		} else if(button.equals("indexPayment")){
			pageLocation = "/payment.jsp";
		} else if(button.equals("indexTransaction")){
			pageLocation = "/transaction.jsp";
		} else if(button.equals("logout")){
			pageLocation = "/login.jsp";
		}
		
		//new.jsp
		else if(button.equals("createSubmit")){
			pageLocation = "/new.jsp";
		} else if(button.equals("createBack")){
			pageLocation = "/mainpage.jsp";
		}
		
		//delete.jsp
		else if(button.equals("deleteDelete")){
			pageLocation = "/delete.jsp";
		} else if(button.equals("deleteBack")){
			pageLocation = "/mainpage.jsp";
		}
		
		//viewall.jsp
		else if(button.equals("viewAllBack")){
			pageLocation = "/mainpage.jsp";
		}
		
		//search.jsp
		else if(button.equals("searchNext")){
			pageLocation = "/search.jsp";
		} else if(button.equals("searchBack")){
			pageLocation = "/mainpage.jsp";
		}
		
		//update.jsp
		else if(button.equals("setaccountnumber")){
			pageLocation = "/update.jsp";
		} else if(button.equals("updateSubmit")){
			pageLocation = "/update.jsp";
		} else if(button.equals("updateBack")){
			pageLocation = "/mainpage.jsp";
		}
		
		//transaction.jsp
		else if(button.equals("transactionBack")){
			pageLocation = "/mainpage.jsp";
		}
		
		request.getRequestDispatcher(pageLocation).forward(request, response);
	}

}
