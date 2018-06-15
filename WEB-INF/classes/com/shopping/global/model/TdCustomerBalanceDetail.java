package com.shopping.global.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the td_customer_balance_details database table.
 * 
 */
@Entity
@Table(name="td_customer_balance_details")
@NamedQuery(name="TdCustomerBalanceDetail.findAll", query="SELECT t FROM TdCustomerBalanceDetail t")
public class TdCustomerBalanceDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="balance_details_code")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger balanceDetailsCode;

	@Column(name="bill_amount")
	private double billAmount;

	@Column(name="bill_date")
	private String billDate;

	@Column(name="bill_no")
	private BigInteger billNo;

	@Column(name="customer_id")
	private BigInteger customerId;

	@Column(name="due_amount")
	private double dueAmount;

	@Column(name="goddown_no")
	private String goddownNo;

	private String name;

	@Column(name="paid_amount")
	private double paidAmount;

	public TdCustomerBalanceDetail() {
	}


	public BigInteger getBalanceDetailsCode() {
		return balanceDetailsCode;
	}


	public void setBalanceDetailsCode(BigInteger balanceDetailsCode) {
		this.balanceDetailsCode = balanceDetailsCode;
	}


	public double getBillAmount() {
		return this.billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public String getBillDate() {
		return this.billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public BigInteger getBillNo() {
		return this.billNo;
	}

	public void setBillNo(BigInteger billNo) {
		this.billNo = billNo;
	}

	public BigInteger getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(BigInteger customerId) {
		this.customerId = customerId;
	}

	public double getDueAmount() {
		return this.dueAmount;
	}

	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}

	public String getGoddownNo() {
		return this.goddownNo;
	}

	public void setGoddownNo(String goddownNo) {
		this.goddownNo = goddownNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPaidAmount() {
		return this.paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

}