package com.shinhan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Filter : 요청 filter, 응답 filter 공통적으로 여러 서블릿에 적용할 코드 작성
 */
@WebFilter("*.do")
public class EncodingFilter extends HttpFilter implements Filter {

	public EncodingFilter() {
		System.out.println("EncodingFilter 생성됨");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("요청 전에 수행");

		long startTime = System.nanoTime();
		String path = ((HttpServletRequest) request).getContextPath();
		String uri = ((HttpServletRequest) request).getRequestURI();
		System.out.println(path);
		System.out.println(uri);

		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
		System.out.println("응답을 보내기 전에 수행");
		long endTime = System.nanoTime();
		System.out.println("excution time: " + (endTime - startTime));
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
