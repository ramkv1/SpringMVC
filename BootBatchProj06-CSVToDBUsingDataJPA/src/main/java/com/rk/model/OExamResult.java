package com.rk.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BATCH_DATA_EXAM_RESULT")
public class OExamResult {
	@Id
	private Integer id;
	private LocalDateTime dob;
	private Float percentage;
	private Integer semester;
	
}