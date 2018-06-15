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

import com.shopping.global.bean.AddStockBean;
import com.shopping.global.bean.WildCardSearchBean;
import com.shopping.global.bo.ProductServiceBO;
import com.shopping.global.constants.Constants;
import com.shopping.global.constants.HtmConstants;
import com.shopping.global.dto.ProductQuanityDetailsDTO;
import com.shopping.global.dto.StockSearchDTO;
import com.shopping.global.services.ResponseDTO;

@Controller
public class StockController {
	final static Logger logger = LoggerFactory.getLogger(StockController.class);

	@Autowired
	private ProductServiceBO productServiceBO;
	
	
	@RequestMapping(value=HtmConstants.ADD_STOCK_PAGE)
	public String redirectToCustomerAddPage(Model model) {
		model.addAttribute("addstockDetails",new AddStockBean());
		return "addStock";
	}
	@RequestMapping(value=HtmConstants.ADD_STOCK,method=RequestMethod.POST)
	public String addNewStock(@ModelAttribute("addstockDetails")AddStockBean stockDetails, BindingResult result, ModelMap model) {
		ResponseDTO response=productServiceBO.validateAndSaveProductDetails(stockDetails);
		
		if(response.getStatus().equalsIgnoreCase(Constants.SUCCESS)){
			model.addAttribute("addstockDetails",new AddStockBean());
			model.addAttribute("message",response.getMessage());
			model.addAttribute("status",Constants.SUCCESS);
			model.addAttribute("searchHappen","true");
		}
		else{
			model.addAttribute("addstockDetails",new AddStockBean());
			model.addAttribute("status",response.getStatus());
			model.addAttribute("message",response.getMessage());
		}
		return "addStock";
	}
	
	@RequestMapping(value=HtmConstants.VIEW_PRODUCT_PAGE,method={RequestMethod.GET,RequestMethod.POST})
	public String redirectToStockViewPage(Model model, HttpServletRequest request,@ModelAttribute("stockSearchDetails")WildCardSearchBean stockSearchDetails) {
		logger.debug("redirectToCustomerViewPage :START");
		if(null !=stockSearchDetails){
			if(!StringUtils.isEmpty(stockSearchDetails.getSearchString())){
				ResponseDTO response=productServiceBO.validateAndSearchStockDetails(stockSearchDetails);
				model.addAttribute("stockList",prepareStockList(response));
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
		return "viewStock";
	}
	private List<StockSearchDTO>prepareStockList(ResponseDTO response){
		@SuppressWarnings("unchecked")
		List<StockSearchDTO> stockSearchDTOList= (List<StockSearchDTO>) response.getResponseObject();
		return stockSearchDTOList;
	}
	
	@RequestMapping(value=HtmConstants.VIEW_PRODUCT_DETAILS,method={RequestMethod.GET})
	public  ModelAndView  fetchStockDetails(Model model, HttpServletRequest request,@ModelAttribute("productId")String productId) {
		logger.debug("redirectToCustomerViewPage :START");
			if(!StringUtils.isEmpty(productId)){
				WildCardSearchBean wildCardSearchBean=new WildCardSearchBean();
				wildCardSearchBean.setSearchString(productId);
				ResponseDTO response=productServiceBO.validateAndFetchProductDetails(wildCardSearchBean);
				model.addAttribute("productDetails",prepareProdctDetailsDTO(response));
				model.addAttribute("searchHappen","true");
			}	
			else{
				model.addAttribute("customerSearchDetails",new WildCardSearchBean());
			}
		logger.debug("redirectToCustomerViewPage :END");
        return new ModelAndView( "productSubView" );

	}
	private List<ProductQuanityDetailsDTO>prepareProdctDetailsDTO(ResponseDTO response){
		@SuppressWarnings("unchecked")
		List<ProductQuanityDetailsDTO> productDetails= (List<ProductQuanityDetailsDTO>) response.getResponseObject();
		return productDetails;
	}
}
