package com.shopping.global.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.shopping.global.bean.NewBillDetailsBean;
import com.shopping.global.constants.Constants;
import com.shopping.global.dao.BillDAO;
import com.shopping.global.dao.CustomerDAO;
import com.shopping.global.dao.StockDAO;
import com.shopping.global.dto.CustomerSearchDTO;
import com.shopping.global.dto.ListOfProductQuanityDetailsDTO;
import com.shopping.global.dto.NewBillProductDTO;
import com.shopping.global.dto.ProductQuanityDetailsDTO;
import com.shopping.global.exception.QuantityMoreException;
import com.shopping.global.model.TdProductQuanityDetail;
@Component
public class BillService {
	@Autowired
	private StockDAO stockDAO;

	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private BillDAO billDAO;
	
	public NewBillDetailsBean searchStockDetails(){
		NewBillDetailsBean newBilDetailsBean=new NewBillDetailsBean();
		try {
			List<ProductQuanityDetailsDTO> ProductQuanityDetailsDTOList=stockDAO.searchStockNames();
			List<CustomerSearchDTO> listofCustomers=customerDAO.fetchAllCustomers();
			newBilDetailsBean.setListofCustomers(listofCustomers);
			newBilDetailsBean.setProductQuanityDetailsDTOList(ProductQuanityDetailsDTOList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newBilDetailsBean;
	}
	public ResponseDTO validateAndSearchBathcNoDetails(String SearchItemDetails){
		ResponseDTO resposne=new ResponseDTO();
		resposne.setStatus(Constants.SUCCESS);
		try {
			resposne=stockDAO.validateAndSearchBathcNoDetails(SearchItemDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resposne;
	}
	
	public ResponseDTO validateBillItem(ListOfProductQuanityDetailsDTO billItem){
		ResponseDTO resposne=new ResponseDTO();
		resposne.setStatus(Constants.SUCCESS);
		List<TdProductQuanityDetail> stockDetailsList=new ArrayList<TdProductQuanityDetail>();
		List<NewBillProductDTO> temporaryList=new ArrayList<NewBillProductDTO>();
		temporaryList.addAll(billItem.getBillItems());
		List<NewBillProductDTO> temporaryList2=new ArrayList<NewBillProductDTO>();
		try {
			for(int i=0;i< temporaryList.size();i++){
				if(!StringUtils.isEmpty(temporaryList.get(i).getProductId())){
					temporaryList2.add(temporaryList.get(i));
				}
			}
			billItem.setBillItems(temporaryList2);
			//Same productId added twice
			for(int i=0;i<billItem.getBillItems().size();i++){
				String productId=billItem.getBillItems().get(i).getProductId();
				for(int j=1;j<billItem.getBillItems().size();j++){
					if(productId.equalsIgnoreCase(billItem.getBillItems().get(j).getProductId())){
						BigInteger tempquantity=billItem.getBillItems().get(j).getQuantity();
						BigInteger existQuantity=billItem.getBillItems().get(i).getQuantity();
						BigInteger finalQuantity= tempquantity.add(existQuantity);
						billItem.getBillItems().get(i).setQuantity(finalQuantity);
						billItem.getBillItems().remove(j);
					}
				}
			}
			billItem.getBillItems().sort((o1, o2) -> o1.getProductId().compareTo(o2.getProductId()));
			stockDetailsList=stockDAO.fetchBillItem(billItem);
			stockDetailsList.sort((o1, o2) -> o1.getProductId().compareTo(o2.getProductId()));
			for(int i=0;i< billItem.getBillItems().size();i++){
				if(billItem.getBillItems().get(i).getProductId().equalsIgnoreCase(stockDetailsList.get(i).getProductId().toString())){
					if(billItem.getBillItems().get(i).getQuantity().intValue() > stockDetailsList.get(i).getProductQuantity().intValue()){
						throw new QuantityMoreException();
					}
				}
			}
			resposne=billDAO.saveBillDetails(billItem);
			
			//GenerateBill Download Bill Email Bill
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resposne;
	}
}
