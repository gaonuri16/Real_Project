package com.spring.pr.gh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pr.command.GhVO;
import com.spring.pr.command.TsVO;
import com.spring.pr.gh.mapper.IGhMapper;

@Service
public class GhService implements IGhService {

	@Autowired IGhMapper mapper;

	@Override
	public void regist(GhVO gh) {
		mapper.regist(gh);
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
	public GhVO getContent(int bno) {
		return mapper.getContent(bno);
	}

	@Override
	public void update(GhVO gh) {
		mapper.update(gh);
	}

	@Override
	public void delete(int bno) {
		mapper.delete(bno);
	}

}
