package com.mercury.daos;

import com.mercury.beans.Traders;

public interface TraderDao {
	
	public void save(Traders trader);
	public void update(Traders trader);
	public void delete(Traders trader);
	public TraderDao findPersonByUsername(String username);
}
