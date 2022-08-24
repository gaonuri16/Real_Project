package com.spring.pr.answer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pr.answer.mapper.IAnswerMapper;
import com.spring.pr.command.AnswerVO;

@Service
public class AnswerService implements IAnswerService {
	
	@Autowired
	private IAnswerMapper ansMapper;

	@Override
	public void regist(AnswerVO answer) {
		ansMapper.regist(answer);
	}

	@Override
	public List<AnswerVO> getList() {
		// TODO Auto-generated method stub
		return ansMapper.getList();
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return ansMapper.getTotal();
	}

	@Override
	public AnswerVO getContent(int FaqNum) {
		// TODO Auto-generated method stub
		return ansMapper.getContent(FaqNum);
	}

	@Override
	public void update(AnswerVO answer) {
		ansMapper.update(answer);
	}

	@Override
	public void delete(int AnsNum) {
		ansMapper.delete(AnsNum);
	}

	@Override
	public void upHit(int AnsNum) {
		ansMapper.upHit(AnsNum);
	}

}
