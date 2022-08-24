package com.spring.pr.user.service;

import org.apache.ibatis.annotations.*;

import com.spring.pr.command.*;


public interface IUserService {
	
		//아이디 중복 확인 
		int idCheck(String JOINID);
		
		//회원 가입
		void join(UserVO user);
			
		//로그인 
		UserVO login(@Param("JOINID") String JOINID, @Param("JOINPW") String JOINPW);
		
		//아이디 찾기 
		UserVO idSearch(@Param("JOINNAME") String joinName, @Param("JOINSOCNUM") String joinSocNum);
			
		//비밀번호 찾기 
		UserVO pwSearch(@Param("JOINNAME") String joinName, @Param("JOINSOCNUM") String joinSocNum);
		//UserVO pwSearch(@Param("JOINNAME") String JOINNAME, @Param("JOINSOCNUM") String JOINSOCNUM);
		
		// 비밀번호 재등록 
		void newPwRegist(UserVO user);
		
		
		//회원 정보 얻어오기 
		UserVO getInfo(String JOINID);
					
		//회원 정보 수정 
		void updateUser(UserVO user);

		//회원 정보 삭제 
		void deleteUser1(@Param("JOINPW") String JOINPW);
		void deleteUser2(@Param("JOINPW") String JOINPW, @Param("JOINNAME") String JOINNAME);
		

		
}