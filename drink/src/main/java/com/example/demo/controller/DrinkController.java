package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Drink;
import com.example.demo.service.DrinkService;

@Controller
public class DrinkController {

	@GetMapping("/")
	public String registerForm(Model model) {
		model.addAttribute("drink", new Drink());
		return "index";
	}
	
	@Autowired
	private DrinkService drinkService;
	
	@PostMapping("/drink-register")
	public String insertDrink(Drink drink, Model model) {
		
		drinkService.insertDrink(drink);
		model.addAttribute("msg", "음료가 등록되었습니다");
		
		return "successDrink";
	}
}