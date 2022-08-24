package com.spring.pr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.pr.apply.service.IApplyService;
import com.spring.pr.util.PageCreator;
import com.spring.pr.util.PageVO;


@Controller
@RequestMapping("/apply")
public class ApplyController {
	
	@Autowired
	private IApplyService service;
	
	@GetMapping("applyList")
	public void applyList() {
		
	}
	
//	//목록 화면
//		@GetMapping("/applyList")
//		public void applyList(PageVO vo, Model model) {
//			
//			System.out.println(vo);
//			
//			PageCreator pc = new PageCreator();
//			pc.setPaging(vo);
//			pc.setArticleTotalCount(service.getTotal(vo));
//			
//			System.out.println(pc);
//			
//			model.addAttribute("anmList", service.getList(vo));
//			model.addAttribute("pc", pc);		
//			
//		}

//	@PostMapping("/applyList")
//	public String write(AncmtVO ancmt) {
//		System.out.println("/notice/write : POST");
//		service.regist(ancmt);
//		return "redirect:/notice/notice_list";
//	}

//	@GetMapping("/list")
//	public String listNotice(Model model) {
//		System.out.println("/notice/list : GET");
////		model.addAttribute("notices", service.getList());
//
//		return "notice/notice_list";
//	}
//
//	@GetMapping("/content")
//	public String contentBoard(Model model) {
//		System.out.println("/notice/content : GET");
////		model.addAttribute("notice", service.getContent(noticeNo));
//		return "notice/notice_detail";
//	}
//
//
//	@GetMapping("/modify")
//	public String modifyoard() {
//		System.out.println("/notice/modify : POST");
////		service.update(notice);
//		return "notice/notice_modify_admin";
//	}


}