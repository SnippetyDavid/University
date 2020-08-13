package uk.ac.belfastmet.breakfastcereal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.ac.belfastmet.breakfastcereal.repositories.CerealRepository;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	CerealRepository cerealRepo;

	public IndexController(CerealRepository cerealRepo) {
		super();
		this.cerealRepo = cerealRepo;
	}
	
	@GetMapping("/")
	public String getCereals(Model model) {
		model.addAttribute("pageTitle", "Cereals");
		model.addAttribute("title", "Cereals");
		model.addAttribute("Cereals", this.cerealRepo.findByOrderByManufacturer());
		return "index";
	}
}
