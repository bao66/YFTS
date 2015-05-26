package com.mercury.daos.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mercury.beans.Stocks;
import com.mercury.daos.StocksDao;

public class StocksDaoImpl implements StocksDao {
	private HibernateTemplate template;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void save(Stocks stock) {
		// TODO Auto-generated method stub
		template.save(stock); 
	}

	@Override
	public void update(Stocks stock) {
		// TODO Auto-generated method stub
		template.update(stock);
	}

	@Override
	public void delete(Stocks stock) {
		// TODO Auto-generated method stub
		template.delete(stock);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stocks> queryAll() {
		// TODO Auto-generated method stub
		String hql = "from Stocks";
		return template.find(hql);
	}

}
