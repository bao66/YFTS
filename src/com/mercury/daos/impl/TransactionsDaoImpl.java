package com.mercury.daos.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mercury.beans.Transactions;
import com.mercury.daos.TransactionsDao;

public class TransactionsDaoImpl implements TransactionsDao {
	private HibernateTemplate template;
	private String path="test.csv";

	public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void saveToCSV(Transactions transaction) {
		// TODO Auto-generated method stub
		try{
			FileWriter fw=new FileWriter(path,true);
			String s=new String(transaction.getUsername()+","+transaction.getCompanyName()+","+
					String.valueOf(transaction.getBuyOrSell())+","+String.valueOf(transaction.getQuantity())+","+
					transaction.getTransTime()+","+transaction.getStock_companyName()+","+
					transaction.getTrader_username()+","+String.valueOf(transaction.getUnitPrice())+","+
					String.valueOf(transaction.getTotalPrice()));
			fw.write(s+"\n");
			fw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public void saveToDatabase() {
		// TODO Auto-generated method stub
		try{
			FileInputStream fis=new FileInputStream(path);
			InputStreamReader isw=new InputStreamReader(fis);
			BufferedReader in = new BufferedReader(isw);
			String inline=in.readLine();
			while(inline!=null){
				String[] tokens=inline.split(",");
				Transactions ts=new Transactions(tokens[0],tokens[1],Integer.parseInt(tokens[2]),
						Integer.parseInt(tokens[3]),tokens[4],tokens[5],tokens[6],
						Double.parseDouble(tokens[7]),Double.parseDouble(tokens[8]));
				template.save(ts);
				inline=in.readLine();
			}	
			in.close();
			isw.close();
			fis.close();
		}catch(Exception e){
			System.out.println(e);
		}	
	}

	@Override
	public void deleteCSV() {
		// TODO Auto-generated method stub
		try{
			new FileOutputStream(path,false);
		}catch(IOException e){
			System.out.println(e);
		}
	}

	@Override
	public List<Transactions> queryAllByUsernameFromCsv(String username) {
		// TODO Auto-generated method stub
		try{
			List<Transactions> list=new ArrayList<Transactions>();
			FileInputStream fis=new FileInputStream(path);
			InputStreamReader isw=new InputStreamReader(fis);
			BufferedReader in = new BufferedReader(isw);
			String inline=in.readLine();
			while(inline!=null){
				String[] tokens=inline.split(",");
				if (tokens[0]==username){
					Transactions ts=new Transactions(tokens[0],tokens[1],Integer.parseInt(tokens[2]),
							Integer.parseInt(tokens[3]),tokens[4],tokens[5],tokens[6],
							Double.parseDouble(tokens[7]),Double.parseDouble(tokens[8]));
					list.add(ts);
				}
				inline=in.readLine();
			}	
			in.close();
			isw.close();
			fis.close();
			return list;
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Transactions> queryAllByUsernameFromDB(String username) {
		// TODO Auto-generated method stub
		return (List<Transactions>)template.find("from transactions where username=?",username);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transactions> queryAll() {
		// TODO Auto-generated method stub
		String hql = "from Transactions";
		return template.find(hql);
	}

}
