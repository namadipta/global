package com.shopping.global.services;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.shopping.global.bean.AddStockBean;
import com.shopping.global.bean.WildCardSearchBean;
import com.shopping.global.constants.Constants;
import com.shopping.global.dao.StockDAO;
import com.shopping.global.model.TdProductQuanityDetail;
import com.shopping.global.util.DateUtil;
@Component
public class StockService {


	@Autowired
	private StockDAO stockDAO;

	@Autowired
	private DateUtil dateUtils;
	
	public ResponseDTO validationForMandatoryField(AddStockBean stockDetails){
		ResponseDTO resposne=new ResponseDTO();
		resposne.setStatus(Constants.SUCCESS);
		if(StringUtils.isEmpty(stockDetails.getProductName())){
			resposne.setStatus(Constants.ERROR);
			resposne.setMessage("ProductName can not be blank");
		}else if(StringUtils.isEmpty(stockDetails.getPurchasePrice())){
			resposne.setStatus(Constants.ERROR);
			resposne.setMessage("Puchase price can not be blank");
		}else if(StringUtils.isEmpty(stockDetails.getQuantity())){
			resposne.setStatus(Constants.ERROR);
			resposne.setMessage("Qunatity can not be blank");
		}
		return resposne;
	}
	
	
	
	public ResponseDTO saveNewStockDetails(AddStockBean stockDetails) throws Exception{
		ResponseDTO response=null;
		try {
			TdProductQuanityDetail tdProductQuanityDetail=new TdProductQuanityDetail();
			tdProductQuanityDetail.setProductName(stockDetails.getProductName());
			tdProductQuanityDetail.setProductDesc(stockDetails.getProductDescription());
			tdProductQuanityDetail.setProductBatchNo(stockDetails.getBatch());
			tdProductQuanityDetail.setProductExpiryDt(dateUtils.stringToDate(stockDetails.getExpdate()));
			tdProductQuanityDetail.setProductExtraInfo(stockDetails.getProductExtraInfo());
			tdProductQuanityDetail.setProductLocation(stockDetails.getProductLocation());
			tdProductQuanityDetail.setProductMfgDt(dateUtils.stringToDate(stockDetails.getMfgdate()));
			tdProductQuanityDetail.setProductPurchasePrice(new Double(stockDetails.getPurchasePrice()));
			tdProductQuanityDetail.setProductPurchaseVat(new Double(stockDetails.getPurchaseVat()));
			tdProductQuanityDetail.setProductQuantity(new BigInteger(stockDetails.getQuantity()));
			tdProductQuanityDetail.setProductSellingPrice(new Double(stockDetails.getSellingPrice()));
			tdProductQuanityDetail.setProductSellVat(new Double(stockDetails.getSellingVat()));
			response=stockDAO.saveStockDetails(tdProductQuanityDetail);
		} catch (Exception e) {
			throw e;
		}		
		return response;
	}
	public ResponseDTO searchStockDetails(WildCardSearchBean stockSearchDetails) throws Exception{
		ResponseDTO response=null;

		response=stockDAO.searchStockDetails(stockSearchDetails);
		return response;
	}
	public ResponseDTO searchProdcuDetails(WildCardSearchBean productSearchDetails) throws Exception{
		ResponseDTO response=null;

		response=stockDAO.searchProdcuDetails(productSearchDetails);
		return response;
	}

}
