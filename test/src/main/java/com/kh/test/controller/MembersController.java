package com.kh.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.test.dto.Members;
import com.kh.test.service.MembersService;

@Controller
public class MembersController {

	@Autowired
	private MembersService membersService;
	
	@GetMapping("/")
	public String registerForm(Model model) {
		model.addAttribute("members", new Members());
		return "index";
	}
	
	@PostMapping("/register")
	public String insertEmail(Members members, Model model) {
		membersService.insertEmail(members);
		model.addAttribute("msg", "이메일 등록 완료");
		return "redirect:/";
	}
}
