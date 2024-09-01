package com.rk.service;

import com.rk.model.Employee;

public interface IEmployeeMgmtService {
	
	public Iterable<Employee> getAllEmployee();
	public String registerEmployee( Employee emp);
	public Employee findEmployeeByEno(int eno);
	public String updateEmployee(Employee emp);
	public String deleteEmployeeById(int no);
	
}
