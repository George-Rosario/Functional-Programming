package FunctionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
	/*
	 * Consumer<T>
	 * Represents an operation that accepts a single input argument and returns no result.
	 */
	
	public static void main(String[] args) {
		//normal java
		Customer customer = new Customer("George", "999999");
		greetCustomer(customer);
		
		greetCostumerV2(customer, false);
		//Consumer
		greetCustomerConsumer.accept(customer);
		//Biconsumer
		greetCustomerBiConsumer.accept(customer, false);
		
		
	}
	
	//Consumer 
	
	static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println("Hello :"+customer.customerName+" Number:"
			+customer.customerPhone);
	
	
	static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, showPhoneNumber) 
			->  System.out.println("Hello :"+customer.customerName+" Number:"
					+ (showPhoneNumber ? customer.customerPhone : "******") );
	
	
	static void greetCustomer(Customer customer) {
		System.out.println("Hello :"+customer.customerName+" Number:"
				+customer.customerPhone);
		
	}
	
	static void greetCostumerV2(Customer customer,Boolean showPhoneNumber) {
		System.out.println("Hello :"+customer.customerName+" Number:"
				+ (showPhoneNumber ? customer.customerPhone : "******") );
	}
	static class Customer{
		private final String customerName;
		private final String customerPhone;
		
		public Customer(String customerName, String customerPhone) {
			super();
			this.customerName = customerName;
			this.customerPhone = customerPhone;
		}
		
		
	}
}
