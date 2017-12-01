package uk.ac.belfastmet.springdwarvesdwarfs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/tolkienPage")
	public String goToTolkienPage() {
	    return "tolkienPage";
	}
	
	@RequestMapping(value = "/disneyPage")
	public String goToDisneyPage() {
	    return "disneyPage";
	}
	

}
