package com.spring.pr.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageVO {

	//사용자가 선택한 페이지 정보를 담을 변수
	private int pageNum;	//사용자가 선택한 페이지 번호
	private int cpp;	//한 화면에 보여질 게시물 수
	
	//검색에 필요한 데이터를 변수로 선언.
	private String keyword;
	private String condition;
	
	public PageVO() {
		this.pageNum = 1;
		this.cpp = 10;
	}
	
}