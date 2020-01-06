package com.mindtree.hospitalkalingamanagementsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.mindtree.hospitalkalingamanagementsystem.entity.Doctor;
import com.mindtree.hospitalkalingamanagementsystem.entity.Patient;
import com.mindtree.hospitalkalingamanagementsystem.entity.dto.DoctorDto;
import com.mindtree.hospitalkalingamanagementsystem.exception.service.DoctorNameNotFoundException;
import com.mindtree.hospitalkalingamanagementsystem.exception.service.PatientNameNotFoundException;
import com.mindtree.hospitalkalingamanagementsystem.exception.service.ServiceException;
import com.mindtree.hospitalkalingamanagementsystem.repository.DoctorRepository;
import com.mindtree.hospitalkalingamanagementsystem.repository.PatientRepository;
import com.mindtree.hospitalkalingamanagementsystem.service.HospitalManagmentSystemService;

@Service
public class HospitalManagmentSystemServiceImpl implements HospitalManagmentSystemService {

	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	ModelMapper modelMapper;

	ModelMapper modelMapper2 = new ModelMapper();

	@Bean
	public ModelMapper ModelMapper() {
		return new ModelMapper();
	}

	int salary = 0;

	@Override
	public Patient assignDoctorToPatient(String doctorName, String patientName) throws ServiceException {
		if (!patientRepository.existsByPatientName(patientName)) {
			throw new PatientNameNotFoundException("PatientNotFound");
		}
		if (!doctorRepository.existsByDoctorName(doctorName)) {
			throw new DoctorNameNotFoundException("DoctorNotFound");
		}

		else {

			Patient patient = patientRepository.findByPatientName(patientName);
			Doctor doctor = doctorRepository.findByDoctorName(doctorName);
			doctor.setSalary((int) (doctor.getSalary() + patient.getPatientBillAmount()));
			patient.setDoctor(doctor);
			Patient patient2 = patientRepository.save(patient);
			return patient2;
		}

	}

	@Override
	public List<DoctorDto> displayDoctorsBasedOnSalary() {
		List<Doctor> doctor;
		doctor = doctorRepository.findAll();
		List<Doctor> doctorList = doctor.stream()
				.sorted((doctor1, doctor2) -> doctor1.getSalary() - doctor2.getSalary()).collect(Collectors.toList());
		return doctorList.stream().map(doc -> modelMapper2.map(doc, DoctorDto.class)).collect(Collectors.toList());
	}

	private DoctorDto ConvertDoctorDto(Doctor doctor) {

		return modelMapper.map(doctor, DoctorDto.class);
	}

	@Override
	public List<DoctorDto> displayAllDoctorBasedOnCount() {
		List<Doctor> doctors = doctorRepository.findAll();
		List<Doctor> doctorList = doctors.stream().filter(doctor -> doctor.getPatient().size() > 3)
				.sorted((doctor1, doctor2) -> doctor2.getYearOfExperience() - doctor1.getYearOfExperience())
				.collect(Collectors.toList());
		return doctorList.stream().map(doc -> ConvertDoctorDto(doc)).collect(Collectors.toList());
	}

	@Override
	public String dispayInExcelSheet() {
		List<Doctor> doctors = doctorRepository.findAll();
		@SuppressWarnings("resource")
		Workbook workbook = new XSSFWorkbook();
		@SuppressWarnings("unused")
		CreationHelper createHelper = workbook.getCreationHelper();
		Sheet sheet = workbook.createSheet("Hospital");
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		Row headerRow = sheet.createRow(0);
		int n = doctors.size();
		Doctor doctor = new Doctor();
		for (int i = 0; i < n; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(doctor.getDoctorId());
			cell.setCellValue(doctor.getDoctorName());
			cell.setCellValue(doctor.getSalary());
			cell.setCellValue(doctor.getYearOfExperience());
			cell.setCellStyle(headerCellStyle);
		}
		return null;

	}
}
