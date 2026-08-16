package com.upasana.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upasana.exception.ResourceNotFoundException;
import com.upasana.model.Employee;
import com.upasana.repository.EmployeesRepository;
import com.upasana.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
 
   private EmployeesRepository employeeRepository;

       
      public EmployeeServiceImpl(EmployeesRepository employeeRepository){
        super();
        this.employeeRepository = employeeRepository;
      }


    @Override
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees(){
      return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id){
      return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id){
      // we need to check wheather the employee with given id is exisrt in database or not
      Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException("Employee", "Id", id));
        existingEmployee.setFirstname(employee.getFirstname());
        existingEmployee.setLastname(employee.getLastname());
        existingEmployee.setEmail(employee.getEmail());
        // save existing employee to database
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

}
