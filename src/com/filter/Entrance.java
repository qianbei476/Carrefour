package com.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/Entrance")
public class Entrance implements Filter {
  public Entrance() {
    }
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rsp = (HttpServletResponse) response;
		String path = req.getContextPath();

		//过滤掉在get方法下的，URL为InfoSystem以外的请求，错误请求全部发向error.html
		String url = req.getRequestURI();

		boolean isMatched = Pattern.matches(".*(png|jpg|css|js|eot|woff|ttf|gif)",url);

		if(req.getMethod().equals("GET") && !isMatched && !req.getRequestURI().equals("/DivShop/")){
			req.getRequestDispatcher("/error.html").forward(req, rsp);
		//	rsp.sendRedirect(path+"/error.html");
			//结果多行报错
			return ;
		}
		else if(req.getRequestURI().equals("/DivShop/")){
			 req.getRequestDispatcher("/login.html").forward(req, rsp);
			//rsp.sendRedirect(req.getRequestURI());
			//结果多行报错
			return ;
		}
		else{
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
