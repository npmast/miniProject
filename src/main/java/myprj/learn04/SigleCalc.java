package myprj.learn04;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

/**
 * Servlet implementation class SigleCalc
 */
@WebServlet("/singlecalc")
public class SigleCalc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");	
/*		
		// Application ===================================================
		System.out.println("Session Action");
		// getServletContext() 메소드 호출로 application 저장소를 만든다.
		ServletContext application = request.getServletContext();	// application 객체 생성
*/
		
///*	// Session =============================================================
		System.out.println("Session Action");
		// session 객체를 만든다.
		HttpSession session = request.getSession();
//*/
		
		// name 속성으로 v와 operator 두개가 날라온다.
		String str = request.getParameter("operand");
		String op = request.getParameter("operator");
		
		int n = 0;
		if(!str.equals("")) n = Integer.parseInt(str);		// 문자열을 정수로 변환
		
		if(op.equals("=")) {
			//int x = (Integer)application.getAttribute("value");		// 애플리케이션 저장소에서 가져와 정수로 변환
			//String operator = (String)application.getAttribute("op");
			int x = (Integer)session.getAttribute("value");			
			String operator = (String)session.getAttribute("op");
			
			int y = n;
			int result = 0;

			if(operator.equals("+")) result = x + y;
			else result = x - y;
			
			response.getWriter().printf("result is %d\n", result);
		} 
		else {			// "=" 이 입력될 때가지는 저장소에 저장
			//application.setAttribute("value", n);		// 애플리케이션 저장소에 키와 값으로 저장(변환된 정수로)
			//application.setAttribute("op", op);			// 애플리케이션 저장소에 키와 값으로 저장
			
			session.setAttribute("value", n);		// 애플리케이션 저장소에 value = v로 저장
			session.setAttribute("op", op);
		}
		response.sendRedirect("singlecalc.html");
	}
	
}
