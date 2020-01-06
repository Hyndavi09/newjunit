package com.mindtree.hospitalkalingamanagementsystem.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.hospitalkalingamanagementsystem.entity.Doctor;
import com.mindtree.hospitalkalingamanagementsystem.entity.Patient;
import com.mindtree.hospitalkalingamanagementsystem.service.HospitalManagmentSystemService;

@WebMvcTest(HospitalManagmentSystemController.class)
public class HospitalManagmentSystemControllerTest {
	@Mock
	HospitalManagmentSystemService service;

	@InjectMocks
	HospitalManagmentSystemController controller;
	@Autowired
	MockMvc mockMvc;

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testAssign() throws Exception {
		Patient patient = new Patient();
		patient.setPatientId(1);
		patient.setPatientName("bhuva");
		Doctor doctor = new Doctor();
		doctor.setDoctorId(1);
		doctor.setDoctorName("bhuvana");
		Mockito.when(service.assignDoctorToPatient("bhuvana", "bhuva")).thenReturn(patient);
		mockMvc.perform(MockMvcRequestBuilders.post("/assign/bhuvana/bhuva").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(patient)).accept(MediaType.APPLICATION_JSON))

				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testGetAll() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getall").accept(MediaType.APPLICATION_JSON))

				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void getAllCount() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/displaycount").accept(MediaType.APPLICATION_JSON))

				.andExpect(MockMvcResultMatchers.status().isOk());
	}

//	@Test
//	public void writeToFile()
//	{
//		
//	}
}
