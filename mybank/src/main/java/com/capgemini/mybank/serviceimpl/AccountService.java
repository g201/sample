package com.capgemini.mybank.serviceimpl;

import com.capgemini.mybank.exception.InsufficientAmountOrAccountException;
import com.capgemini.mybank.pojo.Account;
import com.capgemini.mybank.repository.AccountRepositoryInfterface;
import com.capgemini.mybank.repositoryimpl.AccountRepository;
import com.capgemini.mybank.service.AccountServiceInterface;

public class AccountService implements AccountServiceInterface {

	AccountRepositoryInfterface accountRepository = new AccountRepository();

	@Override
	public int withdrawAmount(int accountID, int amount) throws InsufficientAmountOrAccountException {
		int withdrawnAmount = 0;
		Account account = searchAccount(accountID);
		if (0 == amount || null == account) {
			throw new InsufficientAmountOrAccountException();
		} else {
			withdrawnAmount = accountRepository.getAmount(account, amount);
		}
		return withdrawnAmount;
	}

	@Override
	public boolean deleteAccount(int accountID) {
		return accountRepository.delete(accountID);
	}

	@Override
	public Account searchAccount(int accountID) {
		return null;
	}

	@Override
	public boolean depsoitAmount(int accountID, int amount) throws InsufficientAmountOrAccountException {
		boolean isDeposited = false;
		Account account = searchAccount(accountID);
		if (0 == amount || null == account) {
			throw new InsufficientAmountOrAccountException();
		} else {
			isDeposited = true;
			accountRepository.addAmount(account, amount);
		}
		return isDeposited;
	}

	@Override
	public Account createAccount(int amount, int accountNumber, int accountID) {
		Account account = new Account();
		account.setAccountID(accountID);
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);

		return accountRepository.create(account) ? account : null;
	}

}
