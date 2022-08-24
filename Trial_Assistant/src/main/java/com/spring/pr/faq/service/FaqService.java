package com.spring.pr.faq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pr.answer.mapper.IAnswerMapper;
import com.spring.pr.command.FaqVO;
import com.spring.pr.faq.mapper.IFaqMapper;
import com.spring.pr.util.PageVO;

@Service
public class FaqService implements IFaqService {
	@Autowired
	private IFaqMapper faqMapper;
	
	@Autowired
	private IAnswerMapper ansMapper;

	@Override
	public void regist(FaqVO faq) {
		faqMapper.regist(faq);
	}

	@Override
	public List<FaqVO> getList(PageVO page) {
		
		return faqMapper.getList(page);
	}

	@Override
	public int getTotal(PageVO page) {
		return faqMapper.getTotal(page);
	}

	@Override
	public FaqVO getContent(int FaqNum) {
		return faqMapper.getContent(FaqNum);
	}

	@Override
	public void update(FaqVO faq) {
		faqMapper.update(faq);
	}

	@Override
	public void delete(int FaqNum) {
		faqMapper.delete(FaqNum);
	}

	@Override
	public void upHit(int FaqNum) {
		faqMapper.upHit(FaqNum);
	}
	


}
