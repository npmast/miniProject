package myprj.learn04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookCalc
 */
@WebServlet("/cookie")
public class CookCalc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cookie Action");
		// 2.클라이언트로 부터 쿠키 읽기 - 복수로 읽는다. 
		Cookie[] cookies = request.getCookies();
		
		String str = request.getParameter("operand");
		String op = request.getParameter("operator");
		
		int n = 0;
		if(!str.equals("")) n = Integer.parseInt(str);
		
		if(op.equals("=")) {
			int x = 0;
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {				// 키를 찾았으면
					x = Integer.parseInt(c.getValue());			// 값을 가져온다.
					break;
				}
			}
			int y = n;

			String operator = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}
			int result = 0;

			if(operator.equals("+")) result = x + y;
			else result = x - y;
			
			response.getWriter().printf("result is %d\n", result);
		} 
		else {	
			// 1. 쿠키생성 + 클라이언트로 전달
			Cookie valueCookie = new Cookie("value", String.valueOf(n));	// Cookie에 저장되는 값은 String 타입이어야 된다.
			Cookie opCookie = new Cookie("op", op);
			
			valueCookie.setPath("/cookie");			// 해당 url을 요청할 때 valuecookie를 가져온다.
			valueCookie.setMaxAge(24*60*60);		// 웹브라우저가 닫혀도 만료시간까지(24시간) 쿠키가 유지된다.()
			opCookie.setPath("/cookie");			// 웹브라우저가 닫히면 쿠키도 사라진다. 해당 url을 요청할 때 opCookie를 가져온다.
			
			response.addCookie(valueCookie);		// 생성된 쿠키를 클라이언트에게 전달된다.
			response.addCookie(opCookie);
					
			// 서블릿이 경로를 설정한다.
			response.sendRedirect("learn04/singlecalc.html");
		}
	}
}

/*
 *	숫자와 연산자를 입력하고 F12를 확인하면 응답헤더에 쿠키를 실어 보내는걸 확인할 수 있다.
 *	숫자와 =연산자를 입력하면 요청헤더에 모든 쿠키를 실어서 서버로 보낸다.
 *  따라서 서버는 여러 쿠키중에 해당 쿠키를 찾아내는 명령을 작성해야 한다.
 */
