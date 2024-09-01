package com.rk.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.rk.lister.JobMonitoringListener;
import com.rk.model.Employee;
import com.rk.processor.EmployeeItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private JobBuilderFactory jobFactory;
	@Autowired
	private StepBuilderFactory stepFactory;
	@Autowired
	private JobMonitoringListener listener;
	@Autowired
	private EmployeeItemProcessor processor;
	@Autowired
	private DataSource ds;
	
	@Bean(name = "ffiReader")
	public FlatFileItemReader<Employee> createFFIReader(){
		//create object for the above
		FlatFileItemReader<Employee> reader=new FlatFileItemReader<Employee>();
		//specify the resource (csv file name)
		reader.setResource(new ClassPathResource("EmployeeInfo.csv"));
		//Set LineMapper
		DefaultLineMapper<Employee> lineMapper=new DefaultLineMapper<Employee>();
		//set LineTokenizer to linemapper
		DelimitedLineTokenizer tokenizer=new DelimitedLineTokenizer();
		tokenizer.setDelimiter(",");
		tokenizer.setNames("eno","ename","eadd","salary");
		lineMapper.setLineTokenizer(tokenizer);
		//set fileSetMapper to LineMapper
		BeanWrapperFieldSetMapper<Employee> wrapper=new BeanWrapperFieldSetMapper<Employee>();
		wrapper.setTargetType(Employee.class);
		lineMapper.setFieldSetMapper(wrapper);
		//set LineMapper to reader
		reader.setLineMapper(lineMapper);
		return reader;
	}
	
	@Bean("jbiw")
	public JdbcBatchItemWriter<Employee> createwriter(){
		//create the object for jdbcBatchItemWriter
		JdbcBatchItemWriter<Employee> writer=new JdbcBatchItemWriter<Employee>();
		//set Datasource
		writer.setDataSource(ds);
		//set SQL Query with named params
		writer.setSql("INSERT INTO BATCH_EMPLOYEE_INFO VALUES(:eno,:ename,:eadd,:salary,:grossSalary,:netSalary)");
		//set Model class Obj Data to Sql Query named Param vales
		BeanPropertyItemSqlParameterSourceProvider<Employee> sourceProvider=new BeanPropertyItemSqlParameterSourceProvider<Employee>();
		writer.setItemSqlParameterSourceProvider(sourceProvider);
		return writer;
	}
	
	@Bean(name = "step1")
	public Step createStep1() {
		return stepFactory.get("step1")
				.<Employee,Employee>chunk(10)
				.reader(createFFIReader())
				.processor(processor)
				.writer(createwriter())
				.build();
	}
	@Bean(name = "job1")
	public Job createJob() {
		return jobFactory.get("job1")
				.listener(listener)
				.incrementer(new RunIdIncrementer())
				.start(createStep1())
				.build();
	}
}
