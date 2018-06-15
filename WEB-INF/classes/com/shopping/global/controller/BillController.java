package com.shopping.global.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopping.global.bean.NewBillDetailsBean;
import com.shopping.global.bo.BillServiceBO;
import com.shopping.global.constants.Constants;
import com.shopping.global.constants.HtmConstants;
import com.shopping.global.dto.ListOfProductQuanityDetailsDTO;
import com.shopping.global.dto.NewBillProductDTO;
import com.shopping.global.services.ResponseDTO;
import com.shopping.global.util.ReportUtil;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class BillController {

	@Autowired
	private BillServiceBO billService;

	final static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	@RequestMapping(value=HtmConstants.NEW_BILL_PAGE,method={RequestMethod.GET,RequestMethod.POST})
	public String redirectToNewBillPage(Model model) {
		ResponseDTO response=new ResponseDTO();
		try {
			response=billService.validateAndSearchStockDetails();
			NewBillDetailsBean newBillDetailsBean=new NewBillDetailsBean();
			newBillDetailsBean=prepareNewBillBean(response);
			model.addAttribute("stockList",newBillDetailsBean.getProductQuanityDetailsDTOList());
			model.addAttribute("customerList",newBillDetailsBean.getListofCustomers());
			ListOfProductQuanityDetailsDTO detailsDTo=new ListOfProductQuanityDetailsDTO();
			generateRows(detailsDTo,Constants.numberOfInitialRows);
			model.addAttribute("billItem",detailsDTo);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "newBill";
	}
	private NewBillDetailsBean prepareNewBillBean(ResponseDTO response){
		NewBillDetailsBean newBillDetailsBean= (NewBillDetailsBean) response.getResponseObject();
		return newBillDetailsBean;
	}
	@RequestMapping(value=HtmConstants.GET_PRODUCT_DETAILS,method={RequestMethod.GET})
	public  @ResponseBody String fetchProductDetails(Model model, HttpServletRequest request,@RequestParam("productFetchDetails")String productFetchDetails) throws JsonProcessingException {
		ResponseDTO response=new ResponseDTO();
		Map<String,Object>  returnMap=new HashMap<String,Object>();
		try {
			response=billService.validateAndSearchBathcNoDetails(productFetchDetails);
			@SuppressWarnings("unchecked")
			List<String> batchNumberList=(List<String>) response.getResponseObject();
			model.addAttribute("batchNumberList",batchNumberList);
			returnMap.put("batchNumberList",batchNumberList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();

		return mapper.writeValueAsString(returnMap);
	}

	@RequestMapping(value=HtmConstants.NEW_BILL,method={RequestMethod.POST})
	public String generateNewBill(Model model, HttpServletRequest request,HttpServletResponse httpResponse,@ModelAttribute("billItem")ListOfProductQuanityDetailsDTO billItem) {
		ResponseDTO response=new ResponseDTO();
		try {
			PrepareInputForService(billItem);
			response=billService.validateBillItem(billItem);
			model.addAttribute("message",response.getMessage());
			response=billService.validateAndSearchStockDetails();
			NewBillDetailsBean newBillDetailsBean=new NewBillDetailsBean();
			newBillDetailsBean=prepareNewBillBean(response);
			model.addAttribute("stockList",newBillDetailsBean.getProductQuanityDetailsDTOList());
			model.addAttribute("customerList",newBillDetailsBean.getListofCustomers());
			ListOfProductQuanityDetailsDTO detailsDTo=new ListOfProductQuanityDetailsDTO();
			generateRows(detailsDTo,Constants.numberOfInitialRows);
			model.addAttribute("billItem",detailsDTo);
			List<ListOfProductQuanityDetailsDTO>printDTOList=new ArrayList<ListOfProductQuanityDetailsDTO>();
			printDTOList.add(billItem);
			JRBeanCollectionDataSource datasource=new JRBeanCollectionDataSource(printDTOList);
			JasperReport report=ReportUtil.getCompiledFile("Employee", request);
			ReportUtil.generateReportPDF(httpResponse, new HashMap(), report,datasource);
			
			
			model.addAttribute("status",Constants.SUCCESS);
			model.addAttribute("searchHappen","true");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("status",response.getStatus());
			model.addAttribute("message",response.getMessage());
			model.addAttribute("searchHappen","true");
		}

		return "newBill";
	}
	private void PrepareInputForService(ListOfProductQuanityDetailsDTO billItem){

		if(null !=billItem){
			if(! CollectionUtils.isEmpty(billItem.getBillItems())){
				for(NewBillProductDTO itemDetails: billItem.getBillItems()){
					if(! itemDetails.getProductName().equals("#")){
						String productNameInput=itemDetails.getProductName();
						String [] productNameSplited=productNameInput.split("###");
						itemDetails.setProductName(productNameSplited[1]);
						itemDetails.setProductId(productNameSplited[0]);
					}
					
				}
			}
			if(!StringUtils.isEmpty(billItem.getCustomerDetails())){
				if(! billItem.getCustomerDetails().equals("#")){
					String [] customerDetailsArray=billItem.getCustomerDetails().split("###");
					billItem.setCustomerName(customerDetailsArray[0]);
					billItem.setCustomerId(customerDetailsArray[1]);
					billItem.setGodownNo(customerDetailsArray[2]);
				}
			}
				billItem.setDueAmount(billItem.getBillAmount()-billItem.getPaidAmount());
		}

	}
	@RequestMapping(value=HtmConstants.ADD_NEW_ROWS_FOR_BILL,method={RequestMethod.GET,RequestMethod.POST})
	public String addRowsForBill(Model model,@ModelAttribute("numberOfRows")String numberOfRows,@ModelAttribute("billItem")ListOfProductQuanityDetailsDTO billItem) {
		ResponseDTO response=new ResponseDTO();
		try {
			response=billService.validateAndSearchStockDetails();
			NewBillDetailsBean newBillDetailsBean=new NewBillDetailsBean();
			newBillDetailsBean=prepareNewBillBean(response);
			model.addAttribute("stockList",newBillDetailsBean.getProductQuanityDetailsDTOList());
			model.addAttribute("customerList",newBillDetailsBean.getListofCustomers());
			ListOfProductQuanityDetailsDTO detailsDTo=new ListOfProductQuanityDetailsDTO();
			generateRows(billItem,Integer.parseInt(numberOfRows));
			model.addAttribute("billItem",detailsDTo);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "newBill";
	}
	
	private void generateRows(ListOfProductQuanityDetailsDTO billItems,int numberOfRows){
		List<NewBillProductDTO> newRowList=new ArrayList<NewBillProductDTO>();
		for(int i=0;i<numberOfRows;i++){
			NewBillProductDTO dto=new NewBillProductDTO();
			newRowList.add(dto);
		}
		billItems.setBillItems(newRowList);
	}
}
