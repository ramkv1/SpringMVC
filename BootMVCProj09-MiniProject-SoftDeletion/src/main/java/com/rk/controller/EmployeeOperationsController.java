package com.rk.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rk.model.Employee;
import com.rk.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationsController {
	
	@Autowired
	private IEmployeeMgmtService empservice;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/report")
	public String showEmployeeReport(Map<String, Object> map) {
		//use Service
		Iterable<Employee> itEmp=empservice.getAllEmployee();
		//put map object in model attribute
		map.put("empList", itEmp);
		//return LVN
		return "report";
	}
	
	@GetMapping("/emp_add")
	public String showFormforSaveEmployee(@ModelAttribute("emp") Employee emp) {
		//return LVN
		return "register_emp";
	}
	
	@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp") Employee emp,Map<String, Object> map) {
		//use service
		String msg=empservice.registerEmployee(emp);
		Iterable<Employee> itEmps=empservice.getAllEmployee();
		//keep the result in model attribute
		map.put("resultMsg", msg);
		map.put("empsList", itEmps);
		//return LVN
		return "report";
	}
	
	@GetMapping("/emp_edit")
	public String showEmployeeFormpage(@RequestParam("no") int no,
																					@ModelAttribute("emp") Employee emp) {
		//use service
		Employee emp1=empservice.findEmployeeByEno(no);
		//copy data
		BeanUtils.copyProperties(emp1, emp);
		//return LVN
		return "update_emp";
	}
	@PostMapping("/emp_edit")
	public String editEmployee(RedirectAttributes attrs,
											@ModelAttribute("emp") Employee emp) {
		//use Service
		String msg=empservice.updateEmployee(emp);
		attrs.addFlashAttribute("resultMsg",msg);
		//return LVN
		return "redirect:report";
	}
	@GetMapping("/emp_delete")
	public String deleteEmployee(RedirectAttributes attrs,
												@RequestParam int no) {
		
		//use Service
		String msg=empservice.deleteEmployeeById(no);
		//keep the result in model attribute
		attrs.addFlashAttribute("resultMsg",msg);
		//return the request
		return "redirect:report";
	}
}
