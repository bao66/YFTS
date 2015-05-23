package com.mercury.daos.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mercury.beans.Transactions;
import com.mercury.daos.TransactionsDao;
import com.mercury.template.CsvRW;

public class TransactionsDaoImpl implements TransactionsDao {
	private HibernateTemplate template;

	public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void saveToCSV(Transactions transaction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveToDatabase(Transactions transaction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCSV(String deletePath) {
		// TODO Auto-generated method stub
		CsvRW.deleteCsv(deletePath);
	}

	@Override
	public List<Transactions> queryAllByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transactions> queryAll() {
		// TODO Auto-generated method stub
		String hql = "from Transactions";
		return template.find(hql);
	}

}
