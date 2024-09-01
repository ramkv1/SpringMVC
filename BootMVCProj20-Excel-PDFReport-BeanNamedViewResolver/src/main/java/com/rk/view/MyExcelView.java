package com.rk.view;

import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.rk.model.Employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("excel_view")
public class MyExcelView extends AbstractXlsView{

	int i=0;
	@Override
	protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		//get model attribute
		Iterable<Employee> itEmps=(Iterable<Employee>) map.get("emplist");
		
		//create worksheet in workBook
		Sheet sheet1=workbook.createSheet("EmployeeInfo");
		
		itEmps.forEach(emp->{
			Row row=sheet1.createRow(i);
			row.createCell(0).setCellValue(emp.getEmpno());
			row.createCell(1).setCellValue(emp.getEname());
			row.createCell(2).setCellValue(emp.getJob());
			row.createCell(3).setCellValue(emp.getSal());
			if(emp.getDeptno()!=null)
				row.createCell(4).setCellValue(emp.getDeptno());
			i++;
		});
		
	}

}
