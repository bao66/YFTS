package com.mercury.daos;

import java.util.List;

import com.mercury.beans.Stocks;

public interface StockDao {
	public void save(Stocks stock);
	public void update(Stocks stock);
	public void delete(Stocks stock);
	public List<Stocks> queryAll();
}
