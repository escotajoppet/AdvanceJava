package pharmacy.system;

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
		String btn = request.getParameter("btn");
		String pageLocation = "";
		
		//search page
		if(btn.equals("sign_out_search")){
			pageLocation = "/pharmacy_search_info.jsp";
		} else if(btn.equals("searchinfo")){
			pageLocation = "/pharmacy_search_info.jsp";
		}
		
		//main page
		else if(btn.equals("pharmacysignin")){
			pageLocation = "/signIn.jsp";
		} else if(btn.equals("home")){
			pageLocation = "/pharmacy_main_page.jsp";			
		} else if(btn.equals("add_info")){
			pageLocation = "/pharmacy_add_info.jsp";			
		} else if(btn.equals("delete_info")){
			pageLocation = "/pharmacy_delete_info.jsp";			
		} else if(btn.equals("view")){
			pageLocation = "/pharmacy_view.jsp";			
		} else if(btn.equals("search")){
			pageLocation = "/pharmacy_search_info.jsp";			
		} else if(btn.equals("order")){
			pageLocation = "/order.jsp";			
		} else if(btn.equals("sign_out_main")){
			pageLocation = "/pharmacy_main_page.jsp";
		}
		
		//total
		else if(btn.equals("back")){
			pageLocation = "/total.jsp";
		}
		
		//sign up
		else if(btn.equals("signup")){
			pageLocation = "/signUp.jsp";
		} else if(btn.equals("signupp")){
			pageLocation = "/signUp.jsp";
		} else if(btn.equals("signinn")){
			pageLocation = "/signIn.jsp";
		}
		
		//sign in
		else if(btn.equals("sign_In")){
			pageLocation = "/signIn.jsp";
		}
		
		//view
		else if(btn.equals("sign_out_view")){
			pageLocation = "/pharmacy_view.jsp";
		}
		
		//delete info
		else if(btn.equals("deleteinfo")){
			pageLocation = "/pharmacy_delete_info.jsp";
		} else if(btn.equals("sign_out_delete")){
			pageLocation = "/pharmacy_delete_info.jsp";
		}
		
		//add info
		else if(btn.equals("addinfo")){
			pageLocation = "/pharmacy_add_info";
		} else if(btn.equals("sign_out_add")){
			pageLocation = "/pharmacy_add_info";
		}
		
		//order
		else if(btn.equals("add")){
			pageLocation = "/order.jsp";
		} else if(btn.equals("delete")){
			pageLocation = "/order.jsp";
		} else if(btn.equals("order_order")){
			pageLocation = "/order.jsp";
		}
		
		request.getRequestDispatcher(pageLocation).forward(request, response);
	}

}
