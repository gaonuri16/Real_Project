package com.spring.pr.ts.service;

import java.util.List;

import com.spring.pr.command.GhVO;
import com.spring.pr.command.TsVO;

public interface ITsService {
	
	//통번역인 조력자 기본정보 등록
		void regist(TsVO ts);
				
		// 글 목록
		List<GhVO> getList();
				
		// 총 게시물 수 
		int getTotal();
				
		// 상세보기 
		TsVO getContent(int bno);
				
		// 수정 
		void update(TsVO ts);
			
		// 삭제 
		void delete(int bno);

}
