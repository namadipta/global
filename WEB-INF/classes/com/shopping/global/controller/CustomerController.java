package com.shopping.global.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.global.bean.CustomerDetailsBean;
import com.shopping.global.bean.WildCardSearchBean;
import com.shopping.global.bo.CustomerServiceBO;
import com.shopping.global.constants.Constants;
import com.shopping.global.constants.HtmConstants;
import com.shopping.global.dto.CustomerDueDTO;
import com.shopping.global.dto.CustomerDueDetailsBean;
import com.shopping.global.dto.CustomerSearchDTO;
import com.shopping.global.services.ResponseDTO;

@Controller
public class CustomerController {

	@Autowired
	private CustomerServiceBO customerService;
	
	final static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	@RequestMapping(value=HtmConstants.ADD_CUSTOMER_PAGE)
	public String redirectToCustomerAddPage(Model model) {
		model.addAttribute("customerDetails",new CustomerDetailsBean());
		return "addCustomer";
	}
	@RequestMapping(value=HtmConstants.VIEW_CUSTOMER_PAGE,method={RequestMethod.GET,RequestMethod.POST})
	public String redirectToCustomerViewPage(Model model, HttpServletRequest request,@ModelAttribute("customerSearchDetails")WildCardSearchBean customerSearchDetails) {
		logger.debug("redirectToCustomerViewPage :START");
		if(null !=customerSearchDetails){
			if(!StringUtils.isEmpty(customerSearchDetails.getSearchString())){
				ResponseDTO response=customerService.validateAndSearchCustomerDetails(customerSearchDetails);
				model.addAttribute("customerList",prepareCustomerList(response));
				model.addAttribute("searchHappen","true");
			}	
			else{
				model.addAttribute("customerSearchDetails",new WildCardSearchBean());
			}
		}
		else{
			model.addAttribute("customerSearchDetails",new WildCardSearchBean());
		}
		logger.debug("redirectToCustomerViewPage :END");
		return "viewCustomer";
	}
	@RequestMapping(value=HtmConstants.ADD_CUSTOMER,method=RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customerDetails")CustomerDetailsBean customerDetails, BindingResult result, ModelMap model) {
		ResponseDTO response=customerService.validateAndSaveCustomerDetails(customerDetails);
		
		if(response.getStatus().equalsIgnoreCase(Constants.SUCCESS)){
			model.addAttribute("customerDetails",new CustomerDetailsBean());
			model.addAttribute("message",response.getMessage());
			model.addAttribute("status",Constants.SUCCESS);
			model.addAttribute("searchHappen","true");
		}
		else{
			model.addAttribute("customerDetails",new CustomerDetailsBean());
			model.addAttribute("status",response.getStatus());
			model.addAttribute("message",response.getMessage());
			model.addAttribute("searchHappen","true");

		}
		return "addCustomer";
	}
	private List<CustomerSearchDTO>prepareCustomerList(ResponseDTO response){
		@SuppressWarnings("unchecked")
		List<CustomerSearchDTO> customerSearchDTOList= (List<CustomerSearchDTO>) response.getResponseObject();
		return customerSearchDTOList;
	}
	private List<CustomerDueDTO>prepareCustomerDueDTO(ResponseDTO response){
		@SuppressWarnings("unchecked")
		List<CustomerDueDTO> customerDue= (List<CustomerDueDTO>) response.getResponseObject();
		return customerDue;
	}
	private List<CustomerDueDetailsBean>prepareCustomerDueDetails(ResponseDTO response){
		@SuppressWarnings("unchecked")
		List<CustomerDueDetailsBean> customerDue= (List<CustomerDueDetailsBean>) response.getResponseObject();
		return customerDue;
	}
	
	@RequestMapping(value=HtmConstants.VIEW_CUSTOMER_DUES,method={RequestMethod.GET})
	public  ModelAndView  fetchCustomerDues(Model model, HttpServletRequest request,@ModelAttribute("customerId")String customerId) {
		logger.debug("redirectToCustomerViewPage :START");
			if(!StringUtils.isEmpty(customerId)){
				WildCardSearchBean wildCardSearchBean=new WildCardSearchBean();
				wildCardSearchBean.setSearchString(customerId);
				ResponseDTO response=customerService.validateAndFetchCustomerDues(wildCardSearchBean);
				model.addAttribute("customerDue",prepareCustomerDueDTO(response));
				model.addAttribute("searchHappen","true");
			}	
			else{
				model.addAttribute("customerSearchDetails",new WildCardSearchBean());
			}
		logger.debug("redirectToCustomerViewPage :END");
        return new ModelAndView( "customerSubView" );

	}
	@RequestMapping(value=HtmConstants.VIEW_CUSTOMER_DUES_DETAILS,method={RequestMethod.GET})
	public  ModelAndView  fetchCustomerDueDetails(Model model, HttpServletRequest request,@ModelAttribute("customerId")String customerId) {
		logger.debug("redirectToCustomerViewPage :START");
			if(!StringUtils.isEmpty(customerId)){
				WildCardSearchBean wildCardSearchBean=new WildCardSearchBean();
				wildCardSearchBean.setSearchString(customerId);
				ResponseDTO response=customerService.validateAndFetchCustomerDueDetails(wildCardSearchBean);
				model.addAttribute("customerDueDetails",prepareCustomerDueDetails(response));
				model.addAttribute("totalBalance","1000");
				model.addAttribute("searchHappen","true");
			}	
			else{
				model.addAttribute("customerSearchDetails",new WildCardSearchBean());
			}
		logger.debug("redirectToCustomerViewPage :END");
        return new ModelAndView( "customerDueDetails" );

	}
}
