package com.capgemini.mybank.repositoryimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.mybank.pojo.Customer;
import com.capgemini.mybank.repository.CustomerRepositoryInterface;

public class CustomerRepository implements CustomerRepositoryInterface {
	Map<Integer, Customer> customerMap;

	@Override
	public Customer find(int ID) {
		Customer customer = null;

		if (null != customerMap && customerMap.containsKey(ID)) {
			customer = customerMap.get(ID);
		}
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customerList = null;
		if (null != customerMap) {
			customerList = (List<Customer>) customerMap.values();
		}
		return customerList;
	}

	@Override
	public Customer add(Customer customer) {

		if (null == customerMap) {
			customerMap = new HashMap<Integer, Customer>();
			customerMap.put(customer.getCustomerID(), customer);
		}
		return customer;
	}

	@Override
	public boolean delete(int ID) {
		boolean isDeleted = false;
		if (null != customerMap && customerMap.containsKey(ID)) {
			customerMap.remove(ID);
			isDeleted = true;
		}

		return isDeleted;
	}

}
