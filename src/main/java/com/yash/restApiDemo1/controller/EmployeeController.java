package com.yash.restApiDemo1.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yash.restApiDemo1.dao.EmployeeDAO;
import com.yash.restApiDemo1.model.Employee;
import com.yash.restApiDemo1.model.Employees;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
	
	@Autowired
    private EmployeeDAO employeeDao;
	
	@GetMapping(path ="/", produces = "application/json")
	public Employees getEmployee() {
		return employeeDao.getAllEmployees();
		}
	
	@PostMapping(path = "/",  consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee){
		
		Integer id = employeeDao.getAllEmployees().getEmployeeList().size()+1;
		employee.setId(id);
		
		employeeDao.addEmployee(employee);
		
		System.out.println("jlkjljljljljklkjljljl");
		URI locaion = ServletUriComponentsBuilder.fromCurrentRequest()
				 .path("/{id}")
                 .buildAndExpand(employee.getId())
                 .toUri();
		
		return ResponseEntity.created(locaion).build();
		}

}
