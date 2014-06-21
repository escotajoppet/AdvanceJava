package hotel.reservation;

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
		
		//index
		if(btn.equals("customer")){
			pageLocation = "/index.jsp";
		} else if(btn.equals("admin")){
			pageLocation = "/loginpage.jsp";
		}
		
		//log in
		else if(btn.equals("login")){
			pageLocation = "/loginpage.jsp";
		} else if(btn.equals("adminback")){
			pageLocation = "/index.jsp";
		}
		
		//municipality of hotel
		else if(btn.equals("gethotellists")){
			pageLocation = "/CityMunicipality";
		}
		
		//add new hotel
		else if(btn.equals("add")){
			pageLocation = "/AddNewHotel";
		} else if(btn.equals("cancel")){
			pageLocation = "/HotelsLists";
		}
		
		//hotels list
		else if(btn.equals("back")){
			pageLocation = "/CityMunicipality";
		} else if(btn.equals("remove")){
			pageLocation = "/HotelsLists";
		} else if(btn.equals("addnewhotel")){
			pageLocation = "/AddNewHotel";
		} else if(btn.startsWith("apm")){
			pageLocation = "/HotelsLists";
		} else if(btn.startsWith("ari")){
			pageLocation = "/HotelsLists";
		} else if(btn.startsWith("vhl ")){
			pageLocation = "/HotelsLists";
		} else if(btn.startsWith("vpm ")){
			pageLocation = "/HotelsLists";
		} else if(btn.startsWith("vri ")){
			pageLocation = "/HotelsLists";
		}
		
		//
		else if(btn.equals("accommodation")){
			pageLocation = "/CityMunicipality";
		} else if(btn.equals("sightsandactivities")){
			pageLocation = "/SightsAndActivities";
		} else if(btn.equals("planyourvisit")){
			pageLocation = "/PlanYourVisit";
		} else if(btn.equals("contactus")){
			pageLocation = "/ContactUs";
		} else if(btn.equals("logout")){
			pageLocation = "/loginpage.jsp";
		}
		
		else if(btn.equals("addroominformation")){
			pageLocation = "/add_room_information.jsp";
		}
		
		else if(btn.equals("addpromoinformation")){
			pageLocation = "/add_promo.jsp";
		} else if(btn.equals("addpromo")){
			pageLocation = "/add_promo.jsp";
		}
		
		else if(btn.equals("customerback")){
			pageLocation = "/HotelsLists";
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
