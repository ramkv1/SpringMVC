package com.rk.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rk.entity.JobSeekerInfo;
import com.rk.model.JobSeeker;
import com.rk.service.IJobSeekerInfoMgmtService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;

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
	@GetMapping("/js_report")
	public String show_Report(Map<String, Object> map) {
		//use Service
		List<JobSeekerInfo> list=jsService.getAllJobSeekerInfo();
		//add the result model attributes
		map.put("jsInfo", list);
		
		//return LVN
		return "show_report";
	}
	@Autowired 
	private ServletContext sc;
	
	@GetMapping("/download")
	public String downloadFile(@RequestParam("id") Integer id,
													@RequestParam("type") String type,
													HttpServletResponse res) {
		String fileLocation=null;
		if(type.equalsIgnoreCase("resume"))
			fileLocation=jsService.findResumePathById(id);
		else
			fileLocation=jsService.findPhotoPathById(id);
		
		//Create the file object representing the file to be download
		File file=new File(fileLocation);
		
		//get the file content length and the make it as response content
		long length=file.length();
		res.setContentLengthLong(length);
		
		//get file MIME type and make it as the response content type
		String mimeType=sc.getMimeType(fileLocation);
		mimeType=mimeType==null?"application/octet-stream":mimeType;
		res.setContentType(mimeType);
		//create InputStream pointing to the file
		//create OutPutStream pointing to response Object
		try(InputStream is=new FileInputStream(file);
				OutputStream os=res.getOutputStream();
				){
			//gives special instruction to browser to make the received output as the download file
			res.setHeader("Content-Disposition", "attachment;fileName="+file.getName());
			//copy the content of the file to response Object
			IOUtils.copy(is, os);
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}
		return null; //to make the response going to browser directly from ViewRes
	}
}
