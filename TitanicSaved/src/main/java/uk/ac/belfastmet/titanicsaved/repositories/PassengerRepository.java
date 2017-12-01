package uk.ac.belfastmet.titanicsaved.repositories;

import org.springframework.data.repository.CrudRepository;

import uk.ac.belfastmet.titanicsaved.domain.Passenger;

public interface PassengerRepository extends CrudRepository<Passenger, Integer> {

}
