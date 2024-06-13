package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DTO.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("member")
public class MemberController {

	@GetMapping("memberInfo")
	public String memberInfo(Model model) {
		MemberDTO mem = new MemberDTO();
		
		mem.setName("홍길동");
		mem.setPhone("010-1111-1111");
		mem.setAge(10);
		model.addAttribute("mem",mem);
		mem.setName("강영희");
		mem.setPhone("010-2222-2222");
		mem.setAge(20);
		model.addAttribute("mem",mem);
		mem.setName("박철수");
		mem.setPhone("010-3333-3333");
		mem.setAge(30);		
		model.addAttribute("mem",mem);
		
		List<MemberDTO> memList = new ArrayList<>();
		memList.add(new MemberDTO("홍길동", "010-1111-1111", 10));
		memList.add(new MemberDTO("강영희", "010-2222-2222", 20));
		memList.add(new MemberDTO("박철수", "010-3333-3333", 30));
		model.addAttribute("memList",memList);
		
		log.debug("문제없는지 확인");
		
		return "member/memberInfo";
	}
	/*에러 났을 때 : 1. 파일 위치, 이름 확인
	 * 			 2. import했을 때 개발자가 만든 주소로 됐는지 확인(MemberDTO)*/
}
