package ImperialProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import ImperialProgramming.Person.Gender;

public class Main {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("George", Gender.MALE),
				new Person("Alice",Gender.FEMALE),
				new Person("Raymond", Gender.MALE),
				new Person("Nelson", Gender.MALE),
				new Person("Martha",Gender.FEMALE));
		
		
		//Imperative Approch
		System.out.println("Imperative Approch");
		
		List<Person> females = new ArrayList<Person>();
		
		for(Person person : people) {
			if(Gender.FEMALE.equals(person.getGender())){
				females.add(person);
			}
		}
		for (Person person : females) {
			System.out.println(person);
		}
		
		System.out.println("Declarative approch");
		//Declarative approch
		
		Predicate<Person> personPredicate = person  -> Gender.FEMALE.equals(person.getGender());
		people.stream().filter(personPredicate)
		//.collect(Collectors.toList()) // we dont need to collect coz we are just printing
		.forEach(System.out::println);
		
		
		List<Person> females2 = people.stream().filter(person  -> Gender.FEMALE.equals(person.getGender()))
		.collect(Collectors.toList());
		
		females2.forEach(System.out::print);
	}
	
	
	
	

}

 class Person {
	 
	 private final String name;
	 private final Gender gender;
	
	 public Person(String name, Gender gender) {
		super();
		this.name = name;
		this.gender = gender;
	}
	 
	 public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + "]";
	}



	enum Gender{
			MALE,FEMALE
		}
}

