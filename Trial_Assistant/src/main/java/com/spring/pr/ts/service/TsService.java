package com.spring.pr.ts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pr.command.GhVO;
import com.spring.pr.command.TsVO;
import com.spring.pr.ts.mapper.ITsMapper;

@Service
public class TsService implements ITsService {
	
	@Autowired
	private ITsMapper mapper;

	@Override
	public void regist(TsVO ts) {
		mapper.regist(ts);
	}

	@Override
	public List<GhVO> getList() {
		return mapper.getList();
	}

	@Override
	public int getTotal() {
		return mapper.getTotal();
	}

	@Override
	public TsVO getContent(int bno) {
		return mapper.getContent(bno);
	}

	@Override
	public void update(TsVO ts) {
		mapper.update(ts);
	}

	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub
		
	}

}
