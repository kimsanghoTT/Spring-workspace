package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.khmall.dto.Pig;
import com.khmall.service.PigService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class PigController {
	
	@Autowired
	private PigService pigService;
	
	@GetMapping("/pigAllList")
	public String getAllpig(Model model) {
	    List<Pig> pigs = pigService.getAllPig();
	    model.addAttribute("pigs", pigs);
	    
	    return "pigAllList";
	}
	
	@GetMapping("/pigDetail/{pig_id}")
	public String getPigById(Model model, @PathVariable int pig_id) {
			Pig pig = pigService.getPigById(pig_id);
			model.addAttribute(pig);
			return "pigDetail";
	}
	
	@GetMapping("/imgUpload")
	public String uploadPig(Model model) {
		model.addAttribute("p", new Pig());
		return "imgUpload";
	}

	@PostMapping("/imgUpload")
	public String uploadPig(
			@RequestParam ("pig_name") String pig_name,
			@RequestParam ("pig_age") int pig_age,
			@RequestParam ("pig_image_path") MultipartFile file,
			Model model
			) {
		pigService.uploadPig(pig_name, pig_age, file);
		
		return "redirect:/pigAllList";
		//업로드 후 이동하고자 하는 경로
	}

	
}
