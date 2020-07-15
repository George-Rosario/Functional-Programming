package FunctionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
	
	public static void main(String[] args) {
		//Functions
		
		int increment = increment(1);
		System.out.println(increment);
		
		int increment2 = IncrementByOneFunction.apply(1);
		
		System.out.println(increment2);
		
		/*
		 * Chaining functions 
		 */
		
		int multiply = MultiplyBy10Function.apply(increment2);
		
		System.out.println(multiply);
		// we can do better by chianing them
		
		Function<Integer, Integer> IncrementByOneAndMultiplyByTen = 
				IncrementByOneFunction.andThen(MultiplyBy10Function);
		
		int incrementAndMultiply = IncrementByOneAndMultiplyByTen.apply(multiply);
		
		System.out.println(incrementAndMultiply);

		//Bi Functions
		
		System.out.println(incrementByOneAndMultiplyBySecondArgBiFunction.apply(7, 100));
		
	}
	
	static int increment(int number) {
		return number + 1;
	}
	
	/*
	 *  Function<T,R> Represents a function that accepts one argument and 
	 *  produces a result.
	 *  
	 *  T is input type and R is result type
	 *  
	 */
	
	static Function<Integer, Integer> IncrementByOneFunction = number -> number + 1 ;
	
	static Function<Integer, Integer> MultiplyBy10Function = number -> number * 10 ;
	
	/*
	 * 	BiFunction<T,U,R> Represents a function that accepts two arguments and produces a result.
	 * T is argument 1 , U is argument 2 R is result
	 */
	
	static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBySecondArgBiFunction =
			(numbertoIncrementBy , numberToMultiply) 
			-> (numbertoIncrementBy + 1) * numberToMultiply;
	
	
	
}
