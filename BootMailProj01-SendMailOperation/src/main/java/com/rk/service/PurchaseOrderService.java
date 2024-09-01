package com.rk.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service("PurchaseService")
public class PurchaseOrderService implements IPurchaseOrderService{

	
	@Value("${spring.mail.username}")
	private String senderEmail;
	@Value("${spring.mail.password}")
	private String senderPwd;
	@Autowired
	private JavaMailSender sender;
	
	@Override
	public String purchase(String[] items, double[] prices, String[] toEmails) throws Exception {
		double billAmt=0.0;
		for(double p:prices)
			billAmt=billAmt+p;
		String msg=Arrays.toString(items)+"are Purchased having the prices"+Arrays.toString(prices)+"With the BillAmount"+billAmt;
		
		String result=sendEmails(toEmails, msg);
		return result+"==========================="+msg;
	}
	
	private String sendEmails(String toEmails[],String msg) throws Exception {
		//create mineMessage from the sender Object
		MimeMessage mineMessage=sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mineMessage,true);
		helper.setFrom(senderEmail);
		helper.setTo(toEmails);
		helper.setSubject("Open it to know it");
		helper.setText(msg);
		helper.addAttachment("nit.jpg", new ClassPathResource("nit.jpg"));
		return "mail sent";
	}

}
