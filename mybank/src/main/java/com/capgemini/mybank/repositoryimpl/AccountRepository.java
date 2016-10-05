package com.capgemini.mybank.repositoryimpl;

import java.util.Map;

import com.capgemini.mybank.pojo.Account;
import com.capgemini.mybank.repository.AccountRepositoryInfterface;

public class AccountRepository implements AccountRepositoryInfterface {

	Map<Integer, Account> accountMap;

	@Override
	public int getAmount(Account account, int amount) {

		int withdrawAmount = account.getAmount() - amount;
		accountMap.get(account.getAccountID()).setAmount(withdrawAmount);
		return amount;
	}

	@Override
	public boolean delete(int ID) {
		boolean isDeleted = false;
		if (null != accountMap && accountMap.containsKey(ID)) {
			accountMap.remove(ID);
			isDeleted = true;
		}
		return isDeleted;
	}

	@Override
	public Account serach(int ID) {
		Account account = null;
		if (null != accountMap && accountMap.containsKey(ID)) {
			account = accountMap.get(ID);
		}
		return account;
	}

	@Override
	public boolean addAmount(Account account, int amount) {
		int addedAmount = account.getAmount() + amount;
		accountMap.get(account.getAccountID()).setAmount(addedAmount);
		return true;
	}

	@Override
	public boolean create(Account account) {
		boolean isCreated = false;
		if (null != accountMap && !accountMap.containsKey(account.getAccountID())) {
			accountMap.put(account.getAccountID(), account);
			isCreated = true;
		}
		return isCreated;
	}

}
