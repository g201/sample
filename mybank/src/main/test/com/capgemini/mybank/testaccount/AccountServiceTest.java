package com.capgemini.mybank.testaccount;

import com.capgemini.mybank.exception.InsufficientAmountOrAccountException;
import com.capgemini.mybank.pojo.Account;
import com.capgemini.mybank.serviceimpl.AccountService;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;

public class AccountServiceTest {

	private static AccountService accountService;
	private static Account account;

	@BeforeClass
	public static void setup() {
		accountService = mock(AccountService.class);
		account = new Account();
		account.setAccountID(01);
		account.setAccountNumber(001);
		account.setAmount(100);

		try {
			when(accountService.createAccount(100, 001, 01)).thenReturn(account);
			when(accountService.createAccount(100, 001, 02)).thenReturn(null);
			when(accountService.withdrawAmount(01, 10)).thenReturn(10);
		} catch (InsufficientAmountOrAccountException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testAddAccount() {
		Account account = accountService.createAccount(100, 001, 01);

		assertNotNull(account);
		assertEquals(account.getAccountID(), 01);
	}

	@Test
	public void testWithdrawAccount() {
		try {
			int withdrawnAmount = accountService.withdrawAmount(01, 10);
			assertEquals(withdrawnAmount, 10);

		} catch (InsufficientAmountOrAccountException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testAddAccountForNull() {
		Account account = accountService.createAccount(100, 001, 02);
		assertNull(account);		
	}
	
	
}
