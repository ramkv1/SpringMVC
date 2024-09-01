package com.rk.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("biProcessor")
public class BookItemProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		System.out.println("BookItemProcessor.process()");
		if(item.equalsIgnoreCase("CRJ"))
			return item+"by HS,PN";
		else if(item.equalsIgnoreCase("TIJ"))
			return item+"by BE";
		else if(item.equalsIgnoreCase("EJ"))
			return item+"by JB";
		else if(item.equalsIgnoreCase("BBJ"))
			return item+"by RNR";
		else if(item.equalsIgnoreCase("HFJ"))
			return item+"KS";
		else
			return null;
	}//method

}//class
