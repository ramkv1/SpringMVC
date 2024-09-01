package com.rk.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rk.model.Student;

@Controller
public class StudentOperationsController {
	
	@GetMapping("/")
	public String showHome() {
		//return LVN
		return "Home";
	}
	@GetMapping("/register")
	public String showForm() {
		//return LVN
		return "stu_register";
	}
	@PostMapping("/register")
	public String processStudent(Map<String, Object> map,@ModelAttribute("stud") Student stu) {
		//generate result
		String grade=null;
		if(stu.getAvg()>=75)
			grade="First class With Dist";
		else if(stu.getAvg()>=60)
			grade="First class";
		else if(stu.getAvg()>=50)
			grade="Second class";
		else if(stu.getAvg()>=35)
			grade="Third class";
		else
			grade="Fail";
			
		//keep the result in Model attribute
			map.put("result", grade);
		//return LVN
			return "show_result";
			
	}
}
