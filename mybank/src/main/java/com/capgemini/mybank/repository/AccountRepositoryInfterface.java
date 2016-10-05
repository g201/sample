package com.capgemini.mybank.repository;

import com.capgemini.mybank.pojo.Account;

public interface AccountRepositoryInfterface {	
	
	int getAmount(Account account, int amount);

	boolean delete(int ID);

	Account serach(int ID);

	boolean addAmount(Account account, int amount);

	boolean create(Account account);

}
