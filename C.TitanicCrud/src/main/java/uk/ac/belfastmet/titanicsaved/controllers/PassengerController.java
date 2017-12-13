package uk.ac.belfastmet.titanicsaved.controllers;

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

import uk.ac.belfastmet.titanicsaved.domain.Passenger;
import uk.ac.belfastmet.titanicsaved.repositories.PassengerRepository;

@Controller
@RequestMapping("/Passenger")
public class PassengerController {

	@Autowired
	PassengerRepository passengerRepo;

	public PassengerController(PassengerRepository passengerRepo) {
		super();
		this.passengerRepo = passengerRepo;
	}

	@GetMapping("")
	public String allPassengers(Model model) {
		model.addAttribute("pageTitle", "Passengers!");
		model.addAttribute("Passengers", this.passengerRepo.findAll());
		return "passenger";
	}

	@PostMapping("/Search")
	public String search(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("Passengers", this.passengerRepo.findByNameContaining(name));
		return "passengerSearch";
	}

	@GetMapping("/Search")
	public String getSearch(Model model) {
		model.addAttribute("name", "waffles");
		return "passengerSearch";
	}

	@GetMapping("/View/{passengerId}")
	public String getPassengers(@PathVariable("passengerId") Integer passengerId, Model model) {
		model.addAttribute("pageTitle", "View Passenger");
		model.addAttribute("Passengers", this.passengerRepo.findOne(passengerId));
		return "passengerView";
	}

	@GetMapping("/Edit/{passengerId}")
	public String editPassenger(@PathVariable("passengerId") Integer passengerId, Model model) {
		model.addAttribute("pageTitle", "Edit Passenger");
		model.addAttribute("Passengers", this.passengerRepo.findOne(passengerId));
		return "passengerEdit";
	}

	@PostMapping("/Save")
	public String savePassenger(@Valid Passenger passenger, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "passengerEdit";
		} else {
			Passenger savedPassenger = passengerRepo.save(passenger);
			return "redirect:/Passenger/View/" + savedPassenger.getPassengerId();
		}
	}

	@GetMapping("/Add")
	public String createPassenger(Model model) {
		model.addAttribute("page title", "Add");
		model.addAttribute("Passengers", new Passenger());
		return "passengerEdit";
	}

	@GetMapping("/Delete/{passengerId}")
	public String deletePassenger(@PathVariable("passengerId") Integer passengerId, RedirectAttributes redirectAttrs) {
		passengerRepo.delete(passengerId);
		redirectAttrs.addFlashAttribute("message", "Passenger was deleted");
		return "redirect:/";
	}

	@GetMapping("/Survivors")
	public String survived(Model model) {
		model.addAttribute("pageTitle", "Passengers!");
		model.addAttribute("Passengers", this.passengerRepo.findBySurvived(1));
		return "passenger";
	}

	@GetMapping("/Dead")
	public String ded(Model model) {
		model.addAttribute("pageTitle", "Passengers!");
		model.addAttribute("Passengers", this.passengerRepo.findBySurvived(0));
		return "passenger";
	}

	@GetMapping("/FirstClass")
	public String firstClass(Model model) {
		model.addAttribute("pageTitle", "Passengers!");
		model.addAttribute("Passengers", this.passengerRepo.findByPClass(1));
		return "passenger";
	}

}
