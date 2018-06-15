package com.shopping.global.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.global.bean.WildCardSearchBean;
import com.shopping.global.constants.Constants;
import com.shopping.global.dto.CustomerSearchDTO;
import com.shopping.global.model.TdCustomerBalance;
import com.shopping.global.model.TdCustomerBalanceDetail;
import com.shopping.global.model.TdCustomerDetail;
import com.shopping.global.model.TdCustomerSearch;
import com.shopping.global.services.ResponseDTO;


@Component
public class CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public ResponseDTO searchCustomerDetails(WildCardSearchBean customerSearch) throws Exception{
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				@SuppressWarnings("unchecked")
				List<TdCustomerSearch> customerSearchDetailsList=session.createQuery("from TdCustomerSearch where customerId like :SearchString OR godownNo like :SearchString OR name like:SearchString OR mobile like :SearchString").setParameter("SearchString", "%"+customerSearch.getSearchString()+"%").list();
				if(customerSearchDetailsList.size()!=0){
					responseDTO.setStatus(Constants.SUCCESS);
					responseDTO.setResponseObject(customerSearchDetailsList);
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
	public ResponseDTO saveCustomerDetails(TdCustomerDetail customerDetails) throws Exception{
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				session.save(customerDetails);
				tx.commit();
				responseDTO.setMessage(customerDetails.getCustomerId().toString());
				responseDTO.setStatus(Constants.SUCCESS);
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
	public ResponseDTO searchCustomerDues(WildCardSearchBean customerSearch) throws Exception{
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				@SuppressWarnings("unchecked")
				List<TdCustomerBalance> customerDues=session.createQuery("from TdCustomerBalance where customerId = :searchString").setParameter("searchString",new BigInteger(customerSearch.getSearchString())).list();
				if(customerDues.size()!=0){
					responseDTO.setStatus(Constants.SUCCESS);
					responseDTO.setResponseObject(customerDues);
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
	public ResponseDTO searchCustomerDueDetails(WildCardSearchBean customerSearch) throws Exception{
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				@SuppressWarnings("unchecked")
				List<TdCustomerBalanceDetail> customerDues=session.createQuery("from TdCustomerBalanceDetail where customerId = :searchString").setParameter("searchString",new BigInteger(customerSearch.getSearchString())).list();
				if(customerDues.size()!=0){
					responseDTO.setStatus(Constants.SUCCESS);
					responseDTO.setResponseObject(customerDues);
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
	
	public List<CustomerSearchDTO> fetchAllCustomers() throws Exception{
		List<CustomerSearchDTO> listofCustomers=new ArrayList<CustomerSearchDTO>();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				@SuppressWarnings("unchecked")
				List<TdCustomerSearch> customerSearchDetailsList=session.createQuery("from TdCustomerSearch").list();
				if(customerSearchDetailsList.size()!=0){
					for(TdCustomerSearch customerData:customerSearchDetailsList){
						CustomerSearchDTO customerSearchDTO=new CustomerSearchDTO();
						listofCustomers.add(prepareCustomerAllDetailsObject(customerSearchDTO,customerData));

					}
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
		return listofCustomers;
	}
	private CustomerSearchDTO prepareCustomerAllDetailsObject(CustomerSearchDTO customerSearchDTO,TdCustomerSearch customerDataFromDB){
		customerSearchDTO.setCustomerId(customerDataFromDB.getCustomerId());
		customerSearchDTO.setGodownNo(customerDataFromDB.getGodownNo());
		customerSearchDTO.setMobile(customerDataFromDB.getMobile());
		customerSearchDTO.setName(customerDataFromDB.getName());
		return customerSearchDTO;
	}
}
