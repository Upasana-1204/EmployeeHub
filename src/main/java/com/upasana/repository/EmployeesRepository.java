package com.upasana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upasana.model.Employee;


public interface EmployeesRepository extends JpaRepository<Employee, Long> {



}
