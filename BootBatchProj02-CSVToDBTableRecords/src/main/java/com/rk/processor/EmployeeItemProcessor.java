package com.rk.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.rk.model.Employee;

@Component("empItem")
public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee>{

	@Override
	public Employee process(Employee item) throws Exception {
		if(item.getSalary()>=190000) {
			item.setGrossSalary(item.getSalary()+item.getSalary()*0.4f);
			item.setNetSalary(item.getSalary()-item.getSalary()*0.2f);
			return item;
	}
		return null;
	}

}
