package com.rk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="BOOT_JS_INFO1")
public class JobSeekerInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer jsId;
	@Column(length = 20)
	private String jsName;
	@Column(length = 20)
	private String jsAddrs;
	@Column(length = 120)
	private String resumePath;
	@Column(length = 120)
	private String photoPath;
}
