package com.shopping.global.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.global.dao.LoginDAO;
import com.shopping.global.dto.LoginDTO;
@Component
public class LoginServices {

	@Autowired
	private LoginDAO loginDAO;

	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	
	public LoginDTO userAuth(LoginDTO loginDTO) throws Exception{
		LoginDTO loginDTO2=null;
		try {
			loginDTO2=this.getLoginDAO().userAuth(loginDTO);
		} catch (Exception e) {
			throw e;
		}		
		return loginDTO2;
	}

}
