package com.rk.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rk.model.Employee;
import com.rk.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationsController {
	
	
	@Autowired
	private IEmployeeMgmtService service1;
	
	@RequestMapping("/")
	public String showHomePage() {
		//return LVN
		return "welcome";
	}
	
	@GetMapping("/report")
	public String generateReport(@RequestParam("type") String type,Map<String, Object> map) {
		//use service
		Iterable<Employee> empsList=service1.showAllEmployee();
		//add to model attribute
		map.put("emplist", empsList);
		//return LVN
		if(type.equalsIgnoreCase("excel"))
			return "excel_view";
		else
			return "pdf_view";
	}
}
