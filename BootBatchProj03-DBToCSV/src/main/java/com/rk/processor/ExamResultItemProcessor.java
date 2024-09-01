package com.rk.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.rk.model.ExamResult;

@Component
public class ExamResultItemProcessor implements ItemProcessor<ExamResult, ExamResult>{

	@Override
	public ExamResult process(ExamResult item) throws Exception {
		if(item.getPercentage()>90.0f)
			return item;
		else
		return null;
	}

}
