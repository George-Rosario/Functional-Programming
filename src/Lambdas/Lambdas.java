package Lambdas;

import java.util.function.Function;

public class Lambdas {
	public static void main(String[] args) {
		 // Function<String, String> upperCaseName = name -> name.toUpperCase(); //same
		// Function<String, String> upperCaseName =  String::toUpperCase; //same
		Function<String, String> upperCaseName =  name -> {
			//logic
			if(name.isEmpty()) throw new IllegalStateException("");
			return name.toUpperCase();
		};
		
		
		System.out.println(upperCaseName.apply("george"));
		
		
	}
}
