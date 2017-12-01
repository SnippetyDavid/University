package uk.ac.belfastmet.titanicsaved.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.ac.belfastmet.titanicsaved.repositories.PassengerRepository;

@Controller
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	PassengerRepository passengerRepo;

	public PassengerController(PassengerRepository passengerRepo) {
		super();
		this.passengerRepo = passengerRepo;
	}

	@GetMapping("")
	public String tolkien(Model model) {
		model.addAttribute("pageTitle", "Passengers!");
		model.addAttribute("Passengers", this.passengerRepo.findAll());
		return "passenger";
	}

}
