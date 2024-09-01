package com.rk.repository;

import org.springframework.data.repository.CrudRepository;

import com.rk.model.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Integer>{

}
