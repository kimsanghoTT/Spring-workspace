package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.dto.Clothes;
import com.khmall.service.ClothesService;

@Controller
public class ClothesController {

	@Autowired
	private ClothesService clothesService;
	
	@GetMapping("/")
	public String getAllClothes(Model model) {
		
		List<Clothes> clothesList = clothesService.getAllClothes();
		model.addAttribute("clothesList",clothesList);
		
		return "index";
	}
	@GetMapping("/clothesUpload") //html 파일과 java 파일이 만나는 지점
	public String uploadForm(Model model) {
		model.addAttribute("c", new Clothes()); //db에 올릴 수 있는 공간 생성
		return "clothesUpload"; // html 파일 이름
	}
	

	@PostMapping("/clothesUploading")
	public String uploadClothes(
			@RequestParam("clothes_name") String clothes_name,
			@RequestParam("clothes_price") int clothes_price,
			@RequestParam("clothes_category") String clothes_category,
			@RequestParam("clothes_image_path") MultipartFile file,
			Model model) {
		clothesService.uploadClothes(clothes_name, clothes_price, clothes_category, file);
		
		return "redirect:/";
	}
	
}
