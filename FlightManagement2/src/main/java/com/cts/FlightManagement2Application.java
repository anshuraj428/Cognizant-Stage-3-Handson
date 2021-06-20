package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.entity.Flight;
import com.cts.entity.Passenger;
import com.cts.service.FlightService;

@SpringBootApplication
public class FlightManagement2Application {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(FlightManagement2Application.class, args);
		FlightService fs=(FlightService)ctx.getBean("fliService");
		boolean result=fs.addPassenger(new Passenger("maria",true), new Flight("f1","business"));
		System.out.println(result);
		
	}

}
