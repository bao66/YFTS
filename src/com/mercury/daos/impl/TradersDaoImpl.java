package com.mercury.daos.impl;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mercury.beans.Traders;
import com.mercury.daos.TradersDao;

public class TradersDaoImpl implements TradersDao {
	private HibernateTemplate template;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void save(Traders trader) {
		// TODO Auto-generated method stub
		template.save(trader);
	}

	@Override
	public void update(Traders trader) {
		// TODO Auto-generated method stub
		template.update(trader);
	}

	@Override
	public void delete(Traders trader) {
		// TODO Auto-generated method stub
		template.delete(trader);
	}

	@Override
	public Traders findPersonByUsername(String username) {
		// TODO Auto-generated method stub
		return (Traders)template.load(Traders.class, username);
	}

}
