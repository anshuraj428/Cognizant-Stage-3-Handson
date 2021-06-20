package main.java.org;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int did;
	private String name;
	@Column(name="Qualification")
	private String qual;
	public Doctor(String name, String qual) {
		super();
		this.name = name;
		this.qual = qual;
	}
	
	
}
