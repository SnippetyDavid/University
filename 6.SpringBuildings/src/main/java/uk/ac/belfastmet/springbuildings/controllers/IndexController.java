package uk.ac.belfastmet.springbuildings.controllers;

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
	
	@RequestMapping(value = "/footprint")
	public String goToFootprintPage() {
	    return "footprint";
	}
	
	@RequestMapping(value = "/volume")
	public String goToVolumePage() {
	    return "volume";
	}
	
	@RequestMapping(value = "/floorArea")
	public String goToFloorAreaPage() {
	    return "floorArea";
	}
	

}
