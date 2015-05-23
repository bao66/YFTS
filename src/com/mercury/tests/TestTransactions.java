package com.mercury.tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.mercury.beans.Transactions;

public class TestTransactions {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		SimpleDateFormat sdf = new SimpleDateFormat();// format time
		sdf.applyPattern("MM-dd-yyyy HH:mm:ss.S");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		Transactions transactions = new Transactions("Yang", "FB", 1, 50,sdf.format(Calendar.getInstance().getTime()), "FB", "Yang",2.31, 50 * 2.31);
		session.save(transactions);
		tx.commit();

		String hql = "from Transactions";
		Query query = session.createQuery(hql);
		System.out.println("*********************");
		List<Transactions> list = query.list();
		for (Transactions t : list) {
			System.out.println(t);
		}
		System.out.println(sdf.format(Calendar.getInstance().getTime()));
		session.close();
	}

}
