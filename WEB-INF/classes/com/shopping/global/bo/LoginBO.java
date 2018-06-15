package com.shopping.global.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.global.bean.LoginBean;
import com.shopping.global.dto.LoginDTO;
import com.shopping.global.services.LoginServices;

@Component
public class LoginBO {
	@Autowired
	private LoginServices loginServices;

	public LoginServices getLoginServices() {
		return loginServices;
	}

	public void setLoginServices(LoginServices loginServices) {
		this.loginServices = loginServices;
	}
	
	public LoginDTO userAuth(LoginDTO loginDTO) throws Exception{
		LoginDTO loginDTO2=null; 
		try {
			loginDTO2=this.getLoginServices().userAuth(loginDTO);
		} catch (Exception e) {
			throw e;
		}
		return loginDTO2;
	}
	

}
