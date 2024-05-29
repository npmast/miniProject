package myprj.learn04;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookSvt
 */
@WebServlet("/cooksvt")
public class CookSvt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("c", "cDate");			// 쿠키생성
		Cookie cookie2 = new Cookie("message", URLEncoder.encode("한글?", "utf-8"));
		cookie2.setMaxAge(0);
		
		response.addCookie(cookie);							// 응답헤더에 쿠키를 심어 클라이언트로 전송
		response.addCookie(cookie2);
	}

}
