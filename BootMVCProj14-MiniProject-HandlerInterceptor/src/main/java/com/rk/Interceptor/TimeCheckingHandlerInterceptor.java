package com.rk.Interceptor;

import java.time.LocalDateTime;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TimeCheckingHandlerInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("TimeCheckingHandlerInterceptor.preHandle()");
		if(request.getServletPath().equalsIgnoreCase("/"))
			return true;
		//get system date and time
		LocalDateTime ldt=LocalDateTime.now();
		//get current hour of the day
		int hour=ldt.getHour();
		if(hour<12 || hour>23) {
			RequestDispatcher rd=request.getRequestDispatcher("/timeout.jsp");
			rd.forward(request, response);
			return false;
		}
		
		return true;
	}

}
