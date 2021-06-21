package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Flight;
import com.cts.entity.Passenger;
import com.cts.repository.IFlightRepository;

@Service("fliService")
public class FlightService {
	
	@Autowired
	private IFlightRepository repo;
	
	public boolean addPassenger(Passenger p,Flight f) {
		if(f.getFlightType().equalsIgnoreCase("business")) {
			if(!p.isVip())
				return false;	
		}
		List<Passenger> plist = f.getPassengers();
		plist.add(p);
		return true;
		
	}
	public boolean removePassenger(Passenger p,Flight f) {
		if(p.isVip()) {
			List<Passenger> plist = f.getPassengers();
			plist.remove(p);
			return true;
		}
		else
			return false;
			
	}
}
