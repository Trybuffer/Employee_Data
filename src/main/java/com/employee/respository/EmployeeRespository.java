package com.employee.respository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employee.entity.*;


public interface EmployeeRespository extends JpaRepository<Employee,Integer> {
	

}
