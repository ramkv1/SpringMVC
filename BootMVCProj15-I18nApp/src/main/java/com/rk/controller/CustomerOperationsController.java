package com.rk.controller;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rk.model.Customer;

@Controller
public class CustomerOperationsController {
	
	@GetMapping("/")
	public String showHome() {
		//return LVN
		return "Welcome";
	}
	@GetMapping("/register")
	public String showCustomerFormPage(@ModelAttribute("cust") Customer cust) {
		//return LVN
		return "customer_form";
	}
	
	@PostMapping("/register")
	public String processCustomerFormSubmission(Map<String, Object> map ,
																						@ModelAttribute("cust") Customer cust) {
		//write the b.logic
		if(cust.getBillAmount()<10000)
			map.put("resultMsg", "Customer is Ecomomy Customer");
		else
			map.put("resultMsg", "Customer is Luxory Customer");
		
		//return LVN
		return "show_result";
	}
}
