package com.rk.model;

import java.util.Date;

import lombok.Data;

@Data
public class ExamResult {
	private Integer id;
	private Date dob;
	private Integer semester;
	private Float percentage;
}
