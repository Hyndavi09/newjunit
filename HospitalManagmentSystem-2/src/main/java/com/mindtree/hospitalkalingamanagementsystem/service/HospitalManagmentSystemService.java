package com.mindtree.hospitalkalingamanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.hospitalkalingamanagementsystem.entity.Doctor;
import com.mindtree.hospitalkalingamanagementsystem.entity.Patient;
import com.mindtree.hospitalkalingamanagementsystem.entity.dto.DoctorDto;
import com.mindtree.hospitalkalingamanagementsystem.exception.service.ServiceException;
@Service
public interface HospitalManagmentSystemService {
public Patient assignDoctorToPatient(String doctorName,String patientName) throws ServiceException;
public List<DoctorDto> displayDoctorsBasedOnSalary();
public List<DoctorDto> displayAllDoctorBasedOnCount();
public String dispayInExcelSheet();
}
