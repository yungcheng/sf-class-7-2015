package students;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map;

public class StreamApp {

	public static void main(String[] args) {
		Stream.of(new Student("Fred", "Jones", 21, 3.7F),
				new Student("Jim", "Smith", 19, 3.8F),
				new Student("Sheila", "Hopper", 22, 3.6F),
				new Student("William", "Franklin", 24, 2.8F))
				.peek(s -> System.out.println("peek: " + s))
				.filter(s -> s.getGpa() > 3.6F).limit(1)
				.forEach(s -> System.out.println("> " + s));

		System.out.println("Over 21:");
		Stream.of(new Student("Fred", "Jones", 21, 3.7F),
				new Student("Jim", "Smith", 19, 3.8F),
				new Student("Sheila", "Hopper", 22, 3.6F),
				new Student("William", "Franklin", 24, 2.8F))
				.filter(s -> s.getAge() > 21)
				.forEach(s -> System.out.println("> " + s));

		System.out.println("Under 21 firstnames:");
		Stream.of(new Student("Fred", "Jones", 21, 3.7F),
				new Student("Jim", "Smith", 19, 3.8F),
				new Student("Sheila", "Hopper", 22, 3.6F),
				new Student("William", "Franklin", 24, 2.8F))
				.filter(s -> s.getAge() < 21)
				.map(s -> s.getFirstName())
				.forEach(s -> System.out.println("> " + s));

		System.out.println("Average age:");
		Stream.of(new Student("Fred", "Jones", 21, 3.7F),
				new Student("Jim", "Smith", 19, 3.8F),
				new Student("Sheila", "Hopper", 22, 3.6F),
				new Student("William", "Franklin", 24, 2.8F))
				.mapToInt(s -> s.getAge())
				.average()
				.ifPresent(System.out::println);
		;

		System.out.println("Formal names:");
		Stream.of(new Student("Fred", "Jones", 21, 3.7F),
				new Student("Jim", "Smith", 19, 3.8F),
				new Student("Sheila", "Hopper", 22, 3.6F),
				new Student("William", "Franklin", 24, 2.8F))
				.map(s -> s.getFirstName().substring(0, 1) + ". "
						+ s.getLastName())
				.forEach(s -> System.out.println("> " + s));
		
		Map<Character, Long> m = 
				Stream.of(new Student("Fred", "Jones", 21, 3.7F),
				new Student("Fred", "Jones", 21, 3.7F),		
				new Student("Jim", "Smith", 19, 3.8F),
				new Student("Sheila", "Hopper", 22, 3.6F),
				new Student("William", "Franklin", 24, 2.8F))
			.collect(
					Collectors.groupingBy(
							s->new Character(s.getLastName().charAt(0)),
							Collectors.counting()
					)
			);
		m.forEach((k,v)-> System.out.println("key " + k 
				+ " has " + v + "elements"));
		
		Stream.of(new Student("Fred", "Jones", 21, 3.7F),
				new Student("Fred", "Jones", 21, 3.7F),		
				new Student("Jim", "Smith", 19, 3.8F),
				new Student("Sheila", "Hopper", 22, 3.6F),
				new Student("William", "Franklin", 24, 2.8F))
			.map(s->s.getAge())
			.reduce((t,u)-> t + u )
			.ifPresent(s->System.out.println("total age is " + s));
	}
}
