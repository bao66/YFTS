package com.mercury.daos.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mercury.beans.Owns;
import com.mercury.daos.OwnsDao;

public class OwnsDaoImpl implements OwnsDao {
	private HibernateTemplate template;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void save(Owns owns) {
		// TODO Auto-generated method stub
		template.save(owns);
	}

	@Override
	public void update(Owns owns) {
		// TODO Auto-generated method stub
		template.update(owns);
	}

	@Override
	public void deleteByUsername(String username) {
		// TODO Auto-generated method stub
		template.bulkUpdate("delete owns where username=?",username);
	}

	@Override
	public void deleteByCompanyName(String companyName) {
		// TODO Auto-generated method stub
		template.bulkUpdate("delete owns where companyname=?",companyName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Owns> queryAllByUsername(String username) {
		// TODO Auto-generated method stub
		return (List<Owns>)template.find("from owns where username=?",username);
	}

}
