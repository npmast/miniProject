package myprj.prj1;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 * action 파라미터를 비교해 메서드를 호출한 다음 뷰로 이동한다.
 */
@WebServlet("/productctl")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductService service;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
    	service = new ProductService();		// service 객체 생성, 모든 사용자에게 동일한 인스턴스 제공
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");		// 입력파라미터 action을 가져온다.
		String view = "";									// 이동할 화면을 저장할 view 변수

		if(action == null) {		// 실행을 컨트롤러에서하니까 처음 실행단계에는 Context파라미터가 없어 null이된다. 따라서 재실행
			getServletContext().getRequestDispatcher("/productctl?action=list").forward(request, response);
		} else {
			switch(action) {
			case "list": view = list(request, response);break;
			case "info": view = info(request, response);break;
			}
			// Context파라미터를 읽어 해당 요청페이지로 이동하여 view를 실행한다.
			getServletContext().getRequestDispatcher("/prj1/"+view).forward(request, response);			
		}		
	}

	private String info(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("p", service.find(request.getParameter("id")));
		return "productInfo.jsp";
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		// request scope에 "products" 객체명으로 모든 product를 저장한다. 
		request.setAttribute("products", service.findAll());	// products의 list 객체들을 불러온다.
		return "productList.jsp";								// 
	}
	
}

/* 32행 forward는 WAS내의 다른 리소스에게 요청을 전달한다. request없이 처리결과 페이지를 전송한다. 
 *     redirect는 요청을 브라우저에세 전달하여 다른 웹 애플리케이션을 요청합니다.
 * 		ServletContext를 통해서 RequestDispatcher를 얻는데 Requ~ 는 현재 처리중인 서블릿에 속해 잇는 웹 어플리케이션
 * 	범위내에서만 요청을 제어할 수 있다.
 * */
