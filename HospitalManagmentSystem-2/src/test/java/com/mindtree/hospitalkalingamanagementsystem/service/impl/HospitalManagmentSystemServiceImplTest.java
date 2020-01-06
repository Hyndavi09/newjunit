package com.mindtree.hospitalkalingamanagementsystem.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.hospitalkalingamanagementsystem.HospitalKalingaManagmentSystemApplication;
import com.mindtree.hospitalkalingamanagementsystem.entity.Doctor;
import com.mindtree.hospitalkalingamanagementsystem.entity.dto.DoctorDto;
import com.mindtree.hospitalkalingamanagementsystem.repository.DoctorRepository;
import com.mindtree.hospitalkalingamanagementsystem.service.HospitalManagmentSystemService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = HospitalKalingaManagmentSystemApplication.class)
public class HospitalManagmentSystemServiceImplTest {

	@Mock
	DoctorRepository doctorRepository;
	@InjectMocks
	HospitalManagmentSystemService service = new HospitalManagmentSystemServiceImpl();

	ModelMapper modelMapper = new ModelMapper();
//	@Test
//	public void testModelMapper() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAssignDoctorToPatient() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testDisplayDoctorsBasedOnSalary() {
		List<Doctor> doctors = new ArrayList<Doctor>();
		Doctor doctor = new Doctor();
		doctor.setDoctorId(1);
		doctor.setSalary(2000);
		doctors.add(doctor);
		when(doctorRepository.findAll()).thenReturn(doctors);
		List<Doctor> doctorList = doctors.stream()
				.sorted((doctor1, doctor2) -> doctor1.getSalary() - doctor2.getSalary()).collect(Collectors.toList());

		List<DoctorDto> doctorDtos = doctorList.stream().map(i -> modelMapper.map(i, DoctorDto.class))
				.collect(Collectors.toList());
		// System.out.println(doctorDtos.get(0).getDoctorId());
		List<DoctorDto> doctorDtos1 = this.service.displayDoctorsBasedOnSalary();
		// System.out.println(doctorDtos1.get(0).getDoctorId());
		assertEquals(doctorDtos.get(0).getDoctorId(), doctorDtos1.get(0).getDoctorId());
	}

//	@Test
//	public void testDisplayAllDoctorBasedOnCount() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDispayInExcelSheet() {
//		fail("Not yet implemented");
//	}

}
