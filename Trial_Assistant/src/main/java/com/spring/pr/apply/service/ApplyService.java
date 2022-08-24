package com.spring.pr.apply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pr.command.AncmtVO;
import com.spring.pr.util.PageVO;

@Service
public class ApplyService implements IApplyService {

	@Autowired IApplyService mapper;
	
	@Override
	public void regist(AncmtVO vo) {
		mapper.regist(vo);
	}
	
	@Override
	public List<AncmtVO> getList(PageVO vo) {
		List<AncmtVO> list = mapper.getList(vo);
		return list;
	}

	@Override
	public int getTotal(PageVO vo) {
		return mapper.getTotal(vo);
	}

	@Override
	public int idCheck(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
