package com.capgemini.mybank.serviceimpl;

import java.util.List;

import com.capgemini.mybank.exception.InvalidCustomerException;
import com.capgemini.mybank.pojo.Account;
import com.capgemini.mybank.pojo.Customer;
import com.capgemini.mybank.repository.CustomerRepositoryInterface;
import com.capgemini.mybank.repositoryimpl.CustomerRepository;
import com.capgemini.mybank.service.CustomerServiceInterface;

public class CustomerService implements CustomerServiceInterface {

	CustomerRepositoryInterface customerRepository = new CustomerRepository();

	@Override
	public Customer getCustomer(int customerID) throws InvalidCustomerException {
		Customer customer = null;
		if (0 == customerID) {
			throw new InvalidCustomerException();
		} else {
			customer = customerRepository.find(customerID);
		}
		return customer;
	}

	@Override
	public List<Customer> getAllCustomer() {

		return customerRepository.findAll();
	}

	@Override
	public Customer createCustomer(String name, int age, String address, Account account)
			throws InvalidCustomerException {

		if (null == name) {
			throw new InvalidCustomerException();
		}

		Customer customer = new Customer();
		customer.setAccount(account);
		customer.setName(name);
		customer.setAge(age);
		customer.setAddres(address);
		return customerRepository.add(customer);
	}

	@Override
	public boolean deleteCustomer(int customerID) {

		return customerRepository.delete(customerID);
	}

}
