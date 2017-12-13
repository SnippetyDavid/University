package uk.ac.belfastmet.springdwarvesdwarfssaved.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.ac.belfastmet.springdwarvesdwarfssaved.repositories.DwarfRepository;

//import uk.ac.belfastmet.springdwarvesdwarfs.service.DwarfService;

@Controller
@RequestMapping("/tolkienPage")
public class TolkienController {

//	@Autowired
//	private DwarfService dwarfService;
	@Autowired
	DwarfRepository dwarfRepository;
	
	

	public TolkienController(DwarfRepository dwarfRepository) {
	super();
	this.dwarfRepository = dwarfRepository;
}



	@GetMapping("")
	public String tolkien(Model model) {
		model.addAttribute("pageTitle", "Tolkien!");
//		this.dwarfService = new DwarfService();
		model.addAttribute("Dwarfs", this.dwarfRepository.findByAuthorOrName("Disney","Thorin"));
		return "tolkienPage";
	}

}
