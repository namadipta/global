package com.shopping.global.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.global.bean.CustomerDetailsBean;
import com.shopping.global.bean.WildCardSearchBean;
import com.shopping.global.constants.Constants;
import com.shopping.global.services.CustomerService;
import com.shopping.global.services.ResponseDTO;



@Component
public class CustomerServiceBO {
	@Autowired
	private CustomerService customerService;



	public ResponseDTO validateAndSaveCustomerDetails(CustomerDetailsBean customerDetails) {
		ResponseDTO response=null;
		try {
			response=customerService.validationForMandatoryField(customerDetails);
			if(response.getStatus().equalsIgnoreCase(Constants.SUCCESS)){
				response=customerService.saveCustomerDetails(customerDetails);
			}
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			if(e.getCause().getMessage().contains("Duplicate")){
				response.setMessage("Customer is already present having same details.");
			}
			response.setResponseObject(e);
		}
		return response;
	}
	public ResponseDTO validateAndSearchCustomerDetails(WildCardSearchBean customerSearchDetails) {
		ResponseDTO response=null;
		try {
			
				response=customerService.searchCustomerDetails(customerSearchDetails);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		return response;
	}
	public ResponseDTO validateAndFetchCustomerDues(WildCardSearchBean customerSearchDetails) {
		ResponseDTO response=null;
		try {
			
				response=customerService.searchCustomerDues(customerSearchDetails);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		return response;
	}
	
	public ResponseDTO validateAndFetchCustomerDueDetails(WildCardSearchBean customerSearchDetails) {
		ResponseDTO response=null;
		try {
			
				response=customerService.searchCustomerDueDetails(customerSearchDetails);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		return response;
	}
}
