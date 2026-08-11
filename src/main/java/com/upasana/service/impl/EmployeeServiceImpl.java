package com.upasana.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upasana.exception.ResourceNotFoundException;
import com.upasana.service.EmployeeService;

import com.upasana.model.Employee;
import com.upasana.repository.EmployeesRepository;

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

}
