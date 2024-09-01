package com.rk.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rk.service.ISeasonFinderService;

@Controller
public class SeasonOperationsController {
	
	@Autowired
	private ISeasonFinderService service;
	
	@RequestMapping("/")
	public String showHomepage() {
	//return LVN
		return "welcome";
	}
	
	@RequestMapping("/season")
	public String showSeason(Map<String, Object> map) {
		System.out.println("SeasonOperationsController.showSeason()");
		//use service
		String msg=service.findService();
		//keep result in model attribute
		map.put("resultMsg", msg);
		//return LVN
		return "display";
	}
}
