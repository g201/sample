package com.capgemini.mybank.service;

import java.util.List;

import com.capgemini.mybank.exception.InvalidCustomerException;
import com.capgemini.mybank.pojo.Account;
import com.capgemini.mybank.pojo.Customer;

/**
 * This interface is to provide the implementation / service method to get the
 * customer information
 * 
 * @author gsharm24
 *
 */
public interface CustomerServiceInterface {
	
	/**
	 * Get the customer for the provided csutomer ID
	 * 
	 * @param customerID
	 * @return Customer object
	 * @throws InvalidCustomerException 
	 */
	Customer getCustomer(int customerID) throws InvalidCustomerException;
	
	/**
	 * Get all the Customer available in the bank
	 * 
	 * @return List of the customer
	 */
	List<Customer> getAllCustomer();
	
	/**
	 * Create new customer
	 * 
	 * @param customer
	 * @return boolean
	 * @throws InvalidCustomerException 
	 */
	Customer createCustomer (String name, int age, String address, Account account) throws InvalidCustomerException;
	
	/**
	 * Delete the Customer from the repository
	 * 
	 * @param customerID
	 * @return boolean true of false as per the customer deletion from the repository
	 */
	boolean deleteCustomer(int customerID);
}
