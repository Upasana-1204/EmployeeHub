package com.upasana.service;
import java.util.List;

import com.upasana.model.Employee;

public interface EmployeeService {
 Employee saveEmployee(Employee employee);
 List<Employee> getAllEmployees();
 Employee getEmployeeById(long id);
 Employee updateEmployee(Employee employee, long id);
}
