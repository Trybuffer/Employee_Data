package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import com.employee.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping
public class EmployeeController {
 
	
	private EmployeeService employeeService;
	@Autowired
	EmployeeServiceImpl serviceImpl;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping("employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	
}
	@GetMapping("employees")
public List<Employee> getAllEmployee()	{
return employeeService.getAllEmployee();	
}
	@GetMapping(path = "/employee/sorted")
	public List<Employee> function2(){
		return serviceImpl.getEmployeeBySorting();
	}
	@PutMapping(path="/employees/{id}/{salary}")
	private Employee updateEmployeeBySal(@PathVariable("id")Integer id,@PathVariable("salary")double salary ,@RequestBody Employee employee) {
		return serviceImpl.updateEmployeeBySal(salary, id,employee);
	}
}

