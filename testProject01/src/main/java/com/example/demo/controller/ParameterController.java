package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("param")
@Slf4j
public class ParameterController {

	@GetMapping("main")
	public String paramMain() {
		return "param/param-main";
		//폴더 param 안에 있는 param-main 파일 보기
	}
	
	@PostMapping("input")
	public String paramInput(HttpServletRequest req){
		String inputName = req.getParameter("inputName");
		int inputAge = Integer.parseInt(req.getParameter("inputAge"));
		//String에서 int로 형변환
		String inputAddress = req.getParameter("inputAddress");
		
		System.out.println("이름 확인 : " + inputName);
		System.out.println("나이 확인 : " + inputAge);
		System.out.println("주소 확인 : " + inputAddress);
		
		log.info("접속 확인");
		log.info("이름 확인 : " + inputName);
		log.info("나이 확인 : " + inputAge);
		log.info("주소 확인 : " + inputAddress);
		
		log.info("----------------------------------");
		log.debug("이름 확인 : " + inputName);
		log.debug("나이 확인 : " + inputAge);
		log.debug("주소 확인 : " + inputAddress);
		
		return "redirect:/param/main";
		//작성 다 되면 메인으로 돌아가기
	}
}
