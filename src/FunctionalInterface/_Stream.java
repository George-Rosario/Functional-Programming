package FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;



public class _Stream{
	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(new Person("George", Gender.MALE),
				new Person("Alice",Gender.FEMALE),
				new Person("Raymond", Gender.MALE),
				new Person("Nelson", Gender.MALE),
				new Person("Martha",Gender.FEMALE),
				new Person("Simone",Gender.PREFER_NOT_TO_SAY));
		
		
		people.stream().map(person -> person.getGender())
		.collect(Collectors.toSet())
		.forEach(gender -> System.out.println(gender));
		
		
		people.stream().map(person -> person.getName())
		.mapToInt(name -> name.length())
		.forEach(length -> System.out.println(length));
		
		Predicate<? super Person> femalePredicate = person -> Gender.FEMALE.equals(person.getGender());
		boolean containsOnlyFemale = people.stream()
		.allMatch(femalePredicate);
		
		System.out.println(containsOnlyFemale);
		boolean containsOneFemale = people.stream()
				.anyMatch(femalePredicate);
		
		System.out.println(containsOneFemale);
		
		
	}
	
	enum Gender{
		MALE,FEMALE,PREFER_NOT_TO_SAY
	}
	
	static class Person {
		 
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
	}

}