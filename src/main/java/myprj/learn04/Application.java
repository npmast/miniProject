package myprj.learn04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Application
 */
@WebServlet("/application")
public class Application extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String num = request.getParameter("num");		// request는 String으로 보낸다.
		String op = request.getParameter("op");
		
		//System.out.println(num);
		//System.out.println(op);
		
		// 서블릿컨테이너 저장소 application 객체 생성
		ServletContext application = request.getServletContext();
		
		if(!op.equals("=")) {		
			application.setAttribute("operand", num);		// operand라는 키이름으로 num 저장, 키는 String타입이다.
			application.setAttribute("operator", op);
			
			//System.out.println(num);
			//System.out.println(operator);
		} else {
			// 속성값을 읽어올 때는 형변환이 필요하다.
			String operator = (String)application.getAttribute("operator");
			String operand = (String)application.getAttribute("operand");
			int n1 = Integer.parseInt(operand);
			int n2 = Integer.parseInt(num);
//			String operator = (String)application.getAttribute("operator");
			System.out.println(num);
			System.out.println(op);
			
			long result = 0;
//			
			switch(operator) {
				case "+": 
					result = n1 + n2; 
					break;
				case "-": 
					result = n1 - n2;
					break;
				case "/": 
					result = n1 / n2;
					break;
				case "*": 
					result = n1 * n2;
					break;
			}
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.append("<html><body><h2>계산기 서블릿</h2><hr>")
			.append("계산 결과: "+result+"</body></html>");
			
		}
		

	}

}
