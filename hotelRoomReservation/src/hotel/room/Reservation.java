package hotel.room;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Reservation
 */
@WebServlet(name = "mainPage", urlPatterns = {"/hrcontroller"})
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservation() {
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
		String pageLoc = ""; 
		String page_Button = request.getParameter("button");

////////////////////////////index.html buttons/////////////////////////////////////////////////
		if("indexCreate".equalsIgnoreCase(page_Button))
			pageLoc = "/create.jsp";
		if("indexChange".equalsIgnoreCase(page_Button))
			pageLoc = "/change.jsp";
		if("indexDelete".equalsIgnoreCase(page_Button))
			pageLoc = "/delete.jsp";
		if("indexBill".equalsIgnoreCase(page_Button))
			pageLoc = "/search.jsp";
		if("indexAll".equalsIgnoreCase(page_Button))
			pageLoc = "/viewAll.jsp";

////////////////////////create.jsp buttons/////////////////////////////////////////////////////
		if("createSubmit".equalsIgnoreCase(page_Button))
			pageLoc = "/create.jsp";
		if("createBack".equalsIgnoreCase(page_Button))
			pageLoc = "/index.html";
		
////////////////////////change.jsp buttons/////////////////////////////////////////////////////
		if("changeNext".equalsIgnoreCase(page_Button))
			pageLoc = "/change.jsp";
		if("changeBack".equalsIgnoreCase(page_Button))
			pageLoc = "/index.html";
////////////////////////update.jsp buttons/////////////////////////////////////////////////////
		if("updateChange".equalsIgnoreCase(page_Button))
			pageLoc = "/update.jsp";
		if("updateBack".equalsIgnoreCase(page_Button))
			pageLoc = "/change.jsp";
////////////////////////delete.jsp buttons/////////////////////////////////////////////////////
		if("deleteDelete".equalsIgnoreCase(page_Button))
			pageLoc = "/delete.jsp";
		if("deleteBack".equalsIgnoreCase(page_Button))
			pageLoc = "/index.html";	
////////////////////////search.jsp buttons/////////////////////////////////////////////////////
		if("searchNext".equalsIgnoreCase(page_Button))
			pageLoc = "/search.jsp";
		if("searchBack".equalsIgnoreCase(page_Button))
			pageLoc = "/index.html";
////////////////////////viewBill.jsp buttons/////////////////////////////////////////////////////
		if("viewbillPay".equalsIgnoreCase(page_Button))
			pageLoc = "/payment.jsp";
		if("viewbillProfile".equalsIgnoreCase(page_Button))
			pageLoc = "/viewBill.jsp";		
		if("viewBillBack".equalsIgnoreCase(page_Button))
			pageLoc = "/search.jsp";	
////////////////////////profile.jsp buttons/////////////////////////////////////////////////////
		if("profileBack".equalsIgnoreCase(page_Button))
		pageLoc = "/viewBill.jsp";		
////////////////////////payment.jsp buttons/////////////////////////////////////////////////////
		if("paymentSubmit".equalsIgnoreCase(page_Button))
			pageLoc = "/payment.jsp";
		if("paymentBack".equalsIgnoreCase(page_Button))
			pageLoc = "/viewBill.jsp";		
////////////////////////profile.jsp buttons/////////////////////////////////////////////////////
		if("viewAllBack".equalsIgnoreCase(page_Button))
			pageLoc = "/index.html";
		request.getRequestDispatcher(pageLoc).forward(request,response);
	}

}
