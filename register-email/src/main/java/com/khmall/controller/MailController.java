package com.khmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khmall.service.MailService;

import lombok.RequiredArgsConstructor;
/*
	자료형 앞에 final을 붙이는 이유 : 밑에서 변수명을 조작해서 회사에 문제가 생기는 것을 방지하기 위해
	final -> 상시적으로 값이 고정되기 때문
	
	@RequiredArgsConstructor : final로 작성된 필드를 도와주는 생성자
	
	@ResponseBody : Serivce.java에 작성한 html 파일(코드)에서 작성된 내용을 json형식으로 변환해서
	사용자에게 전달할 때 사용
*/
@Controller
@RequiredArgsConstructor
public class MailController {

	@Autowired
	private final MailService mailService;
	
	@GetMapping("/")
	public String MailPage() {
		return "index";
	}
	
	// 인증번호를 전송받은 값과 일치하는지 확인
	@ResponseBody
	@PostMapping("/mail")
	public String mailSend(String mail) {
		int number = mailService.sendMail(mail);
		String num = "" + number; //랜덤으로 생성된 숫자 가져오기
		
		//내가 전달받은 숫자가 맞는지 확인용으로 가져옴
		return num;
	}
}
