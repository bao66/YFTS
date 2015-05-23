package com.mercury.daos;

import java.util.List;

import com.mercury.beans.Transactions;

public interface TransactionsDao {
	public void saveToCSV(Transactions transaction);
	public void saveToDatabase(Transactions transaction);
	public void deleteCSV();
	public List<Transactions> queryAllByUsername(String username);
	public List<Transactions> queryAll();// for admin purpose
}
