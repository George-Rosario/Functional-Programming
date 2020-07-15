package Optionals;

import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		Optional<String> empty = Optional.of("Hello");// 
		System.out.println(empty.isPresent());
		System.out.println(empty.get());
		String orElse = empty.orElse("World");
		System.out.println(orElse);
		
	}
}
