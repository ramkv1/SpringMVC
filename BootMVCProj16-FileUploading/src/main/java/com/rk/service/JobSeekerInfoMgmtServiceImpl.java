package com.rk.service;

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

}
