package com.stage.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.demo.model.*;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeEntity,Long>{

	EmployeEntity findByName(String name);

}
