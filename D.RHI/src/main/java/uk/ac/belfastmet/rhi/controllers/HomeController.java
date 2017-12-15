package uk.ac.belfastmet.rhi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uk.ac.belfastmet.rhi.domain.Beneficiaries;
import uk.ac.belfastmet.rhi.repositories.BeneficiariesRepository;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	BeneficiariesRepository benRepo;

	public HomeController(BeneficiariesRepository benRepo) {
		super();
		this.benRepo = benRepo;
	}

	@GetMapping("")
	public String allBeneficiariess(Model model) {
		model.addAttribute("pageTitle", "Beneficiaries!");
		model.addAttribute("Beneficiaries", this.benRepo.findAll());
		return "beneficiaries";
	}

	@PostMapping("/Search")
	public String search(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("Beneficiaries", this.benRepo.findByNameContaining(name));
		return "beneficiaries";
	}

	@GetMapping("/Search")
	public String getSearch(Model model) {
		model.addAttribute("name", "waffles");
		return "beneficiariesSearch";
	}

	@GetMapping("/View/{beneficiariesId}")
	public String getBeneficiariess(@PathVariable("beneficiariesId") Integer beneficiariesId, Model model) {
		model.addAttribute("pageTitle", "View Beneficiaries");
		model.addAttribute("Beneficiaries", this.benRepo.findOne(beneficiariesId));
		return "beneficiariesView";
	}

	@GetMapping("/Edit/{beneficiariesId}")
	public String editBeneficiaries(@PathVariable("beneficiariesId") Integer beneficiariesId, Model model) {
		model.addAttribute("pageTitle", "Edit Beneficiaries");
		model.addAttribute("Beneficiaries", this.benRepo.findOne(beneficiariesId));
		return "beneficiariesEdit";
	}

	@PostMapping("/Save")
	public String saveBeneficiaries(@Valid Beneficiaries passenger, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "beneficiariesEdit";
		} else {
			Beneficiaries savedBeneficiaries = benRepo.save(passenger);
			return "redirect:/View/" + savedBeneficiaries.getBeneficiariesId();
		}
	}

	@GetMapping("/Add")
	public String createBeneficiaries(Model model) {
		model.addAttribute("page title", "Add");
		model.addAttribute("Beneficiaries", new Beneficiaries());
		return "beneficiariesEdit";
	}

	@GetMapping("/Delete/{beneficiariesId}")
	public String deleteBeneficiaries(@PathVariable("beneficiariesId") Integer beneficiariesId, RedirectAttributes redirectAttrs) {
		benRepo.delete(beneficiariesId);
		redirectAttrs.addFlashAttribute("message", "Beneficiaries was deleted");
		return "redirect:/";
	}

}
