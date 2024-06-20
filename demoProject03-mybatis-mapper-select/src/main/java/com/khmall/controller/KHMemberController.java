package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.khmall.dto.KHMember;
import com.khmall.service.KHMemberService;

@Controller
public class KHMemberController {

	@Autowired
	private KHMemberService khmemberService;
	
	@GetMapping("/allkhMember")
	public String getAllkhmember(Model model) {
		
		List<KHMember> khmemberList = khmemberService.getAllkhmember();
		model.addAttribute("khmemberList",khmemberList);
		
		return "khmemberList";
	}
}
