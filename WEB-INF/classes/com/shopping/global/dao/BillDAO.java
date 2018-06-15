package com.shopping.global.dao;

import java.math.BigInteger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.global.constants.Constants;
import com.shopping.global.dto.ListOfProductQuanityDetailsDTO;
import com.shopping.global.dto.NewBillProductDTO;
import com.shopping.global.exception.UnknownDbError;
import com.shopping.global.model.TdCustomerBalance;
import com.shopping.global.model.TdCustomerBalanceDetail;
import com.shopping.global.model.TdItemDetailsForBill;
import com.shopping.global.model.TdProductQuanityDetail;
import com.shopping.global.model.TdPurchaseHistory;
import com.shopping.global.services.ResponseDTO;



@Component
public class BillDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public ResponseDTO saveBillDetails(ListOfProductQuanityDetailsDTO billItem) throws Exception{
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			TdPurchaseHistory tdPurchaseHistory	=new TdPurchaseHistory();		
			Boolean productQuantityStatus=false;
			Boolean customerDueStatus=false;
			Boolean customerTotalDueStatus=false;
			Boolean updateItemDetailsForBillStatus=false;
			tdPurchaseHistory.setBasicAmount(billItem.getBasicAmount());
			tdPurchaseHistory.setBillAmount(billItem.getBillAmount());
			tdPurchaseHistory.setBillDate(billItem.getBillDate());
			tdPurchaseHistory.setCustomerId(new BigInteger(billItem.getCustomerId()));
			tdPurchaseHistory.setDueAmount(billItem.getDueAmount());
			tdPurchaseHistory.setGodownNo(billItem.getGodownNo());
			tdPurchaseHistory.setPaidAmount(billItem.getPaidAmount());
			tdPurchaseHistory.setPaymentType("CASH");
			tdPurchaseHistory.setVatAmount(billItem.getVatAmount());
			try {
				tx.begin();
				session.save(tdPurchaseHistory);
				tx.commit();
				if(!tdPurchaseHistory.getBillNo().toString().isEmpty()){
					 productQuantityStatus=updateQuantityDetails(billItem);
					 updateItemDetailsForBillStatus=updateItemDetailsForBill(billItem,tdPurchaseHistory.getBillNo());
					 customerDueStatus=updateCustomerDues(billItem,tdPurchaseHistory.getBillNo());
					 customerTotalDueStatus=updateCustomerTotalDue(billItem);
				}
				if(productQuantityStatus && customerDueStatus && customerTotalDueStatus && updateItemDetailsForBillStatus){
					responseDTO.setStatus(Constants.SUCCESS);
					responseDTO.setMessage(tdPurchaseHistory.getBillNo().toString());
				}else{
					throw new UnknownDbError();
				}
				
			} catch (Exception e) {
				tx.rollback();
				responseDTO.setStatus(Constants.FAILURE);
				throw e;
			}finally{
				try {					
					session.close();
				} catch (Exception e2) {
					tx.rollback();
					responseDTO.setStatus(Constants.FAILURE);
					throw e2;
				}
			}
			
		} catch (Exception e) {
			responseDTO.setStatus(Constants.FAILURE);
			throw e;
		}
		
		return responseDTO;
	}
	private Boolean updateCustomerDues(ListOfProductQuanityDetailsDTO billItem,BigInteger billNo){
		Boolean customerDueStatus=false;
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			TdCustomerBalanceDetail tdCustomerBalanceDetail	=new TdCustomerBalanceDetail();	
			tdCustomerBalanceDetail.setBillAmount(billItem.getBillAmount());
			tdCustomerBalanceDetail.setBillDate(billItem.getBillDate().toString());
			tdCustomerBalanceDetail.setBillNo(billNo);
			tdCustomerBalanceDetail.setCustomerId(new BigInteger(billItem.getCustomerId()));
			tdCustomerBalanceDetail.setDueAmount(billItem.getDueAmount());
			tdCustomerBalanceDetail.setGoddownNo(billItem.getGodownNo());
			tdCustomerBalanceDetail.setName(billItem.getCustomerName());
			tdCustomerBalanceDetail.setPaidAmount(billItem.getPaidAmount());
			try {
				tx.begin();
				session.save(tdCustomerBalanceDetail);
				tx.commit();
				if(!tdCustomerBalanceDetail.getBalanceDetailsCode().toString().isEmpty()){
					customerDueStatus=true;
				}
			} catch (Exception e) {
				tx.rollback();
				throw e;
			}finally{
				try {					
					session.close();
				} catch (Exception e2) {
					tx.rollback();
					throw e2;
				}
			}
			
		} catch (Exception e) {
			throw e;
		}
		
		return customerDueStatus;
	}
	private Boolean updateItemDetailsForBill(ListOfProductQuanityDetailsDTO billItem,BigInteger billNo) throws Exception{
		Boolean itemDetailsStatus=false;
		try {
			for(NewBillProductDTO newBillProductDTO :billItem.getBillItems()){
				updateitemDetailsForBill(newBillProductDTO,billNo);
			}
			itemDetailsStatus=true;
		}
		catch (Exception e) {
			throw e;
		}
		return itemDetailsStatus;
	}
	private void updateitemDetailsForBill(NewBillProductDTO billedItem,BigInteger billNo) throws Exception{
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			TdItemDetailsForBill tdItemDetailsForBill=new TdItemDetailsForBill();
			tdItemDetailsForBill.setBillNo(billNo);
			tdItemDetailsForBill.setProductId(new BigInteger(billedItem.getProductId()));
			tdItemDetailsForBill.setQuantity(billedItem.getQuantity());
			tdItemDetailsForBill.setSellPrice(billedItem.getPrice());
			try {
				tx.begin();
				session.save(tdItemDetailsForBill);
				tx.commit();
				if(tdItemDetailsForBill.getBillItemDetails().toString().isEmpty()){
					throw new UnknownDbError();
				}
			}
			catch (Exception e) {
				tx.rollback();
				throw e;
			}finally{
				try {					
					session.close();
				} catch (Exception e2) {
					tx.rollback();
					throw e2;
				}
			}
			
		}
		catch (Exception e) {
			throw e;
		}
		
	}
	private Boolean updateCustomerTotalDue(ListOfProductQuanityDetailsDTO billItem){
		Boolean customerTotalDueStatus=false;
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				Object o=session.get(TdCustomerBalance.class,new BigInteger(billItem.getCustomerId()));
				if(null != o){
					TdCustomerBalance tdCustomerBalance=(TdCustomerBalance)o;
					Double dbQuanity=tdCustomerBalance.getTotalBalance();
					Double val= dbQuanity+billItem.getDueAmount();
					tdCustomerBalance.setTotalBalance(val);
					tx.commit();
					customerTotalDueStatus=true;
				}
				else{
					TdCustomerBalance tdCustomerBalance=new TdCustomerBalance();
					tdCustomerBalance.setCustomerId(new BigInteger(billItem.getCustomerId()));
					tdCustomerBalance.setGodownno(billItem.getGodownNo());
					tdCustomerBalance.setName(billItem.getCustomerName());
					tdCustomerBalance.setTotalBalance(billItem.getDueAmount());
					session.save(tdCustomerBalance);
					tx.commit();
					customerTotalDueStatus=true;
				}
				
			} catch (Exception e) {
				tx.rollback();
				throw e;
			}finally{
				try {					
					session.close();
				} catch (Exception e2) {
					tx.rollback();
					throw e2;
				}
			}
			
		} catch (Exception e) {
			throw e;
		}
		
		return customerTotalDueStatus;
	}
	private Boolean updateQuantityDetails(ListOfProductQuanityDetailsDTO billItem){
		Boolean productQuantityStatus=false;
		try {
			for(NewBillProductDTO newBillProductDTO :billItem.getBillItems()){
				productQuantityStatus=updateQuantity(newBillProductDTO);
				if(productQuantityStatus == false){
					return productQuantityStatus;
				}
			}
		} catch (Exception e) {
			throw e;
		}
		
		return productQuantityStatus;
	}
	
	private Boolean updateQuantity(NewBillProductDTO billedItem){
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				Object o=session.get(TdProductQuanityDetail.class,new BigInteger(billedItem.getProductId()));
				if(null != o){
					TdProductQuanityDetail tdProductQuanityDetail=(TdProductQuanityDetail)o;
					Integer dbQuanity=tdProductQuanityDetail.getProductQuantity().intValue();
					Integer val= dbQuanity-billedItem.getQuantity().intValue();
					tdProductQuanityDetail.setProductQuantity( BigInteger.valueOf(val.intValue()));
					tx.commit();	
					return true;
				}
				else{
					return false;
				}
			} catch (Exception e) {
				tx.rollback();
				throw e;
			}finally{
				try {					
					session.close();
				} catch (Exception e2) {
					tx.rollback();
					throw e2;
				}
			}
			
		} catch (Exception e) {
			throw e;
		}
		
	}
}
