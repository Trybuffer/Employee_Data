package com.employee.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import com.employee.entity.Employee;
import com.employee.exception.EmployeeAlreadyExistException;
import com.employee.respository.EmployeeRespository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRespository employeeRespository;
	
	
	public EmployeeServiceImpl(EmployeeRespository employeeRespository) {
		super();
		this.employeeRespository=employeeRespository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		if(employeeRespository.existsById(employee.getId())) {
			throw new EmployeeAlreadyExistException("Employee Already Exists");
		}
		return employeeRespository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRespository.findAll();
	}
	@Override
	public List<Employee> getEmployeeBySorting() {
		List<Employee> list = employeeRespository.findAll(Sort.by("salary").descending().and(Sort.by("name")));
		return list;
	}

	public Employee updateEmployeeBySal(double salary, Integer id,Employee employee) {
		Employee e=employeeRespository.findById(id).get();
		try{
			e.setSalary(employee.getSalary());
		}
		catch(Exception e1){
			
		}
		
		employeeRespository.save(e);
		return e;
	}
	
	
}
