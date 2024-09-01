package com.rk.service;

import java.util.List;

import com.rk.entity.JobSeekerInfo;

public interface IJobSeekerInfoMgmtService {
	public String registerJobSeeker(JobSeekerInfo jsInfo);
	public List<JobSeekerInfo> getAllJobSeekerInfo();
	
	
	public String findResumePathById(Integer id);
	public String findPhotoPathById(Integer id);
}
