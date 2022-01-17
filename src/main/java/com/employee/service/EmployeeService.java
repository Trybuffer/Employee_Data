package com.employee.service;
import com.employee.entity.Employee;

import java.util.*;

public interface EmployeeService {
 
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	List<Employee> getEmployeeBySorting();
	Employee updateEmployeeBySal(double salary,Integer id,Employee employee);
}
