package com.yash.restApiDemo1.dao;

import org.springframework.stereotype.Repository;

import com.yash.restApiDemo1.model.Employee;
import com.yash.restApiDemo1.model.Employees;

@Repository
public class EmployeeDAO {
	
	private static Employees list = new Employees();
	
	
static {
	list.getEmployeeList().add(new Employee(1, "Shashank","Shakya","shashank.shakya@yash.com"));
	list.getEmployeeList().add(new Employee(2, "Tony","Stark","tony.stark@yash.com"));
	list.getEmployeeList().add(new Employee(3, "Shashank","Viyas","shashank.viyas@yash.com"));
	list.getEmployeeList().add(new Employee(4, "Liyano","De caprio","shashank.shakya@yash.com"));
	list.getEmployeeList().add(new Employee(5, "Elon","Musk","elon.mosk@yash.com"));
	
}
	

public Employees getAllEmployees() {
	return list;
	
}

public void addEmployee(Employee employee) {
	list.getEmployeeList().add(employee);
}

}
