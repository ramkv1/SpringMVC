package com.rk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rk.entity.JobSeekerInfo;

public interface IJobSeekerInfoRepository extends JpaRepository<JobSeekerInfo, Integer>{
		
	@Query("SELECT resumePath from JobSeekerInfo WHERE jsId=:id")
	public String getResumePathById(Integer id);
	
	@Query("SELECT photoPath from JobSeekerInfo WHERE jsId=:id")
	public String getPhotoPathById(Integer id);
}
