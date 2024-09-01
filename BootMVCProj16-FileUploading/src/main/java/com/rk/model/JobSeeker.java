package com.rk.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class JobSeeker {
	private String jsName;
	private String jsAddrs;
	private MultipartFile resume;
	private MultipartFile photo;
}
