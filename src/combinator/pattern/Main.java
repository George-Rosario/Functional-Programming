package combinator.pattern;

import java.time.LocalDate;

import org.omg.PortableInterceptor.SUCCESSFUL;

import combinator.pattern.CustmerRegistrationValidator.ValidationResult;

public class Main {

	public static void main(String[] args) {

		Customer customer = new Customer("George", "geo@gmail.com", "90000", 
				LocalDate.of(2016, 6, 9));
		
		System.out.println(new CustomerValidatorService().isValid(customer) );
		 //now can store the customer	
		
		
		//Using combinator pattern 
		ValidationResult result = CustmerRegistrationValidator
			.isEmailVaid()
			.and(CustmerRegistrationValidator.isPhoneNumberValid())
			.and(CustmerRegistrationValidator.isAnAdult())
			.apply(customer); //lazy, If i remove .apply it will not call those validation
		
		
		System.out.println(result);
		if(result != ValidationResult.SUCCESS) {
			throw new IllegalStateException(result.name());
		}
		
	}

}
