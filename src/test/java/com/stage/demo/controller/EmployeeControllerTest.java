package com.stage.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.stage.demo.model.EmployeEntity;
import com.stage.demo.repository.EmployeeRepository;
import com.stage.demo.service.EmployeeService;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("Controller_test")
@TestPropertySource(locations = "classpath:application.properties")

class EmployeeControllerTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeController employeeController;

	@MockBean
	private EmployeeService employeeService;

	@SuppressWarnings("unused")
	private MockMvc mockMvc;

	@BeforeEach
	public void setup() throws Exception {
		MockitoAnnotations.openMocks(this);
		EmployeeController controller = new EmployeeController();
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@AfterEach
	public void tearDown() {
		employeeRepository.deleteAll();
	}

	@Test
	public void AddEmployee_OK() {

		// given
		EmployeEntity expectedEmploye = new EmployeEntity();
		expectedEmploye.setName("Jamila");
		expectedEmploye.setLastName("choufri");
		when(employeeService.save(any(EmployeEntity.class))).thenReturn(expectedEmploye);

		// when
		ResponseEntity<String> returnedEmploye = employeeController.AddEmployee(expectedEmploye);

		// then
		assertNotNull(returnedEmploye);
		assertEquals("Employee Added Successfully ", returnedEmploye.getBody());

	}

	@Test
	public void getALLEmployees_OK() {

		// given
		EmployeEntity expectedEmploye = new EmployeEntity();
		expectedEmploye.setName("Jamila");
		expectedEmploye.setLastName("choufri");
		List<EmployeEntity> expectedListEmploye = new ArrayList<>();
		expectedListEmploye.add(expectedEmploye);
		when(employeeService.getAllEmpl()).thenReturn(expectedListEmploye);

		// when
		ResponseEntity<List<EmployeEntity>> returnedEmploye = employeeController.getALLEmployees();

		// then
		assertNotNull(returnedEmploye);
		assertEquals(expectedListEmploye, returnedEmploye.getBody());

	}

	@Test
	public void delete_OK() {

		// given
		EmployeEntity expectedEmploye = new EmployeEntity();
		expectedEmploye.setName("Jamila");
		expectedEmploye.setLastName("choufri");
		when(employeeService.delete(expectedEmploye)).thenReturn("SUCCESS");

		// when
		ResponseEntity<String> returnedResponse = employeeController.delete(expectedEmploye);

		// then
		assertEquals("EmployeeDeleted", returnedResponse.getBody());

	}

}
