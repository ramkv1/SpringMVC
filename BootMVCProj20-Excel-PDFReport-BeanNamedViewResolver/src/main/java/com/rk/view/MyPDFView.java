package com.rk.view;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.rk.model.Employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("pdf_view")
public class MyPDFView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("EmployeePDFView.buildPdfDocument()");
		//get model attribute data
		Iterable<Employee> emplist=(Iterable<Employee>) map.get("emplist");
		//add paragraph
		Paragraph para=new Paragraph("Employee Report",new Font(Font.BOLDITALIC));
		document.add(para);
		//add  table content
		Table table=new Table(5,((ArrayList) emplist).size());
		for(Employee emp:emplist) {
			table.addCell(String.valueOf(emp.getEmpno()));
			table.addCell(emp.getEname());
			table.addCell(emp.getJob());
			table.addCell(String.valueOf(emp.getSal()));
			table.addCell(String.valueOf(emp.getDeptno()));
		}
		document.add(table);
	}

}
