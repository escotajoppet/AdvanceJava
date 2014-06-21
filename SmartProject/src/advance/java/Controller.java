package advance.java;

import java.io.IOException;
import java.io.PrintWriter;

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
		Smart obj = new Smart();
		String pageLocation = "/error.html";
		
		PrintWriter out = response.getWriter();
		
		String page = request.getParameter("page");
		String accountno = request.getParameter("accountno");
		
		switch(page){
			case "subinfo":
				pageLocation = "SubscriberInformation";
				break;
			default:
				break;
		}
		
		System.out.println("Page Destination: " + pageLocation);
		request.setAttribute("source", "InputForm");
		request.getRequestDispatcher(pageLocation).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
