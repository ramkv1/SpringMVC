package com.rk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.model.Employee;
import com.rk.repository.IEmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService{

	@Autowired
	private IEmployeeRepository repo; 
	
	@Override
	public Iterable<Employee> showAllEmployee() {
		return repo.findAll();
	}

}
