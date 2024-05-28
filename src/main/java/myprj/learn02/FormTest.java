package myprj.learn02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormTest
 */
@WebServlet("/fomt")
public class FormTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		
		response.setContentType("text/html; charset=utf-8");
		//서블릿으로 들어온 요청을 html형태로 보낼려면 출력스트림을 얻어야 한다.
		// PrintWriter은 바이트를 문자 형태를 가지는 객체롤 바꾼다.
		PrintWriter out = response.getWriter();		//응답으로 보낼 출력스트림을 얻는다.
		out.println("<h3>data1: " + data1 + "<br>" + "data2: " + data2);
		//out.println("<h3>data1: ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
