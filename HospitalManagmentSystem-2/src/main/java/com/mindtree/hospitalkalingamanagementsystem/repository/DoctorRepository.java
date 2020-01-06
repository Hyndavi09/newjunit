package com.mindtree.hospitalkalingamanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.hospitalkalingamanagementsystem.entity.Doctor;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	Doctor findByDoctorName(String doctorName);

	boolean existsByDoctorName(String doctorName);

}
