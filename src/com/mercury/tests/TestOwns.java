package com.mercury.tests;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.mercury.beans.Owns;

public class TestOwns {
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Owns owns=new Owns("Yang","GOO",10);
		session.update(owns);
		tx.commit();

		String hql="from Owns";
		Query query=session.createQuery(hql);
		System.out.println("*********************");
		List<Owns> list=query.list();
		for (Owns o:list){
			System.out.println(o);
		}
		session.close();
	}

}
