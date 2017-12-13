package uk.ac.belfastmet.springukcharts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.ac.belfastmet.springukcharts.service.SongService;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private SongService songService;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("pageTitle", "UK Top 10!");
		this.songService = new SongService();
		model.addAttribute("Songs", this.songService.getCharts());
		return "index";
	}
	

}