package myprj.learn05;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServiceMethod
 */
@WebServlet("/servicemethod")
public class ServiceMethod extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/* 1. serivice()메소드가 오버라이딩된 경우는 super.sercive()는 필요없고, 해당 method 방식을 작성하면 된다.*/
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("GET")) {				// 메소드를 읽어온다.(대문자 사용)
			System.out.println("GET 요청이 왔습니다.");
		}
		else if(request.getMethod().equals("POST")) {	// 메소드를 읽어온다.(대문자 사용)
			System.out.println("POST 요청이 왔습니다.");
		}
		
		// super.service(request, response);  // service 메서드는 doGet(), doPost() 메서드를 호출한다.
		// service()메서드가 없으면 아래 2번이 실행된다.
	}

	
	//============================================================================================
	
	/* 2. service() 메소드가 오버라이딩이 되어있지 않으면 doGet과 doPost를 호출한다. */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGET 메소드 호출");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPOST 메소드 호출");
	}

	
	
}

