package com.spring.pr.instt.mapper;

import java.util.List;

import com.spring.pr.command.InsttVO;

public interface IInsttMapper {
	
	//등록
	void regist(InsttVO instt);
	
	// 글 목록
	List<InsttVO> getList();
				
	// 총 게시물 수 
	int getTotal();
				
	// 상세보기 
	InsttVO getContent(int bno);
				
	// 수정 
	void update(InsttVO instt);
			
	// 삭제 
	void delete(int bno);
		
}
