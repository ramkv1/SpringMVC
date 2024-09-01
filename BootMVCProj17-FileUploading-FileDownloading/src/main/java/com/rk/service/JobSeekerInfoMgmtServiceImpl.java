package com.rk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.entity.JobSeekerInfo;
import com.rk.repository.IJobSeekerInfoRepository;

@Service("jsService")
public class JobSeekerInfoMgmtServiceImpl implements IJobSeekerInfoMgmtService {

	@Autowired
	private IJobSeekerInfoRepository jsrepo;

	@Override
	public String registerJobSeeker(JobSeekerInfo jsInfo) {
		int idVal=jsrepo.save(jsInfo).getJsId();
		return "The Job Seeker is Registered with Id value::"+idVal;
	}

	@Override
	public List<JobSeekerInfo> getAllJobSeekerInfo() {
		return jsrepo.findAll();
	}

	@Override
	public String findResumePathById(Integer id) {
		return jsrepo.getResumePathById(id);
	}

	@Override
	public String findPhotoPathById(Integer id) {
		return jsrepo.getPhotoPathById(id);
	}

}
