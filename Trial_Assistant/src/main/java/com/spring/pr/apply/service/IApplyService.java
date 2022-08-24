package com.spring.pr.apply.service;

import java.util.List;

import com.spring.pr.command.AncmtVO;
import com.spring.pr.util.PageVO;

public interface IApplyService {
	
	
	//글 등록 test
	void regist(AncmtVO vo); 
	
	//글 목록
	List<AncmtVO> getList(PageVO vo);
		
	//총 게시물 수
	int getTotal(PageVO vo);
	
	//아이디 중복 확인
	int idCheck(String id);

}
