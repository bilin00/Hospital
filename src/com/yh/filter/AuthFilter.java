package com.yh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
        
		//如果访问的资源是以css或者js结尾的，那么就不需要判断是否登录
        if (uri.endsWith("welcome.jsp") || uri.endsWith("login.jsp") || uri.endsWith("AdLogin") || uri.endsWith("register.jsp") || uri.endsWith("AdAdd")) {
            chain.doFilter(request, response);
            return;        
        }
		
        String validname = (String) request.getSession().getAttribute("validname");
        if (null == validname) {
            response.sendRedirect("http://35.243.252.141/welcome.jsp");
            return;
        }

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
