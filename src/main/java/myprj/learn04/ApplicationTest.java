package myprj.learn04;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ApplicationTest
 */
@WebServlet("/applit")
public class ApplicationTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		
		
		String str = request.getParameter("data");
		//1
		System.out.println("data: " + str);
		//2
		//application.setAttribute("data", str);
		//str = (String)application.getAttribute("data");
		
		session.setAttribute("data", str);
		str = (String)session.getAttribute("data");
		System.out.println("Adata: " + str);
	}

}
