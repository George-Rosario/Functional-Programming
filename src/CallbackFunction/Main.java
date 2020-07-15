package CallbackFunction;

import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		// |||lerly what we do in js below we can write
		hello("George", null, value -> {
			System.out.println("Last name is not provided for"+value);
		});
		
		//forrunnable 
		hello1("George", null, () -> {
			System.out.println("Last name is not provided");
		});
	}
	
	// |||lerly what we do in js below we can write
	
	static void hello(String firstname,String lastname,Consumer<String> callback) {
		System.out.println("FirstName:"+firstname);
		if(lastname!=null) {
			System.out.println("LastName:"+lastname);
		}else {
			callback.accept(firstname);
		}
	}
	// samething with runnable also we can do
	
	static void hello1(String firstname,String lastname,Runnable callback) {
		System.out.println("FirstName:"+firstname);
		if(lastname!=null) {
			System.out.println("LastName:"+lastname);
		}else {
			callback.run();
		}
	}
	
//	function hello(firstname,lastname,callback) {
//		console.log(firstname);
//		if(lastname) {
//			console.log(lastname);
//		}
//		else {
//			callback();
//		}
//	}

}
