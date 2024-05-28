package myprj.learn02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet {
	/* 1. serivice()메소드가 오버라이딩된 경우는 super.sercive()는 필요없고, 해당 method 방식을 작성하면 된다.*/
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
				throws ServletException, IOException {
		if(req.getMethod().equals("GET")) {				// 메소드를 읽어온다.(대문자 사용)
			System.out.println("GET 요청이 왔습니다.");
		}
		else if(req.getMethod().equals("POST")) {	// 메소드를 읽어온다.(대문자 사용)
			System.out.println("GET 요청이 왔습니다.");
			}
	}
//==========================================================================================================	
	/* 2. service() 메소드가 오버라이딩이 되어있지 않으면 super.service()메소드가 doGet과 doPost를 호출한다. */
	
//	super.service(req, resp);	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGET 메소드 호출");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPOST 메소드 호출");
	}
}
