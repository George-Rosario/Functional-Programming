package FunctionalInterface;

import java.util.function.Supplier;

public class _Supplier {
	
	/*
	 * Supplier<T>	
			Represents a supplier of results.
			opposite of Consumer (it takes argument and returns nothing)
			but this returns
	 */
	
	public static void main(String[] args) {
		System.out.println(getjdbcURL());
		
		System.out.println(getJdbcUrlSupplier.get());
	}

	 static String getjdbcURL() {
		return "jdbc://localhost:1234/users";
	}
	 
	 static Supplier<String> getJdbcUrlSupplier = () -> "jdbc://localhost:1234/users";

}
