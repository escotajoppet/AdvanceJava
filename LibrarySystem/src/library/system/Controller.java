package library.system;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn = request.getParameter("btn");
		String page = "";
		
		switch(btn){
		//index.jsp
			case "forguest":
				page = "/guestPage.jsp";
				break;
			case "foradmin":
				page = "/index.jsp";
				break;
		//adminPage.jsp
			case "adminlogout":
				page = "/index.jsp";
				break;
			case "adminsearch":
				page = "/adminPage.jsp";
				break;
			case "addbook":
				page = "/addnewbook.jsp";
				break;
			case "deletebook":
				page = "/adminPage.jsp";
				break;
			case "viewguestlogs":
				page = "/guestLogs.jsp";
				break;
			case "viewallbooks":
				page = "/adminPage.jsp";
				break;
			case "viewborrowedbooks":
				page = "/borrowedBooks.jsp";
				break;
		//addnewbook.jsp
			case "add":
				page ="/addnewbook.jsp";
				break;
			case "back":
				page = "/adminPage.jsp";
				break;
		//bookAdded.jsp
			case "logout":
				page = "/index.jsp";
				break;
		//guestPage.jsp
			case "guestsearch":
				page = "/guestPage.jsp";
				break;
			case "borrowbook":
				page = "/guestPage.jsp";
				break;
			case "returnbook":
				page = "/returnBook.jsp";
				break;
		//returnBook.jsp
			case "return2":
				page = "/returnBook.jsp";
				break;
			case "back2":
				page = "/guestPage.jsp";
				break;
			case "setid":
				page = "/returnBook.jsp";
				break;
		//borrowBook.jsp
			case "borrow":
				page = "/borrowBook.jsp";
				break;
			
			case "viewallbooksguest":
				page = "/guestPage.jsp";
				break;
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}
}
