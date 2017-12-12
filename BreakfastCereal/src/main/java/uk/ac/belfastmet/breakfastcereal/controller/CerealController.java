package uk.ac.belfastmet.breakfastcereal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.ac.belfastmet.breakfastcereal.domain.Cereal;
import uk.ac.belfastmet.breakfastcereal.repositories.CerealRepository;

@Controller
@RequestMapping("/Cereal")
public class CerealController {
	
	@Autowired
	CerealRepository cerealRepo;

	public CerealController(CerealRepository cerealRepo) {
		super();
		this.cerealRepo = cerealRepo;
	}
	
	@GetMapping("/View/{cerealId}")
	public String getCereals(@PathVariable("cerealId") Integer cerealId, Model model) {
		model.addAttribute("pageTitle", "View Cereal");
		model.addAttribute("Cereals", this.cerealRepo.findOne(cerealId));
		return "cerealView";
	}
	
	@GetMapping("/Edit/{cerealId}")
	public String editCereal(@PathVariable("cerealId") Integer cerealId, Model model) {
		model.addAttribute("pageTitle", "Edit Cereal");
		model.addAttribute("Cereals", this.cerealRepo.findOne(cerealId));
		return "cerealEdit";	}
	
	@GetMapping("/Add")
	public String createCereal(Model model) {
		model.addAttribute("page title","Add");
		model.addAttribute("cereal", new Cereal());
		return "cerealEdit";
	}
	
	@GetMapping("/Delete/{cerealId}")
	public String deleteCereal(@PathVariable("cerealId") Integer cerealId) {
		cerealRepo.delete(cerealId);
		return "redirect:/";
	}
	
	@PostMapping("/Save")
	public String saveCereal(@Valid Cereal cereal, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "cerealEdit";
		} else { 
		Cereal savedCereal = cerealRepo.save(cereal);
		return "redirect:/Cereal/View/" + savedCereal.getCerealId();
		}
	}
	
}
