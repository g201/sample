package com.capgemini.mybank.pojo;

/**
 * Customer object to represent the customer of the bank.
 * 
 * @author gsharm24
 *
 */
public class Customer {

	// name of the customer
	private String name;
	// address of the customer
	private String addres;
	// age of the customer
	private int age;
	// unique ID of the customer
	private int customerID;

	// account of the customer
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
