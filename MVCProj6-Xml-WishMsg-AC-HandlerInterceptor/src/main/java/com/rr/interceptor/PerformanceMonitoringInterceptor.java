package com.rr.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class PerformanceMonitoringInterceptor  implements HandlerInterceptor{
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)throws Exception {
		long start=0,end=0;
		//RequestDispatcher rd=null;
		start=System.currentTimeMillis();
		//rd=req.getRequestDispatcher("performancemonitoring.jsp");
		//rd.forward(req, res);
		end=System.currentTimeMillis();
		System.out.println(req.getRequestURL()+" request has taken  "+(end-start)+"  ms  to process the request");
		return true;
	}
	/*public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}*/
}
