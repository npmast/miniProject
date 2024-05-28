package myprj.learn03;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class TestFilter
 */
//@WebFilter(filterName="/filter", urlPatterns="/*")
//public class TestFilter extends HttpFilter implements Filter {
//
//
//	/**
//	 * @see Filter#destroy()
//	 */
//	public void destroy() {
//
//	}
//
//	/**
//	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
//	 */
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		/* doFilter() 전은 전처리 코드 */
//		String ip = request.getRemoteAddr();
//		System.out.println("Remote IP Address :::: " + ip);
//		
//		chain.doFilter(request, response);
//		
//		/* doFilter() 호출 이후는 후처리 코드 */
//		System.out.println("후처리 코드 실행");
//	}
//
//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	public void init(FilterConfig fConfig) throws ServletException {
//		// TODO Auto-generated method stub
//	}
//
//}
