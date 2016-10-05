package com.capgemini.mybank.service;

import com.capgemini.mybank.exception.InsufficientAmountOrAccountException;
import com.capgemini.mybank.pojo.Account;

/**
 * This service interface is to provide the implementation / service related to
 * the account of the customer
 * 
 * @author gsharm24
 *
 */
public interface AccountServiceInterface {

	/**
	 * withdraw amount from the account
	 * 
	 * @param accountID
	 * @param amount
	 * @return amount fromt the account
	 * @throws InsufficientAmountException 
	 */
	int withdrawAmount(int accountID, int amount) throws InsufficientAmountOrAccountException;

	/**
	 * Delete the account
	 * 
	 * @param accountID
	 * @return return boolean
	 */
	boolean deleteAccount(int accountID);

	/**
	 * Search the account based on the given account ID
	 * 
	 * @param accountID
	 * @return whole account information
	 */
	Account searchAccount(int accountID);

	/**
	 * Deposit the amount for the supplied account ID
	 * 
	 * @param accountID
	 * @param amount
	 * @return
	 * @throws InsufficientAmountOrAccountException 
	 */
	boolean depsoitAmount(int accountID, int amount) throws InsufficientAmountOrAccountException;
	
	/**
	 * Create new Account for the customer
	 * 
	 * @param age
	 * @param name
	 * @param address
	 * @return the account information
	 */
	Account createAccount(int amount, int acountNumber, int accountID);
	
}
