package com.shopping.global.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.global.bean.WildCardSearchBean;
import com.shopping.global.constants.Constants;
import com.shopping.global.dto.ListOfProductQuanityDetailsDTO;
import com.shopping.global.dto.NewBillProductDTO;
import com.shopping.global.dto.ProductQuanityDetailsDTO;
import com.shopping.global.model.TdProductQuanityDetail;
import com.shopping.global.model.TdStockDetail;
import com.shopping.global.services.ResponseDTO;



@Component
public class StockDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public ResponseDTO searchStockDetails(WildCardSearchBean stockSearchDetails) throws Exception{
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				@SuppressWarnings("unchecked")
				List<TdStockDetail> stockSearchDetailsList=session.createQuery("from TdStockDetail where productName like :searchString or product_desc like :searchString or productId like :searchString").setParameter("searchString", "%"+stockSearchDetails.getSearchString()+"%").list();
				if(stockSearchDetailsList.size()!=0){
					responseDTO.setStatus(Constants.SUCCESS);
					responseDTO.setResponseObject(stockSearchDetailsList);
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
	public ResponseDTO saveStockDetails(TdProductQuanityDetail tdProductQuanityDetail) throws Exception{
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				session.save(tdProductQuanityDetail);
				tx.commit();
				responseDTO.setMessage(tdProductQuanityDetail.getProductId().toString());
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
	
	public List<ProductQuanityDetailsDTO> searchStockNames() throws Exception{
		
		List<ProductQuanityDetailsDTO> ProductQuanityDetailsDTOList=new ArrayList<ProductQuanityDetailsDTO>();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				@SuppressWarnings("unchecked")
				List<TdProductQuanityDetail> stockDetailsList=session.createQuery("from TdProductQuanityDetail").list();
				if(stockDetailsList!=null){
					if(stockDetailsList.size()!=0){
						for(TdProductQuanityDetail stockDetails:stockDetailsList){
							ProductQuanityDetailsDTO productQuanityDetailsDTO=new ProductQuanityDetailsDTO();
							productQuanityDetailsDTO=prepareStockDetailsObject(stockDetails);
							ProductQuanityDetailsDTOList.add(productQuanityDetailsDTO);
						}

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
		return ProductQuanityDetailsDTOList;
	}
	private ProductQuanityDetailsDTO prepareStockDetailsObject(TdProductQuanityDetail stockDetail){
		ProductQuanityDetailsDTO productQuanityDetailsDTO=new ProductQuanityDetailsDTO();
		productQuanityDetailsDTO.setProduct_desc(stockDetail.getProductDesc());
		productQuanityDetailsDTO.setProductBatchNo(stockDetail.getProductBatchNo());
		productQuanityDetailsDTO.setProductExpiryDt(stockDetail.getProductExpiryDt());
		productQuanityDetailsDTO.setProductId(stockDetail.getProductId());
		productQuanityDetailsDTO.setProductMfgDt(stockDetail.getProductMfgDt());
		productQuanityDetailsDTO.setProductName(stockDetail.getProductName());
		productQuanityDetailsDTO.setProductQuantity(stockDetail.getProductQuantity());
		productQuanityDetailsDTO.setProductSellingPrice(stockDetail.getProductSellingPrice());
		productQuanityDetailsDTO.setProductSellVat(stockDetail.getProductSellVat());
		productQuanityDetailsDTO.setProductPurchasePrice(stockDetail.getProductPurchasePrice());
		productQuanityDetailsDTO.setProductPurchaseVat(stockDetail.getProductPurchaseVat());
		productQuanityDetailsDTO.setProductExtraInfo(stockDetail.getProductExtraInfo());
		productQuanityDetailsDTO.setProductLocation(stockDetail.getProductLocation());
		return productQuanityDetailsDTO;
	}
	public ResponseDTO validateAndSearchBathcNoDetails(String searchItemDetails) throws Exception{
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				Criteria cri=session.createCriteria(TdProductQuanityDetail.class);
				cri.add(Restrictions.eq("productId",new BigInteger(searchItemDetails)));
				ProjectionList p1=Projections.projectionList();
		        p1.add(Projections.property("productBatchNo"));
		        cri.setProjection(p1);	
		        List<String> batchnoList=cri.list();
				if(batchnoList.size()!=0){
					responseDTO.setStatus(Constants.SUCCESS);
					responseDTO.setResponseObject(batchnoList);
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
	public ResponseDTO searchProdcuDetails(WildCardSearchBean productId) throws Exception{
		ResponseDTO responseDTO=new ResponseDTO();
		List<ProductQuanityDetailsDTO> ProductQuanityDetailsDTOList=new ArrayList<ProductQuanityDetailsDTO>();

		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				@SuppressWarnings("unchecked")
				List<TdProductQuanityDetail> productDetails=session.createQuery("from TdProductQuanityDetail where productId = :searchString").setParameter("searchString",new BigInteger(productId.getSearchString())).list();
				if(null !=productDetails){
					if(productDetails.size()!=0){
						for(TdProductQuanityDetail productDetail:productDetails){
							ProductQuanityDetailsDTO productQuanityDetailsDTO=new ProductQuanityDetailsDTO();
							productQuanityDetailsDTO=prepareStockDetailsObject(productDetail);
							ProductQuanityDetailsDTOList.add(productQuanityDetailsDTO);
						}
					}
				}
				responseDTO.setResponseObject(ProductQuanityDetailsDTOList);
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
	
	@SuppressWarnings("unchecked")
	public List<TdProductQuanityDetail> fetchBillItem(ListOfProductQuanityDetailsDTO billItem) throws Exception{
		List<TdProductQuanityDetail> stockDetailsList=new ArrayList<TdProductQuanityDetail>();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				List<BigInteger> productIdsIn=new ArrayList<BigInteger>();
				for(NewBillProductDTO ids:billItem.getBillItems()){
						productIdsIn.add(new BigInteger(ids.getProductId()));
				}
				stockDetailsList=session.createQuery("from TdProductQuanityDetail where productId in :searchString").setParameterList("searchString", productIdsIn).list();
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
		return stockDetailsList;
	}
}
