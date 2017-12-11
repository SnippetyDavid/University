package uk.ac.belfastmet.breakfastcereal.repositories;

import org.springframework.data.repository.CrudRepository;

import uk.ac.belfastmet.breakfastcereal.domain.Cereal;

public interface CerealRepository extends CrudRepository<Cereal, Integer> {

}
