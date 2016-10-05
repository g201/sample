package com.capgemini.mybank.repository;

import java.util.List;

import com.capgemini.mybank.pojo.Customer;

/**
 * Repository of the customer to perform operation instructed by Customer
 * Service
 * 
 * @author gsharm24
 *
 */
public interface CustomerRepositoryInterface {

	Customer find(int ID);

	List<Customer> findAll();

	Customer add(Customer customer);

	boolean delete(int ID);
}
