package com.mercury.daos;

import java.util.List;

import com.mercury.beans.Transactions;

public interface TransactionDao {
	public void saveToCSV(Transactions transaction);
	public void saveToDatabase(Transactions transaction);
	public void deleteCSV();
	public List<Transactions> queryAllByUsername(String username);
	
}
