package com.spring.pr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/apply")
public class PersonInfoController {
	
	@GetMapping("personInfo")
	public void personInfo() {}
	
	@PostMapping("personInfoForm")
	public String personInfoForm() {
		
		return "redirect:/apply/identification";
	}

}
