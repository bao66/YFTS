package com.mercury.daos;

import java.util.List;

import com.mercury.beans.Owns;

public interface OwnDao {
	public void save(Owns trader);
	public void update(Owns trader);
	public void deleteByUsername(String username);
	public void deleteByCompanyName(String companyName);
	public  List<Owns>queryAllByUsername(String username);
}
