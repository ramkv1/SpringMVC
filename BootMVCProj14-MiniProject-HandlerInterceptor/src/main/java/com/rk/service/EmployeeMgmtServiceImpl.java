package com.rk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.model.Employee;
import com.rk.repository.IEmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	
	@Autowired
	private IEmployeeRepository emprepo;
	
	@Override
	public Iterable<Employee> getAllEmployee() {
		return emprepo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) {
		return "Employee is saved with id_value::"+emprepo.save(emp).getEmpno();
	}

	@Override
	public Employee findEmployeeByEno(int eno) {
		Employee emp=emprepo.findById(eno).orElseThrow(()->new IllegalArgumentException());
		return emp;
	}

	@Override
	public String updateEmployee(Employee emp) {
		return "Employee is updated with having id value::"+emprepo.save(emp).getEmpno();	
	}

	@Override
	public String deleteEmployeeById(int no) {
		emprepo.deleteById(no);
		return no+"::employee id Employee is Deleted";
	}

}
