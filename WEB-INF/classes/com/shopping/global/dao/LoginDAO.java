package com.shopping.global.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.global.dto.LoginDTO;
import com.shopping.global.model.TdUserLogin;


@Component
public class LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public LoginDTO userAuth(LoginDTO loginDTO) throws Exception{
		LoginDTO loginDTO2=new LoginDTO();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				TdUserLogin tuser=(TdUserLogin) session.get(TdUserLogin.class, loginDTO.getUserName());
				System.out.println(tuser.getUserId());
				loginDTO2.setStatus("SUCCESS");
			} catch (Exception e) {
				tx.rollback();
				loginDTO2.setStatus("ERROR");
				throw e;
			}finally{
				try {					
					session.close();
				} catch (Exception e2) {
					tx.rollback();
					loginDTO2.setStatus("ERROR");
					throw e2;
				}
			}
			
		} catch (Exception e) {
			loginDTO2.setStatus("ERROR");
			throw e;
		}
		
		return loginDTO2;
	}
}
