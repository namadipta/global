package com.shopping.global.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.shopping.global.bean.CustomerDetailsBean;
import com.shopping.global.bean.WildCardSearchBean;
import com.shopping.global.constants.Constants;
import com.shopping.global.dao.CustomerDAO;
import com.shopping.global.model.TdCustomerDetail;
import com.shopping.global.util.DateUtil;
@Component
public class CustomerService {


	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private DateUtil dateUtil;
	public ResponseDTO validationForMandatoryField(CustomerDetailsBean customerDetails){
		ResponseDTO resposne=new ResponseDTO();
		resposne.setStatus(Constants.SUCCESS);
		if(StringUtils.isEmpty(customerDetails.getGnumber())){
			resposne.setStatus(Constants.ERROR);
			resposne.setMessage("Godown Numer can not be blank");
		}else if(StringUtils.isEmpty(customerDetails.getMobile())){
			resposne.setStatus(Constants.ERROR);
			resposne.setMessage("Mobile Numer can not be blank");
		}else if(StringUtils.isEmpty(customerDetails.getName())){
			resposne.setStatus(Constants.ERROR);
			resposne.setMessage("Name can not be blank");
		}
		return resposne;
	}
	public ResponseDTO searchCustomerDetails(WildCardSearchBean customerSearchDetails) throws Exception{
		ResponseDTO response=null;

		response=customerDAO.searchCustomerDetails(customerSearchDetails);
		return response;
	}
	public ResponseDTO searchCustomerDues(WildCardSearchBean customerSearchDetails) throws Exception{
		ResponseDTO response=null;

		response=customerDAO.searchCustomerDues(customerSearchDetails);
		return response;
	}
	public ResponseDTO searchCustomerDueDetails(WildCardSearchBean customerSearchDetails) throws Exception{
		ResponseDTO response=null;

		response=customerDAO.searchCustomerDueDetails(customerSearchDetails);
		return response;
	}
	
	public ResponseDTO saveCustomerDetails(CustomerDetailsBean customerDetails) throws Exception{
		ResponseDTO response=null;
		try {
			TdCustomerDetail customerDetailsForDAO=new TdCustomerDetail();
			customerDetailsForDAO.setAddress(customerDetails.getAddress());
			customerDetailsForDAO.setCity(customerDetails.getCity());
			customerDetailsForDAO.setDob(dateUtil.stringToDate(customerDetails.getDob()));
			customerDetailsForDAO.setEmail(customerDetails.getEmail());
			customerDetailsForDAO.setLandline(customerDetails.getSphone());
			customerDetailsForDAO.setSecondaryPhone(customerDetails.getSphone());
			customerDetailsForDAO.setMobile(customerDetails.getMobile());
			customerDetailsForDAO.setName(customerDetails.getName());
			customerDetailsForDAO.setState(customerDetails.getState());
			customerDetailsForDAO.setGodownNo(customerDetails.getGnumber());
			response=customerDAO.saveCustomerDetails(customerDetailsForDAO);
		} catch (Exception e) {
			throw e;
		}		
		return response;
	}


}
