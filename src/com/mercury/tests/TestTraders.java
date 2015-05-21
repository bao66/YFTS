package com.mercury.tests;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;

import com.mercury.beans.Traders;

public class TestTraders {
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Traders traders=new Traders("Yang","Bao","yangbao@gmail.com",200,"admin",1);
		session.save(traders);
		tx.commit();

		String hql="from Traders";
		Query query=session.createQuery(hql);
		System.out.println("*********************");
		List<Traders> list=query.list();
		for (Traders t:list){
			System.out.println(t);
		}
	}
}
