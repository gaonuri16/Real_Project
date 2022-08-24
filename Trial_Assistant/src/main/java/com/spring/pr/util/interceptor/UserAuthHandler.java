package com.spring.pr.util.interceptor;

import javax.servlet.http.*;

import org.springframework.web.servlet.*;

public class UserAuthHandler implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	throws Exception{
		
		//세션에서 로그인 데이터를 얻어와 확인 
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") == null){
			//로그인 x 
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false; //컨트롤러 진입 막기 
		}
		
		System.out.println("핸들러 : 로그인 성공했어요");
		return true; //로그인 후 통과 
	}

}
