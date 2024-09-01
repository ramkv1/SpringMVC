package com.rk.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rk.entity.JobSeekerInfo;
import com.rk.model.JobSeeker;
import com.rk.service.IJobSeekerInfoMgmtService;

@Controller
public class JobSeekerOperationsController {
	
	@Autowired
	private IJobSeekerInfoMgmtService jsService;

	@RequestMapping("/")
	public String showHome() {
		//return LVN
		return "welcome";
	}
	@GetMapping("/js_register")
	public String showJobseekerRegistrationFormPage(@ModelAttribute("js") JobSeeker seeke) {
		//return LVN(form page)
		return "js_register_form";
	}
	
	@Autowired
	private Environment env;
	
	@PostMapping("/js_register")
	public String registerJobSeeker(@ModelAttribute("js" ) JobSeeker seeker,
															Map<String, Object> map) {
		//Get location to save the uploaded in server machine file system
		String location=env.getRequiredProperty("upload.store");
		//check the folder available if not there create 
		File file=new File(location);
		if(!file.exists())
			file.mkdir();
		
		//Get the name of the uploaded files
		String resumefilename=seeker.getResume().getOriginalFilename();
		String photofilename=seeker.getPhoto().getOriginalFilename();

		
		//get input stream representation  the uploading file
		try(InputStream resumeIS=seeker.getResume().getInputStream();
				InputStream photoIS=seeker.getPhoto().getInputStream();
				//create output file pointing to destination file
				OutputStream resumeOS=new FileOutputStream(location+"//"+resumefilename);
				OutputStream photoOS=new FileOutputStream(location+"//"+photofilename);
				) {
			//perform copy stream Operation to complete file upload
			IOUtils.copy(photoIS, photoOS);
			IOUtils.copy(resumeIS, resumeOS);
			
			//Convert model class object data to Entity class Object data
			JobSeekerInfo jsInfo=new JobSeekerInfo();
			jsInfo.setJsName(seeker.getJsName());
			jsInfo.setJsAddrs(seeker.getJsAddrs());
			jsInfo.setResumePath(location+"//"+resumefilename);
			jsInfo.setPhotoPath(location+"//"+photofilename);
			
			//use service 
			String resultMsg=jsService.registerJobSeeker(jsInfo);
			//add results to model attribute
			map.put("resultMsg", resultMsg);
			map.put("ResumeFileName", resumefilename);
			map.put("PhotoFilename", photofilename);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Return LVN
		return "show_result";
	}
}
