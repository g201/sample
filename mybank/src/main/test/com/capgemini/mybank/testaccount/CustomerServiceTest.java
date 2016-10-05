package com.capgemini.mybank.testaccount;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.mybank.exception.InvalidCustomerException;
import com.capgemini.mybank.pojo.Account;
import com.capgemini.mybank.pojo.Customer;
import com.capgemini.mybank.serviceimpl.CustomerService;

/**
 * Test class for Customer Service to test all the method
 * 
 * @author gsharm24
 *
 */
public class CustomerServiceTest {

	private static CustomerService customerService;
	private static Customer customer1;
	private static Customer customer2;
	private static Account account1;
	private static Account account2;

	@BeforeClass
	public static void setup() {
		customerService = mock(CustomerService.class);

		account1 = new Account();
		account1.setAccountID(1);
		account1.setAccountNumber(001);
		account1.setAmount(100);
		
		account2 = new Account();
		account2.setAccountID(1);
		account2.setAccountNumber(001);
		account2.setAmount(100);

		customer1 = new Customer();
		customer1.setAccount(account2);
		customer1.setAge(20);
		customer1.setAddres("Address 123");
		customer1.setName("Gaurav Sharma");
		customer1.setCustomerID(1);

		customer2 = new Customer();
		customer2.setAccount(account1);
		customer2.setAge(20);
		customer2.setAddres("Address 123");
		customer2.setName("Gaurav Sharma");
		customer2.setCustomerID(2);

		try {
			when(customerService.createCustomer("Gaurav Sharma", 20, "Address 123", account1)).thenReturn(customer1);
			when(customerService.createCustomer(null, 20, "Address 123", account1))
					.thenThrow(InvalidCustomerException.class);
			when(customerService.getCustomer(1)).thenReturn(customer1);			
			when(customerService.getAllCustomer()).thenReturn(Arrays.asList(customer1, customer2));
			when(customerService.getCustomer(3)).thenReturn(null);
		} catch (InvalidCustomerException e) {

			e.printStackTrace();
		}
	}

	@Test
	public void testCreateCustomer() {

		Account account = new Account();
		account.setAccountID(1);
		account.setAccountNumber(001);
		account.setAmount(100);
		Customer customer = null;
		try {
			customer = customerService.createCustomer("Gaurav Sharma", 20, "Address 123", account);
		} catch (InvalidCustomerException e) {
			e.printStackTrace();
		}

		assertNotNull(customer);
	}

	@Test(expected = InvalidCustomerException.class)
	public void testCreateCustomerWithNull() throws InvalidCustomerException {
		Account account = new Account();
		account.setAccountID(1);
		account.setAccountNumber(001);
		account.setAmount(100);
		customerService.createCustomer(null, 20, "Address 123", account);
	}

	@Test
	public void testGetCustomer() throws InvalidCustomerException {
		Customer returnedCustomer = customerService.getCustomer(1);
		assertNotNull(returnedCustomer);
		assertEquals(returnedCustomer, customer1);
	}

	@Test
	public void testGetCustomerForNull() throws InvalidCustomerException {
		Customer returnedCustomer = customerService.getCustomer(3);
		assertNull(returnedCustomer);
	}
	
	@Test
	public void testGetAllCustomer(){
		List<Customer> customerList = customerService.getAllCustomer();
		assertEquals(2, customerList.size());
	}
}
