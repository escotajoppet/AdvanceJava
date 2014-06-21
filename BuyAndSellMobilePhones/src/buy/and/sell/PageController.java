package buy.and.sell;

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
		
		//search_page.jsp
		if(btn.equals("search")){
			pageLocation = "/buy_and_sell_search_page.jsp";
		} else if(btn.equals("addnew")){
			pageLocation = "/buy_and_sell_add_new_entry.jsp";
		} else if(btn.equals("signupnewmember")){
			pageLocation = "/buy_and_sell_sign_up_page.jsp";
		} else if(btn.equals("loginmember")){
			pageLocation = "/buy_and_sell_login_page.jsp";
		}
		
		//add_new_entry.jsp
		else if(btn.equals("add")){
			pageLocation = "/buy_and_sell_add_new_entry.jsp";
		} else if(btn.equals("backtosearch")){
			pageLocation = "/buy_and_sell_search_page.jsp";
		} else if(btn.equals("backtoguest")){
			pageLocation = "/buy_and_sell_member_page.jsp";
		}
		
		//result_page.jsp
		else if(btn.startsWith(".. ")){
			pageLocation = "/buy_and_sell_result_page.jsp";
		}
		
		//seller_profile.jsp
		else if(btn.equals("backtoresult")){
			pageLocation = "/buy_and_sell_result_page.jsp";
		}
		
		//sign_up_page.jsp
		else if(btn.equals("signup")){
			pageLocation = "/buy_and_sell_sign_up_page.jsp";
		}
		
		//login_page.jsp
		else if(btn.equals("login")){
			pageLocation = "/buy_and_sell_login_page.jsp";
		}
		
		//member_page.jsp
		else if(btn.startsWith("del ")){
			pageLocation = "/buy_and_sell_member_page.jsp";
		} else if(btn.equals("Update Profile")){
			pageLocation = "/buy_and_sell_member_page.jsp";
		} else if(btn.equals("Confirm Update")){
			pageLocation = "/buy_and_sell_member_page.jsp";
		} else if(btn.contains("sell")){
			pageLocation = "/buy_and_sell_member_page.jsp";
		}
		
		//admin_page.jsp
		else if(btn.startsWith("adl")){
			pageLocation = "/buy_and_sell_admin_page.jsp";
		}
		
		else if(btn.equals("logout")){
			pageLocation = "/buy_and_sell_login_page.jsp";
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
