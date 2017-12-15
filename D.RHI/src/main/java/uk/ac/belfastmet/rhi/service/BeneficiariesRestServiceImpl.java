package uk.ac.belfastmet.rhi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.ac.belfastmet.rhi.domain.Beneficiaries;
import uk.ac.belfastmet.rhi.repositories.BeneficiariesRepository;

@Service
public class BeneficiariesRestServiceImpl implements BeneficiariesRestService {

	@Autowired
	private BeneficiariesRepository benRepo;
	
	@Override
	public Iterable<Beneficiaries> list() {
		return this.benRepo.findAll();
	}

	@Override
	public Beneficiaries create(Beneficiaries beneficiaries) {
		return this.benRepo.save(beneficiaries);
	}

	@Override
	public Beneficiaries read(Integer beneficiariesId) {
		return this.benRepo.findOne(beneficiariesId);
	}

	@Override
	public Beneficiaries update(Integer beneficiariesId, Beneficiaries beneficiaries) {
		Beneficiaries beneficiariesToUpdate =  this.benRepo.findOne(beneficiariesId);
		return this.benRepo.save(beneficiariesToUpdate);
	}

	@Override
	public void delete(Integer beneficiariesId) {
		this.benRepo.delete(beneficiariesId);
	}

}
