package com.rk.service;

public interface IPurchaseOrderService {
	public String purchase(String[] items,double[] prices,String[] toEmails) throws Exception;
}
