package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.rk.service.IPurchaseOrderService;

@SpringBootApplication
public class BootMailProj01SendMailOperationApplication {

	public static void main(String[] args) {
		//Get IOC Container
		ApplicationContext ctx=SpringApplication.run(BootMailProj01SendMailOperationApplication.class, args);
		//Get Service class Object
		IPurchaseOrderService service=ctx.getBean("PurchaseService",IPurchaseOrderService.class);
		//Invoke b.method
		try {
			String result=service.purchase(new String[] {"shirt","trouser","blazer"},
																new double[] {2999.0,4599.0,6333.0},
																new String[] {"ramkv43@gmail.com","vadlakondaramakrishna961@gmail.com"});
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//close the IOC Container
		((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
