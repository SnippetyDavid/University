package uk.ac.belfastmet.rhi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uk.ac.belfastmet.rhi.domain.Beneficiaries;
import uk.ac.belfastmet.rhi.service.BeneficiariesRestService;

@RestController
@RequestMapping("/api/Beneficiaries")
public class BeneficiariesRestController {
	
	@Autowired
	BeneficiariesRestService beneficiariesRestService;
	
	public BeneficiariesRestController(BeneficiariesRestService beneficiariesRestService) {
		super();
		this.beneficiariesRestService = beneficiariesRestService;
	}

	@GetMapping("")
	public Iterable<Beneficiaries> list(){
		return beneficiariesRestService.list();
	}

	@PostMapping("/")
	public Beneficiaries create(@RequestBody Beneficiaries beneficiaries){
		return beneficiariesRestService.create(beneficiaries);
	}

	@GetMapping("/{beneficiariesId}")
	public Beneficiaries read(@PathVariable("beneficiariesId") Integer beneficiariesId){
		return beneficiariesRestService.read(beneficiariesId);
	}
	
	
	@PutMapping("/{beneficiariesId}")
	public Beneficiaries update(@PathVariable("beneficiariesId") Integer beneficiariesId, @RequestBody Beneficiaries beneficiaries ){
		return beneficiariesRestService.update(beneficiariesId, beneficiaries);
	}

	@DeleteMapping("/{beneficiariesId}")
	public void delete(@PathVariable("beneficiariesId") Integer beneficiariesId){
		beneficiariesRestService.delete(beneficiariesId);
	}
}
