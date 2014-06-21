package funeral.plan;

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
		String pageLocation = "";
		String btn = request.getParameter("btn");
		
		//login_page.jsp
		if(btn.equals("register")){
			pageLocation = "/membership_form.jsp";
		} else if(btn.equals("customerlogin")){
			pageLocation = "/login_page.jsp";
		} else if(btn.equals("logasadmin")){
			pageLocation = "/admin_login_page.jsp";
		}
		
		//admin_login_page.jsp
		else if(btn.equals("adminlogin")){
			pageLocation = "/admin_login_page.jsp";
		} else if(btn.equals("logascustomer")){
			pageLocation = "/login_page.jsp";
		}
		
		//admin_page.jsp
		else if(btn.equals("viewcustomers")){
			pageLocation = "/view_customers.jsp";
		} else if(btn.equals("viewplanlist")){
			pageLocation = "/plan_list.jsp";
		}
		
		//view_customers.jsp
		else if(btn.equals("backtoadminpage")){
			pageLocation = "/admin_page.jsp";
		}
		
		//membership_form.jsp
		else if(btn.equals("registeruser")){
			pageLocation = "/membership_form.jsp";
		} else if(btn.equals("backtologin")){
			pageLocation = "/login_page.jsp";
		}
		
		//plan_list.jsp
		else if(btn.equals("logout")){
			pageLocation = "/login_page.jsp";
		} else if(btn.equals("next")){
			pageLocation = "/plan_list.jsp";
		} 
		
		//selected_plan_type_table.jsp
		else if(btn.equals("submit")){
			pageLocation = "/selected_plan_type_table.jsp";
		} else if(btn.equals("back")){
			pageLocation = "/plan_list.jsp";
		} else if(btn.startsWith("rmvpln ")){
			pageLocation = "/selected_plan_type_table.jsp";
		} else if(btn.startsWith("udtpln ")){
			pageLocation = "/selected_plan_type_table.jsp";
		} else if(btn.equals("addnewplantype")){
			pageLocation = "/add_new_plan_type.jsp";
		}
		
		//update_plan_type.jsp
		else if(btn.equals("updateplantype")){
			pageLocation = "/update_plan_type.jsp";
		} else if(btn.equals("cancelupdate")){
			pageLocation = "/selected_plan_type_table.jsp";
		}
		
		//add_new_plan_type.jsp
		else if(btn.equals("addplantype")){
			pageLocation = "/add_new_plan_type.jsp";
		} else if(btn.equals("calceladd")){
			pageLocation = "/selected_plan_type_table.jsp";
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
