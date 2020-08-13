package uk.ac.belfastmet.springbuildings.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.ac.belfastmet.springbuildings.service.BuildingService;

@Controller
@RequestMapping("/floorArea")
public class FloorAreaController {

	@Autowired
	private BuildingService buildingService;

	@GetMapping("")
	public String disney(Model model) {
		model.addAttribute("pageTitle", "Floor Area!");
		this.buildingService = new BuildingService();
		model.addAttribute("buildingFloorArea", this.buildingService.getBuildingFloorArea());
		return "floorArea";
	}

}