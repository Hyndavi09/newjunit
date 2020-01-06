package com.mindtree.hospitalkalingamanagementsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	private String patientName;
	private double patientBillAmount;
	@ManyToOne
	@JsonIgnoreProperties("patient")
	private Doctor doctor;
	public Patient() {
		super();
		
	}
	public Patient(int patientId, String patientName, double patientBillAmount, Doctor doctor) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientBillAmount = patientBillAmount;
		this.doctor = doctor;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public double getPatientBillAmount() {
		return patientBillAmount;
	}
	public void setPatientBillAmount(double patientBillAmount) {
		this.patientBillAmount = patientBillAmount;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientBillAmount="
				+ patientBillAmount + ", doctor=" + doctor + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		long temp;
		temp = Double.doubleToLongBits(patientBillAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + patientId;
		result = prime * result + ((patientName == null) ? 0 : patientName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (doctor == null) {
			if (other.doctor != null)
				return false;
		} else if (!doctor.equals(other.doctor))
			return false;
		if (Double.doubleToLongBits(patientBillAmount) != Double.doubleToLongBits(other.patientBillAmount))
			return false;
		if (patientId != other.patientId)
			return false;
		if (patientName == null) {
			if (other.patientName != null)
				return false;
		} else if (!patientName.equals(other.patientName))
			return false;
		return true;
	}
	
}
