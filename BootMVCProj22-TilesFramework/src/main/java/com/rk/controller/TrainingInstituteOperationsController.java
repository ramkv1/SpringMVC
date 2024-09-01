package com.rk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrainingInstituteOperationsController {
	
	@GetMapping("/")
	public String showHomepage() {
		return "homePageDef";
	}
	
	@GetMapping("/faculties")
	public String showFacultiesPage() {
		return "facultiesPageDef";
	}
	
	@GetMapping("/courses")
	public String showCoursesPage() {
		return "coursesPageDef";
	}
	
	@GetMapping("/training")
	public String showTraningModesPage() {
		return "tmPageDef";
	}
}
