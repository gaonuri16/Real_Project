package com.spring.pr.instt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pr.command.InsttVO;
import com.spring.pr.instt.mapper.IInsttMapper;

@Service
public class InsttService implements IInsttService {
	
	@Autowired
	IInsttMapper mapper;
	
	@Override
	public void regist(InsttVO instt) {
		mapper.regist(instt);
	}

	@Override
	public List<InsttVO> getList() {
		return mapper.getList();
	}

	@Override
	public int getTotal() {
		return mapper.getTotal();
	}

	@Override
	public InsttVO getContent(int bno) {
		return mapper.getContent(bno);
	}

	@Override
	public void update(InsttVO instt) {
		mapper.update(instt);
		
	}

	@Override
	public void delete(int bno) {
		mapper.delete(bno);
	}

}
