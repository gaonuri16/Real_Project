package com.spring.pr.mypage.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;

import com.spring.pr.command.*;
import com.spring.pr.mypage.mapper.*;

public class MypageService implements IMypageService {
	
	@Autowired
	private IMypageMapper mapper;

	@Override
	public UserVO getInfo(String JOINID) {
		return null;
	}

	@Override
	public void updateUser(UserVO user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser1(String JOINSOCNUM, String JOINPW, String JOINNAME) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser2(String JOINSOCNUM, String JOINPW, String JOINNAME) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getSup() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSup() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<FaqVO> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void registFaq(FaqVO faq) {
		// TODO Auto-generated method stub

	}

	@Override
	public FaqVO getContent(int FaqNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateFaq(FaqVO faq) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFaq(int FaqNum) {
		// TODO Auto-generated method stub

	}

	@Override
	public void upHit(int FaqNum) {
		// TODO Auto-generated method stub

	}

}
