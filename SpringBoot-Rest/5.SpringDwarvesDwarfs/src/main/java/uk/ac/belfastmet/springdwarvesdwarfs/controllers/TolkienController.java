package uk.ac.belfastmet.springdwarvesdwarfs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.ac.belfastmet.springdwarvesdwarfs.service.DwarfService;

@Controller
@RequestMapping("/tolkienPage")
public class TolkienController {

	@Autowired
	private DwarfService dwarfService;

	@GetMapping("")
	public String tolkien(Model model) {
		model.addAttribute("pageTitle", "Tolkien!");
		this.dwarfService = new DwarfService();
		model.addAttribute("Dwarfs", this.dwarfService.getTolkienDwarfs());
		return "tolkienPage";
	}

}
