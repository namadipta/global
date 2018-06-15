package com.shopping.global.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.global.bean.NewBillDetailsBean;
import com.shopping.global.constants.Constants;
import com.shopping.global.dto.ListOfProductQuanityDetailsDTO;
import com.shopping.global.dto.ProductQuanityDetailsDTO;
import com.shopping.global.services.BillService;
import com.shopping.global.services.ResponseDTO;
@Component
public class BillServiceBO {
	@Autowired
	private BillService billService;



	public ResponseDTO validateAndSearchStockDetails() {
		ResponseDTO response=null;
		try {
			
			NewBillDetailsBean newBilDetailsBean=billService.searchStockDetails();
			response=new ResponseDTO();
			response.setResponseObject(newBilDetailsBean);
			response.setStatus(Constants.SUCCESS);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		return response;
	}
	public ResponseDTO validateAndSearchBathcNoDetails(String SearchItemDetails) {
		ResponseDTO response=null;
		try {
			
				response=billService.validateAndSearchBathcNoDetails(SearchItemDetails);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		return response;
	}
	
	public ResponseDTO validateBillItem(ListOfProductQuanityDetailsDTO billItem) {
		ResponseDTO response=null;
		try {
			
				response=billService.validateBillItem(billItem);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		return response;
	}
}
