package uk.ac.belfastmet.titanicsaved.service;

import uk.ac.belfastmet.titanicsaved.domain.Passenger;

public interface PassengerRestService {

	Iterable<Passenger> list();
	
	Passenger create(Passenger passenger);
	
	Passenger read(Integer passengerId);
	
	Passenger update(Integer passengerId, Passenger passenger);
	
	void delete(Integer passengerId);
}
