package main.java.org;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;  

public class Main {
	private static ClinicCalender calender = new ClinicCalender();
	public static void main(String args) {
		Doctor doc=new Doctor("Maria","MBBS,MD");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ses = sf.openSession();
		Transaction tx=ses.beginTransaction();	
		ses.save(doc);
		
		Logger logger = LoggerFactory.getLogger("patientAppointment");
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			
			System.out.println("Enter your choice from the given options:\n");
			System.out.println("1.Add a patient appointment");
			System.out.println("2.View all appointments\n");
			ch = sc.nextInt();
			Date date2;
			switch(ch) {
			case 1:
				System.out.println("Enter the following details");
				
				System.out.println("Enter the patient name");
				String name = sc.next();
				
				System.out.println("Enter the date of appointment in dd-M-yyyy");
				String d = sc.next();
				if(d.matches("([0-9]{2})-([A-Z][a-z]{3})-([0-9]{4})")) {
					logger.info("The date entered in right format");
				}
				else {
					logger.error("The date format is not as specified");
					System.out.println("Wrong date format");
					break;
				}
				
				System.out.println("Enter the time in hh:mm");
				String tme = sc.next();
				if(tme.matches("([0-9]{2}):([0-9]{2})")) {
					logger.info("The time entered in right format");
				}
				else {
					logger.error("The time format is not as specified");
					System.out.println("Wrong time format");
					break;
				}
				
				System.out.println("Name of doctor");
				String dname=sc.next();
				
				PatientAppointment p = new PatientAppointment(name,d,tme,dname);
				calender.addAppointment(p);
				break;
				
			case 2:
				List<PatientAppointment> plist = calender.viewAllAppointment();
				for(PatientAppointment pa: plist) {
					System.out.println(pa);
				}
				break; 
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Enter the right choice");
			}
			sc.close();
		}while(ch!=3);
	}
}
