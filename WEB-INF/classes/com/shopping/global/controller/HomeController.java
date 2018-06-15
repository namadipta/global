package com.shopping.global.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.global.bean.LoginBean;
import com.shopping.global.constants.HtmConstants;

@Controller
public class HomeController {

//	@RequestMapping(value="/")
//	public String home(Model model) {
//		model.addAttribute("user",new LoginBean());
//		return "index";
//	}
	@RequestMapping(value=HtmConstants.LOGIN)
	public String login(Model model) {
		model.addAttribute("user",new LoginBean());
		return "index";
	}
	
	@RequestMapping(value=HtmConstants.RECOVER_PSWRD)
	public String recoverPassword(Model model) {
		//model.addAttribute("user",new LoginBean());
		return "recoverpw";
	}
	
	@RequestMapping(value=HtmConstants.DASHBOARD)
	public String dashboard(Model model) {
		model.addAttribute("user",new LoginBean());
		return "dashboard";
	}
	
	@RequestMapping(value=HtmConstants.LOGOUT)
	public String logout(HttpServletRequest request,HttpServletResponse response,Model model){
		    HttpSession session=request.getSession();
		    session.invalidate();
			return "redirect:/";
			
	 }
	@RequestMapping(value=HtmConstants.NEW_REGISTER)
	public String redirectToNewRegisterPage(Model model) {
		//model.addAttribute("customerDetails",new CustomerDetailsBean());
		return "register";
	}
	
	@RequestMapping(value=HtmConstants.REGISTER)
	public String register(Model model) {
		model.addAttribute("user",new LoginBean());
		return "index";
	}
	
}
