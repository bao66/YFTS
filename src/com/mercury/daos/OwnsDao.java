package com.mercury.daos;

import java.util.List;

import com.mercury.beans.Owns;

public interface OwnsDao {
	public void save(Owns owns);
	public void update(Owns owns);
	public void deleteByUsername(String username);
	public void deleteByCompanyName(String companyName);
	public  List<Owns>queryAllByUsername(String username);
}
