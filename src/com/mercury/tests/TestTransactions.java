package com.mercury.tests;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.mercury.beans.Transactions;

public class TestTransactions {
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Transactions transactions=new Transactions("CongKai","GOO",1,240,"05-21-2013","GOO","CongKai",5.32,240*5.32);
		session.save(transactions);
		tx.commit();

		String hql="from Transactions";
		Query query=session.createQuery(hql);
		System.out.println("*********************");
		List<Transactions> list=query.list();
		for (Transactions t:list){
			System.out.println(t);
		}
	}

}
