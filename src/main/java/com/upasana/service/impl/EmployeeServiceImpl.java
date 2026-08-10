package com.upasana.service.impl;

import org.springframework.stereotype.Service;
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

}
