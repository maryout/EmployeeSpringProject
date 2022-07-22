package com.stage.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import com.stage.demo.model.EmployeEntity;
import com.stage.demo.repository.EmployeeRepository;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application.properties")
class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepository employeeRepository;

	@AfterEach
	public void tearDown() {
		employeeRepository.deleteAll();
	}

	@Test
	public void saveEmployeeTest_OK() {

		// given

		EmployeEntity expecetedEmployee = new EmployeEntity();
		expecetedEmployee.setName("Muspha");
		expecetedEmployee.setLastName("mohjj");
		expecetedEmployee.setEmail("Muspha@gmail.com");

		// when
		EmployeEntity savedEmployee = employeeService.save(expecetedEmployee);

		// then
		assertNotNull(savedEmployee);
		assertNotNull(savedEmployee.getId());
		assertEquals(expecetedEmployee.getName(), savedEmployee.getName());
		assertEquals(expecetedEmployee.getLastName(), savedEmployee.getLastName());
		assertEquals(expecetedEmployee.getEmail(), savedEmployee.getEmail());

	}

	@Test
	public void getAllTest_OK() {

		// given
		EmployeEntity expecetedEmployee = new EmployeEntity();
		EmployeEntity expecetedEmployee2 = new EmployeEntity();
		expecetedEmployee.setName("Muspha");
		expecetedEmployee.setLastName("moh");
		expecetedEmployee.setEmail("Muspha@gmail.com");

		expecetedEmployee2.setName("Mohamed");
		expecetedEmployee2.setLastName("Amine");
		expecetedEmployee2.setEmail("Muspha@gmail.com");

		employeeService.save(expecetedEmployee);
		employeeService.save(expecetedEmployee2);

		// when
		List<EmployeEntity> employelist = new ArrayList<>();
		employelist.add(expecetedEmployee);
		employelist.add(expecetedEmployee2);

		List<EmployeEntity> savedList = employeeService.getAllEmpl();

		// then

		assertEquals(employelist, savedList);

	}

	@Test
	public void getById_OK() {

		// given
		EmployeEntity expectedEmploye = new EmployeEntity();
		expectedEmploye.setName("ValueIt");
		expectedEmploye.setLastName("Sarl");
		EmployeEntity savedEmployee = employeeService.save(expectedEmploye);

		// when
		Long id = savedEmployee.getId();
		Optional<EmployeEntity> getedEmpl = employeeService.getById(id);
		// then

		assertNotNull(getedEmpl);
		assertEquals(getedEmpl.get().getName(), savedEmployee.getName());
	}

	@Test
	public void deletedById_OK() {

		// given
		EmployeEntity expectedEmploye = new EmployeEntity();
		expectedEmploye.setName("ValueIt");
		expectedEmploye.setLastName("Sarl");
		expectedEmploye.setEmail("Sarl@gmail.com");
		employeeService.save(expectedEmploye);
		long searchedId = expectedEmploye.getId();

		// When
		employeeService.deleteById(searchedId);

		// Then
		Optional<EmployeEntity> deletedEmploye = employeeService.getById(searchedId);
		assertThat(deletedEmploye.isEmpty());
	}

	@Test
	public void delete_Ok() {

		// given
		EmployeEntity unexpectedEmployee = new EmployeEntity();
		unexpectedEmployee.setName("maryam");
		unexpectedEmployee.setLastName("outaleb");
		unexpectedEmployee.setEmail("maryam@gmail.com");
		employeeService.save(unexpectedEmployee);

		// when
		employeeService.delete(unexpectedEmployee);
		Optional<EmployeEntity> deletedEmployee = employeeService.getById(unexpectedEmployee.getId());

		assertThat(deletedEmployee.isEmpty());

	}

	@Test
	public void getByName() {
		// given
		EmployeEntity expectedEmployee = new EmployeEntity();
		expectedEmployee.setName("maryam");
		expectedEmployee.setLastName("outaleb");
		expectedEmployee.setEmail("maryam@gmail.com");
		employeeService.save(expectedEmployee);

		// when
		EmployeEntity returnedEmployee = employeeService.getByName("maryam");

		// then
		assertNotNull(returnedEmployee);
		assertEquals(expectedEmployee.getName(), returnedEmployee.getName());
		assertEquals(expectedEmployee.getLastName(), returnedEmployee.getLastName());
		assertEquals(expectedEmployee.getEmail(), returnedEmployee.getEmail());

	}

	@Test
	public void save_KO() {
		// given
		// when
		// then
	}

	@Test
	public void getAllEmpl_KO() {
		// given
		// when
		// then
	}

	@Test
	public void delete_KO() {
		// given
		// when
		// then
	}

	@Test
	public void deletedById_KO() {
		// given
		// when
		// then
	}

	@Test
	public void getByName_KO() {
		// given
		// when
		// then
	}

}
