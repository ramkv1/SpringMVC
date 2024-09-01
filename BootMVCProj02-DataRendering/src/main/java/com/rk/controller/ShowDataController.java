package com.rk.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ShowDataController {
	/*@RequestMapping("/process")
	public String process(Map<String,Object> map) {
		System.out.println("ShowDataController.process()");
		//add model attributes to sharedMemory
		map.put("attr1","Raja");
		map.put("sysDt", LocalDateTime.now());
		//return LVN
		return "Show_data";
	}*/
	
	/*	@RequestMapping("/process")
		public String process(Model model) {
			System.out.println("ShowDataController.process()");
			//Adding Model attributes to Object
			model.addAttribute("attr1","Raja");
			model.addAttribute("sysDt",LocalDateTime.now());
			//return LVN
			return "Show_data";
		}*/
	
	/*	@RequestMapping("/process")
		public String process(ModelMap map) {
			System.out.println("ShowDataController.process()");
			map.addAttribute("attr1","Rana");
			map.addAttribute("sysDt",LocalDateTime.now());
			return "Show_data";
		}*/
	//Taking Model as return value
	
	/*@RequestMapping("process")
	public Model process() {
		Model model=new BindingAwareModelMap();
		// Add Model attribute to Object
		model.addAttribute("attr1", "Rani");
		model.addAttribute("sysDt", LocalDateTime.now());
		//Return LVN
		return model;
	}*/
	
	/*@RequestMapping("/process")
	public Map<String, Object> process(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("attr1", "Rk");
		map.put("sysDt", LocalDateTime.now());
		//Return LVN
		return map;		
	}*/
	
	/*@RequestMapping("/process")
	public ModelAndView process() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("attr1","VRK");
		mav.addObject("sysDt",LocalDateTime.now());
		//return LVN
		return mav;
	}*/
	
	/*@RequestMapping("/process")
	public void process(Map<String, Object> map) {
		map.put("attr1", "raja");
		map.put("sysDt", LocalDateTime.now());
	}*/
	
	/*@RequestMapping("/process")
	public String process(Map<String, Object> map) {
		map.put("attr1", "raja");
		map.put("sysDt", LocalDateTime.now());
		return null;
	}*/
	
	/*	@RequestMapping("/process")
		public String process() {
			System.out.println("ShowDataController.process()");
			return "forward:report";
		}
		
		@RequestMapping("/report")
		public String showReport() {
			System.out.println("ShowDataController.showReport()");
			return "Show_data";
		}*/
	
	@RequestMapping("/process")
	public String process(HttpServletRequest req) {
		System.out.println("ShowDataController.process()::"+req.hashCode());
		req.setAttribute("attr1","Val1");
		return "redirect:report";
	}
	@RequestMapping("/report")
	public String showReport(HttpServletRequest req) {
		System.out.println("req attribute::"+req.getAttribute("attr1"));
		System.out.println("ShowDataController.showReport()");
		return "Show_data";
	}
}
