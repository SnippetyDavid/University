package uk.ac.belfastmet.htmlforms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "form";
	}

	@GetMapping("/result")
	public String result( Model model) {
		model.addAttribute("firstName","Dr");
		model.addAttribute("lastName", "Waffles");
		model.addAttribute("gender", "Waffle");
		return "result";
	}

	@PostMapping("/result")
	public String getResult(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName, @RequestParam("gender") String gender, Model model) {
		model.addAttribute("firstName",firstName);
		model.addAttribute("lastName",lastName);
		model.addAttribute("gender",gender);
		return "result";
	}
}
