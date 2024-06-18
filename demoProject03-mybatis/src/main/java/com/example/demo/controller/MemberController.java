package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Member;
import com.example.demo.service.MemberService;

@Controller // db와 templates을 연결
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//회원가입을 위해 작성할 GetMapping 작성
	//회원가입으로 이동해서 작성하길 원한다면 /register 주소명을 작성해주고
	//홈페이지에서 아무것도 작성 안한 맨 처음부터 회원가입을 보길 원한다면 / 작성
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("mem", new Member());
		return "index";
	}
	//회원가입을 완료하면 보일 PostMapping 작성
	@PostMapping("/register")
	public String 회원가입완료(Member member, Model model) {
		//회원가입 작성이 완료가 되면 db에 저장
		memberService.insertMember(member);
		//model.addAttribute("select로 db에 저장된 회원가입 정보 가져오기")
		model.addAttribute("msg", "멤버가 성공적으로 가입되었습니다.");
		return "success";
	}
}
