package com.shopping.global.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.global.bean.AddStockBean;
import com.shopping.global.bean.WildCardSearchBean;
import com.shopping.global.constants.Constants;
import com.shopping.global.services.ResponseDTO;
import com.shopping.global.services.StockService;



@Component
public class ProductServiceBO {
	@Autowired
	private StockService stockService;



	public ResponseDTO validateAndSaveProductDetails(AddStockBean stockDetails) {
		ResponseDTO response=null;
		try {
			response=stockService.validationForMandatoryField(stockDetails);
			if(response.getStatus().equalsIgnoreCase(Constants.SUCCESS)){
				response=stockService.saveNewStockDetails(stockDetails);
			}
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		return response;
	}
	public ResponseDTO validateAndSearchStockDetails(WildCardSearchBean stockSearchDetails) {
		ResponseDTO response=null;
		try {
			
				response=stockService.searchStockDetails(stockSearchDetails);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		return response;
	}
	public ResponseDTO validateAndFetchProductDetails(WildCardSearchBean customerSearchDetails) {
		ResponseDTO response=null;
		try {
			
				response=stockService.searchProdcuDetails(customerSearchDetails);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		return response;
	}
}
