package main.java.org;

import java.util.List;


public class ClinicCalender {	
	private List<PatientAppointment> appList;
	
	public String addAppointment(PatientAppointment p) {
		Boolean val = appList.add(p);
		if(val)
			return "Appointment booked!!";
		else
			return "Booking Failed!!";
	}
	
	public  List<PatientAppointment> viewAllAppointment(){
		return appList;
	}
	
}
