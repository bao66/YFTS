package com.mercury.template;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.mercury.beans.Transactions;

public class CsvRW {
	public static List<Transactions> csvRead(String readPath) {
		try {
			List<Transactions> list = new ArrayList<Transactions>();
			FileInputStream fis = new FileInputStream(readPath);
			InputStreamReader isw = new InputStreamReader(fis);
			BufferedReader in = new BufferedReader(isw);
			String inline = in.readLine();
			while (inline != null) {
				String[] tokens = inline.split(",");
				Transactions ts = new Transactions(tokens[0], tokens[1],
						Integer.parseInt(tokens[2]),
						Integer.parseInt(tokens[3]), tokens[4], tokens[5],
						tokens[6], Double.parseDouble(tokens[7]),
						Double.parseDouble(tokens[8]));
				list.add(ts);
				inline = in.readLine();
			}
			in.close();
			isw.close();
			fis.close();
			return list;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static void csvWrite(Transactions ts, String writePath) {
		try {
			FileWriter fw = new FileWriter(writePath, true);
			String s = new String(ts.getUsername() + "," + ts.getCompanyName()
					+ "," + String.valueOf(ts.getBuyOrSell()) + ","
					+ String.valueOf(ts.getQuantity()) + ","
					+ ts.getTransTime() + "," + ts.getStock_companyName() + ","
					+ ts.getTrader_username() + ","
					+ String.valueOf(ts.getUnitPrice()) + ","
					+ String.valueOf(ts.getTotalPrice()));
			fw.write(s + "\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void deleteCsv(String deletePath) {
		try {
			new FileOutputStream(deletePath, false);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	// The main function is only for testing
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();

		String hql = "from Transactions";
		Query query = session.createQuery(hql);
		System.out.println("*********************");
		List<Transactions> list = query.list();
		String path = "test.csv";
		deleteCsv(path);
		for (Transactions t : list) {
			csvWrite(t, path);
		}

		List<Transactions> list2 = new ArrayList<Transactions>();
		list2 = csvRead(path);
		for (Transactions t2 : list2) {
			System.out.println(t2);
		}
	}

}
