package main.java.org;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientAppointment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pid;
	private String name;
	private String date;
	private String time;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="DoctorName")
	private String doctor;
	public PatientAppointment(String name, String d, String time, String doctor) {
		super();
		this.name = name;
		this.date = d;
		this.time = time;
		this.doctor = doctor;
	}
	
}
