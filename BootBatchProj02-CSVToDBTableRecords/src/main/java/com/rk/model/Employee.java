package com.rk.model;

import lombok.Data;

@Data
public class Employee {
	private Integer eno;
	private String ename;
	private String eadd;
	private Float salary;
	private Float grossSalary;
	private Float netSalary;
}
