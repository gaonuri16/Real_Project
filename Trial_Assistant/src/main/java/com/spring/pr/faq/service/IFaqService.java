package com.spring.pr.faq.service;

import java.util.List;

import com.spring.pr.command.FaqVO;
import com.spring.pr.util.PageVO;

public interface IFaqService {
	
	// 글 등록 
	void regist(FaqVO faq);
	
	// 글 목록
	List<FaqVO> getList(PageVO page);
	
	// 총 게시물 수 
	int getTotal(PageVO page);
	
	// 상세보기 
	FaqVO getContent(int FaqNum);
	
	// 수정 
	void update(FaqVO faq);
	
	// 삭제 
	void delete(int FaqNum);
	
	// 조회수 증가 
	void upHit(int FaqNum);
	

}
