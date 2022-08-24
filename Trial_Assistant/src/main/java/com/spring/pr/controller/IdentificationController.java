package com.spring.pr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/apply")
@Controller
public class IdentificationController {
	
	//본인 인증 화면
	@GetMapping("/identification")
	public void identification() {}
	
	}