package uk.ac.belfastmet.titanicsaved.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.ac.belfastmet.titanicsaved.domain.Passenger;
import uk.ac.belfastmet.titanicsaved.repositories.PassengerRepository;


@Service
public class DataLoader {
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	public DataLoader(PassengerRepository passengerRepo) {
		super();
		this.passengerRepo = passengerRepo;
	}


}
