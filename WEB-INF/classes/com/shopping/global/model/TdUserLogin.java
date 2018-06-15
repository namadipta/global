package com.shopping.global.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the td_user_login database table.
 * 
 */
@Entity
@Table(name="td_user_login")
@NamedQuery(name="TdUserLogin.findAll", query="SELECT t FROM TdUserLogin t")
public class TdUserLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_name")
	private String userName;

	private String password;

	@Column(name="user_id")
	private BigInteger userId;

	public TdUserLogin() {
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigInteger getUserId() {
		return this.userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

}