package uk.ac.belfastmet.springbuildings.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.ac.belfastmet.springbuildings.service.BuildingService;

@Controller
@RequestMapping("/footprint")
public class FootprintController {

	@Autowired
	private BuildingService buildingService;

	@GetMapping("")
	public String tolkien(Model model) {
		model.addAttribute("pageTitle", "Footprint!");
		this.buildingService = new BuildingService();
		model.addAttribute("BF", this.buildingService.getBuildingFootprint());
		return "footprint";
	}

}
