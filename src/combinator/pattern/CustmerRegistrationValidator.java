package combinator.pattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;


import static combinator.pattern.CustmerRegistrationValidator.*;
import static combinator.pattern.CustmerRegistrationValidator.ValidationResult.*;

public interface CustmerRegistrationValidator extends Function<Customer, ValidationResult>{
	
	static CustmerRegistrationValidator isEmailVaid() {
		return customer -> customer.getEmail().contains("@") ? 
				SUCCESS : 	EMAIL_NOT_VALID;
	}
	
	static CustmerRegistrationValidator isAnAdult() {
		return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
				SUCCESS : IS_NOT_ADULT;
	}
	
	static CustmerRegistrationValidator isPhoneNumberValid() {
		return customer -> customer.getPhoneNumber().contains("9") ? SUCCESS : PHONE_NUMBER_NOT_VALID;
	}
	
	default CustmerRegistrationValidator and (CustmerRegistrationValidator other) {
		return customer -> {
			ValidationResult result = this.apply(customer);
			return result.equals(SUCCESS) ? other.apply(customer) :result;
		};
	}
	
	enum ValidationResult{
		SUCCESS,
		PHONE_NUMBER_NOT_VALID,
		EMAIL_NOT_VALID,
		IS_NOT_ADULT
	}
}
