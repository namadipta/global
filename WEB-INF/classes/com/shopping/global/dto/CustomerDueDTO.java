package com.shopping.global.dto;

import java.io.Serializable;

public class CustomerDueDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2657391590092816780L;

	
	private String customerId;

	private String godownno;
	
	private String name;

	private String totalBalance;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getGodownno() {
		return godownno;
	}

	public void setGodownno(String godownno) {
		this.godownno = godownno;
	}

	public String getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(String totalBalance) {
		this.totalBalance = totalBalance;
	}

	@Override
	public String toString() {
		return "CustomerDueDetailsDTO [customerId=" + customerId + ", godownno=" + godownno + ", name=" + name
				+ ", totalBalance=" + totalBalance + "]";
	}
	
	

}
