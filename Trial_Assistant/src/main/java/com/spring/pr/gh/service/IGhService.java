package com.spring.pr.gh.service;

import java.util.List;

import com.spring.pr.command.GhVO;

public interface IGhService {

	//일반 조력자 기본정보 등록 
	void regist(GhVO gh);
			
	// 글 목록
	List<GhVO> getList();
			
	// 총 게시물 수 
	int getTotal();
			
	// 상세보기 
	GhVO getContent(int bno);
			
	// 수정 
	void update(GhVO gh);
		
	// 삭제 
	void delete(int bno);

}
