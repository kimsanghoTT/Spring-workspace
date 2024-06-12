package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	
	@PostMapping("input2")
	public String paramInput2(@RequestParam("snackName") String snackName,
		@RequestParam("snackCompany") String snackCompay, 
		@RequestParam("snackPrice") int snackPrice,
		@RequestParam(value="snackLike", defaultValue="snackLike", required=false) String snackLike
	) {
		/*		
		과자 이름 : <input type="text" name="snackName">
		제조사 : <input type="text" name="snackCompany">
		가격 : <input type="number" name="snackPrice">
		선호도 : <input type="text" name="snackLike">*/
		log.info("snackName : " + snackName);
		log.info("snackCompay : " + snackCompay);
		log.info("snackPrice : " + snackPrice);
		log.info("snackLike : " + snackLike);
		
		return "redirect:/param/main";
	}
	
	@PostMapping("favoriteSnackCompany")
	public String paramInput3(@RequestParam(value="favoriteSnack", required=false) String[] favoriteSnack,
			@RequestParam(value="favoriteCompany", required=false) List<String> favoriteCompany
	) {
		log.info(Arrays.toString(favoriteSnack));
		log.info("favoriteCompany : " + favoriteCompany);
		
		return "redirect:/param/main";
	}
}
