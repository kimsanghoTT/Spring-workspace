package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.dto.Pig;
import com.khmall.service.PigService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PigController {
	
	@Autowired
	private PigService pigService;
	
	@GetMapping("/")
	public String getAllPigs(Model model) {
		
		List<Pig> pigList = pigService.getAllPigs();
		model.addAttribute("pigList", pigList);
		
		return "index";
	}
	
	/*
	// application.properties에 error경로를 지정하고 설정에서 지정된 경로를 찾아 발생
	@RequestMapping("/error")
	public String getError() {
		return "error";
	}
	*/
	
	@GetMapping("/pigDetail/{pig_id}")
	public String getPigById(Model model, @PathVariable int pig_id) {
		
		Pig pig = pigService.getPigById(pig_id);
		model.addAttribute("pig",pig);
		return "pigDetail";
	}
	// 돼지 정보를 올릴 수 있는 주소로 이동할 수 있는 GetMapping
	@GetMapping("/imgUpload") //html 파일과 java 파일이 만나는 지점
	public String uploadForm(Model model) {
		model.addAttribute("p", new Pig()); //db에 올릴 수 있는 공간 생성
		return "imgUpload"; // html 파일 이름
	}
	
	
	//돼지 정보 db에 업로드 PostMapping
	@PostMapping("/upload")
	public String uploadPig(
			//@RequstParam을 읽어서 파일을 하나씩 가져오기 설정
			@RequestParam("pig_name") String pig_name,
			@RequestParam("pig_age") int pig_age,
			@RequestParam("pig_image_path") MultipartFile file,
			
			Model model) { 
		
		pigService.uploadPig(pig_name, pig_age, file);
		
		log.info("pigUpload 확인");
		
		return "redirect:/"; // upload 완료되면 메인 페이지로 이동해서 등록됐는지 확인
		
		/*  
		redirect:/  와 index만 넣었을 때 차이
		
		redirect:/ : 사용자가 새로운 url로 다시 요청하도록 지시
		-> react로 작성하고 나서 값을 전달할 때 주로 사용할 예정
		
		index : html 파일 이름
		
		 */
	}
	
	
	
}
