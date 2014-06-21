package online.pet.shop;

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
		String btn = request.getParameter("btn");
		String pageLocation = "";
		
		//log_in_page.jsp
		if(btn.equals("asadmin")){
			pageLocation = "/log_in_page.jsp";			
		} else if(btn.equals("ascustomer")){
			pageLocation = "/log_in_page.jsp";
		}
		
		//main_page.jsp
		else if(btn.equals("listofpets")){
			pageLocation = "main_page.jsp";
		} else if(btn.equals("petproducts")){
			pageLocation = "main_page.jsp";			
		} else if(btn.equals("viewallreservations")){
			pageLocation = "/reservation_table.jsp";
		} else if(btn.equals("logout")){
			pageLocation = "/log_in_page.jsp";
		}
		
		//pet_products.jsp
		else if(btn.equals("backtomainpage")){
			pageLocation = "/main_page.jsp";
		} else if(btn.startsWith("buyitm ")){
			pageLocation = "/pet_shop_pet_products.jsp";
		} else if(btn.startsWith("delitm" )){
			pageLocation = "/pet_shop_pet_products.jsp";
		} else if(btn.equals("additem")){
			pageLocation = "/pet_shop_pet_products.jsp";
		}
		
		//breeds.jsp
		else if(btn.equals("backtocategorylist")){
			pageLocation = "/pet_shop_pet_list.jsp";
		} else if(btn.startsWith("resbrd ")){
			pageLocation = "/pet_shop_breeds.jsp";
		} else if(btn.startsWith("delbrd " )){
			pageLocation = "/pet_shop_breeds.jsp";
		} else if(btn.equals("addbreed")){
			pageLocation = "/pet_shop_breeds.jsp";
		}
		
		//registration_form.jsp
		else if(btn.equals("getreservation")){
			pageLocation = "/registration_form.jsp";
		} else if(btn.equals("backto")){
			pageLocation = "/registration_form.jsp";
		}
		
		//pet_list.jsp
		else if(btn.equals("addcategory")){
			pageLocation = "pet_shop_pet_list.jsp";
		} else if(btn.startsWith("getcat ")){
			pageLocation = "pet_shop_pet_list.jsp";
		} else if(btn.startsWith("delcat ")){
			pageLocation = "pet_shop_pet_list.jsp";
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
