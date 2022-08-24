package com.spring.pr.gh.mapper;

import java.util.List;

import com.spring.pr.command.GhVO;

public interface IGhMapper {
	
	//일반 조력자 기본정보 등록 
	void regist(GhVO gh);
		
	// 글 목록
	List<GhVO> getList();
		
	// 총 게시물 수 
	int getTotal();
		
	// 상세보기 
	GhVO getContent(int bno);
		
	// 수정 
	void update(GhVO vo);
	
	// 삭제 
	void delete(int bno);
	
	
}

