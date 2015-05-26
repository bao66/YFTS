package com.mercury.daos;

import java.util.List;

import com.mercury.beans.Transactions;

public interface TransactionsDao {
	public void saveToCSV(Transactions transaction);
	public void saveToDatabase();
	public void deleteCSV();
	public List<Transactions> queryAllByUsernameFromCsv(String username);
	public List<Transactions> queryAllByUsernameFromDB(String username);
	public List<Transactions> queryAll();

}
