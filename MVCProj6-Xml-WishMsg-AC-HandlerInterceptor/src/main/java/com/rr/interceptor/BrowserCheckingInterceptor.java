package com.rr.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class BrowserCheckingInterceptor implements HandlerInterceptor {
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)throws Exception {
		String browser=null;
		RequestDispatcher rd=null;
		browser=req.getHeader("user-agent");
		if(browser.indexOf("Chrome")==-1) {
			rd=req.getRequestDispatcher("browsercheck.jsp");
			rd.forward(req, res);
			return false;
		}
		return true;
	}
}
