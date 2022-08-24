package com.spring.pr.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/apply")
@Controller
public class SuccessController {
	
	// 신청완료 화면
	@GetMapping("/success")
	public void success() {}

	}
