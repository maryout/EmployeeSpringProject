package com.stage.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage.demo.model.EmployeEntity;
import com.stage.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

//	 // get all employees 
//	public List<EmployeEntity> getALLEmployees(){
//	    List<EmployeEntity> employee =  employeeRepository.findAll() ;
//		return employee ; }

	public EmployeEntity save(EmployeEntity employe) {
		return employeeRepository.save(employe);
	}

	public List<EmployeEntity> getAllEmpl() {
		return employeeRepository.findAll();
	}

	public Optional<EmployeEntity> getById(Long id) {
		return employeeRepository.findById(id);
	}

	public String delete(EmployeEntity employee) {
		employeeRepository.delete(employee);
		return "SUCCESS";
	}

	public void deleteById(Long id) {
		Optional<EmployeEntity> employee = getById(id);
		if (employee.isEmpty()) {
			throw new IllegalStateException("Id Not found");
		}
		employeeRepository.deleteById(id);
	}

	public EmployeEntity getByName(String name) {

		return employeeRepository.findByName(name);
	}

}
