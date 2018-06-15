package com.shopping.global.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.global.bean.CustomerDetailsBean;
import com.shopping.global.bean.LoginBean;
import com.shopping.global.bo.LoginBO;
import com.shopping.global.constants.HtmConstants;
import com.shopping.global.dto.LoginDTO;


@Controller
public class LoginController {
	
	@Autowired
	private LoginBO loginBo;
	
	
	public LoginBO getLoginBo() {
		return loginBo;
	}


	public void setLoginBo(LoginBO loginBo) {
		this.loginBo = loginBo;
	}


	@RequestMapping(value=HtmConstants.USER_AUTH,method=RequestMethod.POST)
	public String userAunth(Model model,HttpServletRequest request,HttpServletResponse resopnse,@ModelAttribute("user") LoginBean loginUser){
			String redirect="index";
			LoginDTO dto=new LoginDTO();
			if(loginUser.getUserName().equals("") && loginUser.getUserName()==null){
				model.addAttribute("status","userNameBlank");
			}else if(loginUser.getPassword().equals("") && loginUser.getPassword()==null){
				model.addAttribute("status","passwordBlank");
			}else{
				dto.setUserName(loginUser.getUserName());
				dto.setPassword(loginUser.getPassword());
				try {
					LoginDTO loginDTO=this.getLoginBo().userAuth(dto);
					if(loginDTO.getStatus().equalsIgnoreCase("success")){
						model.addAttribute("status","SUCCESS");		
						HttpSession session=request.getSession();
						session.setAttribute("employeeId", loginDTO.getEmployeeId());
						model.addAttribute("noCustomer",2);
						redirect="dashboard";
					}else{
						model.addAttribute("status","INVALID");
					}
				} catch (Exception e) {
					e.printStackTrace();						
					model.addAttribute("status","INVALID");
				}finally{
					model.addAttribute("user",new LoginBean());
				}
			}
		
		return redirect;
		
	}
	
}
