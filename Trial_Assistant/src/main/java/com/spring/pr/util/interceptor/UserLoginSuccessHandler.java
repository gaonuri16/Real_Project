//package com.spring.pr.util.interceptor;
//
//import javax.servlet.http.*;
//
//import org.springframework.ui.*;
//import org.springframework.web.servlet.*;
//
//import com.spring.pr.command.*;
//
//public class UserLoginSuccessHandler implements HandlerInterceptor {
//
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		
//		System.out.println("로그인 인터셉터 동작!");
////		modelAndView.getModel().get("key"); (o)
//		ModelMap mv = modelAndView.getModelMap();
//		UserVO user = (UserVO) mv.get("user");
//		System.out.println("interceptor vo: " + user);
//		
//		if(user != null) { //컨트롤러에서 로그인을 성공했던 사람.
//			System.out.println("로그인 성공 로직 동작!");
//			//로그인 성공한 회원에게 세션 데이터를 생성해서 로그인 유지를 하게 해 줌.
//			HttpSession session = request.getSession();
//			session.setAttribute("login", user);
//			response.sendRedirect(request.getContextPath());
//		} else { //vo == null -> 로그인 실패.
//			modelAndView.addObject("msg", "loginFail");
//			modelAndView.setViewName("/user/login");
//		}
//		
//	
//	}
//	
//}


//	
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		
//		System.out.println("로그인 요청이 들어가기 전 인터셉터 발동");
//		HttpSession session = request.getSession();
//		 System.out.println("파라미터 값 가져오는지 확인 " +  request.getParameter("JOINID"));
//		// 될려나
//	  // 되넴
//		return true;		
//	}
//	
	// controller에서 데이터 처리 후 디스패처에 보내기 전 가져와서 확인 
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		
//		HttpSession session = request.getSession();
//		
//
//		System.out.println("로그인 요청 후 디스패처에게 가기 전 인터셉터 발동");
////		Object user = modelAndView.getModel().get("loginUser");
//		ModelMap mv = modelAndView.getModelMap();
//		// model 객체에 있는 것을 ModelMap 타입으로 반환해줌
//		
//		UserVO user = (UserVO) mv.get("loginUser");
//		
//		// ModelMap객체에서 값을 가져올 수 있음
//		
//		System.out.println("인터셉터에서 불러온 유저 데이터 : " + user);
//		if (user == null) {
//			modelAndView.addObject("msg", "loginFail");
//			modelAndView.setViewName("/user/login");
//		} else {
//			System.out.println("로그인 성공 로직");
//			// 로그인을 성공했으면 session을 생성해서 로그인 유지할 수 있는 수단으로 사용 
//			session.setAttribute("login", user);
//			// 세션 저장 
//			response.sendRedirect("/myweb/");
//		}
//
//	}
//}
//	