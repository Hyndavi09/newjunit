package com.mindtree.hospitalkalingamanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.hospitalkalingamanagementsystem.entity.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{

	Patient findByPatientName(String patientName);

	boolean existsByPatientName(String patientName);

}
