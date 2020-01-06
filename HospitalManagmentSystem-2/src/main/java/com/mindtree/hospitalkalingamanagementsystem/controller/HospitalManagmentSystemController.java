package com.mindtree.hospitalkalingamanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.hospitalkalingamanagementsystem.entity.Patient;
import com.mindtree.hospitalkalingamanagementsystem.entity.dto.DoctorDto;
import com.mindtree.hospitalkalingamanagementsystem.exception.service.ServiceException;
import com.mindtree.hospitalkalingamanagementsystem.service.HospitalManagmentSystemService;

@RestController
public class HospitalManagmentSystemController {

	@Autowired
	HospitalManagmentSystemService hospitalManagmentSystemService;

	@PostMapping(value = "/assign/{doctorName}/{patientName}")
	public Patient assign(@PathVariable(name = "doctorName") String doctorName,
			@PathVariable(name = "patientName") String patientName) throws ServiceException {
		return hospitalManagmentSystemService.assignDoctorToPatient(doctorName, patientName);

	}

	@GetMapping(value = "/getall")
	public List<DoctorDto> getAll() {
		return hospitalManagmentSystemService.displayDoctorsBasedOnSalary();
	}

	@GetMapping(value = "/displaycount")
	public List<DoctorDto> getAllCount() {
		return hospitalManagmentSystemService.displayAllDoctorBasedOnCount();
	}

	@GetMapping(value = "/writetofile")
	public String writeToFile() {
		return hospitalManagmentSystemService.dispayInExcelSheet();
	}
}
