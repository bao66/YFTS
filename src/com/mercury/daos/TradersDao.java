package com.mercury.daos;

import com.mercury.beans.Traders;

public interface TradersDao {
	
	public void save(Traders trader);
	public void update(Traders trader);
	public void delete(Traders trader);
	public TradersDao findPersonByUsername(String username);
}
