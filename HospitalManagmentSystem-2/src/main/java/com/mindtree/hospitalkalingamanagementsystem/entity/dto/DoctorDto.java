package com.mindtree.hospitalkalingamanagementsystem.entity.dto;

import java.util.Set;

public class DoctorDto {

	private int doctorId;
	private String doctorName;
	private int yearOfExperience;

	private int salary;
	private Set<PatientDto> patient;

	public DoctorDto() {
		super();

	}

	public DoctorDto(int doctorId, String doctorName, int yearOfExperience, int salary, Set<PatientDto> patient) {
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

	public void setSalary(int salary) {
		this.salary = salary;
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

	public Set<PatientDto> getPatient() {
		return patient;
	}

	public void setPatient(Set<PatientDto> patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "DoctorDto [doctorId=" + doctorId + ", doctorName=" + doctorName + ", yearOfExperience="
				+ yearOfExperience + ", patient=" + patient + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + doctorId;
		result = prime * result + ((doctorName == null) ? 0 : doctorName.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		result = prime * result + yearOfExperience;
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
		DoctorDto other = (DoctorDto) obj;
		if (doctorId != other.doctorId)
			return false;
		if (doctorName == null) {
			if (other.doctorName != null)
				return false;
		} else if (!doctorName.equals(other.doctorName))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		if (yearOfExperience != other.yearOfExperience)
			return false;
		return true;
	}

}
