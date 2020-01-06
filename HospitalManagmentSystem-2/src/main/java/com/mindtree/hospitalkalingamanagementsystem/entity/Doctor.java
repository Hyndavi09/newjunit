package com.mindtree.hospitalkalingamanagementsystem.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Doctor implements Comparable<Doctor> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctorId;
	private String doctorName;
	private int yearOfExperience;
	private int salary;
	@OneToMany(mappedBy = "doctor")
	@JsonIgnoreProperties("doctor")
	private Set<Patient> patient;

	public Doctor(int doctorId, String doctorName, int yearOfExperience, int salary, Set<Patient> patient) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.yearOfExperience = yearOfExperience;
		this.salary = salary;
		this.patient = patient;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int d) {
		this.salary = d;
	}

	public Doctor() {
		super();
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public int getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(int yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	public Set<Patient> getPatient() {
		return patient;
	}

	public void setPatient(Set<Patient> patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", yearOfExperience=" + yearOfExperience
				+ ", patient=" + patient + "]";
	}

	@Override
	public int compareTo(Doctor arg0) {
		return this.doctorName.compareTo(arg0.doctorName);
	}

}
