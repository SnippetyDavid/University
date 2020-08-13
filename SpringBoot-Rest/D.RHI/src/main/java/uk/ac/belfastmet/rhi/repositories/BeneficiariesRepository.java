package uk.ac.belfastmet.rhi.repositories;

import org.springframework.data.repository.CrudRepository;

import uk.ac.belfastmet.rhi.domain.Beneficiaries;

public interface BeneficiariesRepository extends CrudRepository<Beneficiaries, Integer> {

	Iterable<Beneficiaries> findByNameContaining(String name);



}
