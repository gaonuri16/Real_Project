package com.spring.pr.controller;

import java.io.*;

import javax.servlet.http.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

import com.spring.pr.command.*;
import com.spring.pr.user.service.*;
import com.spring.pr.util.*;


@Controller
//@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	//도로명주소 승인키 -> devU01TX0FVVEgyMDIyMDYyMjE2MTc1NTExMjcxNjc=
	
	@Autowired
	private IUserService service;
	
	//기관/개인 선택 페이지로 이동 
	@GetMapping("/user/joinSelect")
	public String joinSelect() {
		System.out.println("user/joinSelect");
		return "user/joinSelect";
	}
	
	//개인 회원가입 페이지 이동 
	@GetMapping("/user/joinUser")
	public String joinUser() {
		System.out.println("user/joinUser");
		
		return "user/joinUser";
	}
	
	//기관 회원가입 페이지 이동 
	@GetMapping("/user/joinIns")
	public String joinIns() {
		System.out.println("user/joinIns");
		return "user/joinIns";
	}
	
	
	//아이디 중복 확인(비동기)  
	@ResponseBody
	@PostMapping("/user/idCheck")
	public String idCheck(@RequestBody String JOINID) {
		
		int result = service.idCheck(JOINID);
		System.out.println(result);
		
		if(result == 1) {
			
			System.out.println("컨트롤러: 존재하는 아이디입니다.");
			return "no";
			
		}else {
			
			System.out.println("컨트롤러 : 사용 가능한 아이디입니당.");
			return "ok";
		}
	}
	
	//이메일 일증 
	@Autowired
	private MailSendService mailService;
	
	@GetMapping("/user/mailCheck")
	@ResponseBody
	public String mailCheck(String joinEmail) {
		System.out.println("이메일 인증 요청 들어옴!");
		System.out.println("인증 이메일 : " + joinEmail);
		return mailService.joinEmail(joinEmail);
	}
	
	//회원 가입 처리  개인 
	@PostMapping("/user/joinuuser")
	public String join(UserVO user, RedirectAttributes ra) {
		user.setJOINSOCNUM(user.getJOINSOCNUM1() + user.getJOINSOCNUM2()); 
		user.setJOINEMAIL(user.getJOINEMAIL1() + user.getJOINEMAIL2());
		user.setJOINPERSON("0");
		user.setJOINRIGHT("U");
		System.out.println("Param: " + user);
		
		service.join(user);
		ra.addFlashAttribute("msg", "joinSuccess");
		return "user/login";
	}
	
	//회원 가입 처리 기관 
	@PostMapping("/user/joiniins")
	public String join2(UserVO user, RedirectAttributes ra) {
		System.out.println("join2 실행");
		
		user.setJOINSOCNUM(user.getJOINSOCNUM1() + user.getJOINSOCNUM2()); 
		user.setJOINEMAIL(user.getJOINEMAIL1() + user.getJOINEMAIL2());
		user.setJOINPERSON("1");
		user.setJOINRIGHT("U");
		System.out.println("Param: " + user);
			
		service.join(user);
		ra.addFlashAttribute("msg", "joinSuccess");
		return "user/login";
	}
	
	//로그인 페이지로 이동 
	@GetMapping("/user/login")
	public void login() {}
		
	//로그인 처리 
	@PostMapping("/user/Login")
	public String Login(@RequestParam("JOINID") String id, @RequestParam("JOINPW") String pw, Model model,
							HttpServletRequest request) {
		// 세션처리 하기 
		System.out.println("로그인 유저 정보 가져오는지 확인 " + id + " " + pw);
			
		UserVO login = service.login(id, pw);
		
		System.out.println(login);
			

		if (login == null) {
			return "/user/joinSelect";
		} else {
			if(login.getJOINPERSON().equals("0")) {
				HttpSession session = request.getSession();

				session.setAttribute("login", login);
				// 세션 만들기 
				// 다른 곳에서도 데이터를 사용하기 위해 
				model.addAttribute("user", login);
				// 보내고자 하는 경로에 해당 데이터 보냄 

				return "user/mypagePerson";
			}
		}
			

			HttpSession session = request.getSession();

			session.setAttribute("login", login);
			// 세션 만들기 
			// 다른 곳에서도 데이터를 사용하기 위해 
			model.addAttribute("user", login);
			// 보내고자 하는 경로에 해당 데이터 보냄 
			
			return "user/mypageIns";
	}
	
	//로그아웃 처리
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpSession session, RedirectAttributes ra) throws IOException {
		System.out.println("/user/logout : GET");
		UserVO user = (UserVO) session.getAttribute("login");
		
		session.invalidate();
		
		
		return "user/login";
	}
	
		//마이페이지 개인 수정 페이지
		@GetMapping("/user/mypagePersonModif")
		public String mypagerPersonModif(HttpSession session, Model model) {
			
			UserVO user = ((UserVO)session.getAttribute("login"));
			System.out.println("login의 결과: " + user);
			model.addAttribute("userInfo", user);
			
			return "user/mypagePersonModif";
			
		}
		
		//마이페이지 개인 수정 처리 
		@PostMapping("/user/MypagePersonModif")
		public String MypagePersonModif(HttpSession session, Model model, UserVO user) {
		
			service.updateUser(user);
			model.addAttribute("user", user);
			System.out.println("user정보 뿌려주나?" + user);
			
			return "user/mypagePerson";
		}
		
		
		//마이페이지 기관 수정 페이지
		@GetMapping("/user/mypageInsModif")
		public String mypagerInsModif(HttpSession session, Model model) {
					
			UserVO user = ((UserVO)session.getAttribute("login"));
			System.out.println("login의 결과: " + user);
			model.addAttribute("userInfo", user);
					
			return "user/mypageInsModif";
					
		}
				
		//마이페이지 기관 수정 처리
		@PostMapping("/user/MypageInsModif")
		public String MypageInsModif(HttpSession session, Model model, UserVO user) {
				
			service.updateUser(user);
			model.addAttribute("user", user);
			System.out.println("user정보 뿌려주나?" + user);
					
			return "user/mypageIns";
		}
		
		
		
		
		//회원탈퇴 페이지 이동
		@GetMapping("/user/withdrawal")
		public void withdrawal() {}		
		
		//회원탈퇴 처리 
		@PostMapping("/user/Withdrawal")
		public String Withdrawal(HttpSession session, Model model, UserVO user) {
			
			
			UserVO userSession = ((UserVO)session.getAttribute("login"));
			
			if (userSession.getJOINPW().equals(user.getJOINPW())) {
				System.out.println("회원 탈퇴 정보 확인 " + user.getJOINPW());
				System.out.println(userSession.toString());
				

				service.deleteUser1(userSession.getJOINPW());
				service.deleteUser2(userSession.getJOINPW(), userSession.getJOINNAME());

				
				session.invalidate();
				return "/user/withdrawalComplete";

			}
			else {
				return "user/mypagePerson";
			}
			
	
			
		}		
			
		//회원탈퇴 페이지 이동
		@GetMapping("/user/withdrawalComplete")
		public void withdrawalComplete() {}		

	
	
				
	//아이디 찾기 페이지 이동
	@GetMapping("/user/idSearch")
	public void idSearch() {}
		
	//아이디 찾기 처리 
	@PostMapping("/user/IdSearch")
	public String IdSearch(@RequestParam("JOINNAME") String joinName, @RequestParam("JOINSOCNUM") String joinSocNum, Model model) {
	
		System.out.println("아이디 찾기 실행! 이름,주민번호 :" + joinName + " " + joinSocNum);
		UserVO idSearch = service.idSearch(joinName, joinSocNum);
		System.out.println("아이디찾기: " + idSearch);
		model.addAttribute("userInfo", idSearch);
		

		return "user/idSearchComplete";
	}
	
	
		
		
	//비밀번호 찾기 페이지 이동 
	@GetMapping("/user/pwSearch")
	public void pwSearch() {}
		
	//비밀번호 찾기 처리 
	@PostMapping("/user/PwSearch")
	public String PwSearch(@RequestParam("JOINNAME") String joinName, @RequestParam("JOINSOCNUM") String joinSocNum, Model model) {
		
		System.out.println("비밀번호 찾기 실행! 이름, 주민번호:  " + joinName + " " + joinSocNum);
		UserVO pwSearch = service.pwSearch(joinName, joinSocNum);
		
		System.out.println("비밀번호찾기:  " + pwSearch);
		
		model.addAttribute("user", pwSearch);
		
					
		return "user/newPwRegist";
	}
		
	//새 비밀번호 등록 처리 
	@PostMapping("/user/NewPwRegist")
	public String newPwRegis(UserVO user, @RequestParam("JOINSOCNUM") String joinSocNum) {	

	
		
		service.newPwRegist(user);
		
		System.out.println("수정된 user정보: " + user);
		
	
		return "user/newPwRegistComplete";
		}		
		

}
	
	
	
	
	
	
	

