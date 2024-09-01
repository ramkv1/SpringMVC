package com.rk.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component("biReader")
public class BookItemReader implements ItemReader<String>{

	public String[] books=new String[] {"CRJ","TIJ","EJ","BBJ","HFJ"};
	int count=0;
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("BookItemReader.read()");
		if(count<books.length) {
			return books[count++];
	}
		else
			return null;
	}//method

}//class
