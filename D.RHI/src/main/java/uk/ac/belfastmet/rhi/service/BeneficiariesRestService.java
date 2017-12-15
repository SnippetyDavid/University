package uk.ac.belfastmet.rhi.service;

import uk.ac.belfastmet.rhi.domain.Beneficiaries;

public interface BeneficiariesRestService {

	Iterable<Beneficiaries> list();
	
	Beneficiaries create(Beneficiaries beneficiaries);
	
	Beneficiaries read(Integer beneficiariesId);
	
	Beneficiaries update(Integer beneficiariesId, Beneficiaries beneficiaries);
	
	void delete(Integer beneficiariesId);
}
