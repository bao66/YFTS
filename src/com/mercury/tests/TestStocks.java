package com.mercury.tests;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.mercury.beans.Stocks;

public class TestStocks {
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Stocks stocks=new Stocks("Sina",1);
		session.save(stocks);
		tx.commit();

		String hql="from Stocks";
		Query query=session.createQuery(hql);
		System.out.println("*********************");
		List<Stocks> list=query.list();
		for (Stocks s:list){
			System.out.println(s);
		}
	}

}
