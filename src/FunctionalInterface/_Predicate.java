package FunctionalInterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
	
	/*
	 * Predicate<T>	
		Represents a predicate (boolean-valued function) of one argument.
	 */
	
	public static void main(String[] args) {
		
		System.out.println(isPhoneNumberValid("90000000000000"));
		System.out.println(isPhoneNumberValid("8000000000"));
		System.out.println(isPhoneNumberValid("9000009809"));
		
		System.out.println(isPhoneNumberValidPredicate.test("9000009809"));
		System.out.println(isPhoneNumberValidPredicate.test("8000000000"));
		
		//chaning Predicates with AND and OR
		
		System.out.println(isPhoneNumberValidPredicate.and(contains3Predicate).test("9000009809"));
		System.out.println(isPhoneNumberValidPredicate.and(contains3Predicate).test("9000039809"));
		
		System.out.println(isPhoneNumberValidPredicate.or(contains3Predicate).test("9000009809"));
		
		//biPredicate
		System.out.println(isPhoneNumberValidWithStartswith9AndConstains3Predicate.test("9000039809","3"));
		
	}
	
	static boolean isPhoneNumberValid(String phoneNumber) {
		return phoneNumber.startsWith("9") && phoneNumber.length() == 10;
	}
	
	static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
	 	phoneNumber.startsWith("9") && phoneNumber.length() == 10;
	 	
	static Predicate<String> contains3Predicate = phoneNumber -> 
		phoneNumber.contains("3");
		
	static BiPredicate<String, String> isPhoneNumberValidWithStartswith9AndConstains3Predicate =
			(phoneNumber , contains) ->
	 phoneNumber.startsWith("9") && phoneNumber.contains(contains);
			

}
