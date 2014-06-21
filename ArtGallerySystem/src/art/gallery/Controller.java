package art.gallery;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String btn = request.getParameter("btn");
		String pageLocation = "";
		
		//index.html
		if(btn.equals("viewartworks")){
			pageLocation = "/view_artwork.jsp";
		} else if(btn.equals("loginauthor")){
			pageLocation = "/loginpage.jsp";
		}
		
		//loginpage.jsp
		else if(btn.equals("signup")){
			pageLocation = "/membership_form.jsp";
		} else if(btn.equals("signin")){
			pageLocation = "/loginpage.jsp";
		} else if(btn.equals("backtomain")){
			pageLocation = "/index.html";
		}
		
		//membership_form.jsp
		else if(btn.equals("confirmsignup")){
			pageLocation = "/membership_form.jsp";
		} else if(btn.equals("backtologin")){
			pageLocation = "/loginpage.jsp";
		} else if(btn.equals("logout")){
			pageLocation = "/loginpage.jsp";
		}
		
		//authors_page.jsp
		else if(btn.equals("addnewart")){
			pageLocation = "/add_an_art_page.jsp";
		} else if(btn.equals("viewcontributions")){
			pageLocation = "/view_contributions.jsp";
		}
		
		//add_an_art_page.jsp
		else if(btn.equals("addart")){
			pageLocation = "/add_an_art_page.jsp";
		} else if(btn.equals("backtoauthor")){
			pageLocation = "/authors_page.jsp";
		}
		
		//view_contributions.jsp
		else if(btn.equals("backtoauthorpage")){
			pageLocation = "/authors_page.jsp";
		} else if(btn.startsWith("del ")){
			pageLocation = "/view_contributions.jsp";
		} else if(btn.equals("naknang") || btn.equals("naknang2")){
			pageLocation = "/view_contributions.jsp";
		} else if(btn.startsWith("vcm")){
			pageLocation = "/view_contributions.jsp";			
		}
		
		//view_artwork.jsp
		else if(btn.equals("searchart")){
			pageLocation = "view_artwork.jsp";
		} else if(btn.startsWith("com")){
			pageLocation = "view_artwork.jsp";
		} else if(btn.equals("backtomainpage")){
			pageLocation = "/index.html";
		}
		
		
		//view_comments.jsp
		else if(btn.equals("backcomment")){
			pageLocation = "/view_contributions.jsp";
		}
		
		request.getRequestDispatcher(pageLocation).forward(request, response);
	}
}
