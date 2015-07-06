package students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StudentApp {

	public static void doStuff(Student... students) {
		for (Student s : students) {
			System.out.println("> " + s);
		}
	}

	public static <E> List<E> filter(List<E> input, 
			     					Predicate<E> criterion) {
		List<E> rv = new ArrayList<>();
		for (E e : input) {
			if (criterion.test(e)) {
				rv.add(e);
			}
		}
		return rv;
	}
	
	public static Predicate<Student> getAgeMaxFilter(int age) {
		return s -> s.getAge() < age;
	}
	
	public static void main(String[] args) {
		List<Student> roster = Arrays.asList(
				new Student("Fred", "Jones", 21, 3.7F), 
				new Student("Jim", "Smith", 19, 3.8F),
				new Student("Sheila", "Hopper", 22, 3.6F),
				new Student("William", "Franklin", 24, 2.8F)
				);
		doStuff((Student[]) (roster.toArray()));
		System.out.println("class> " + roster);

		Collections.sort(roster);
		System.out.println("by age> " + roster);

		Collections.sort(roster, Student.getGpaComparator());
		System.out.println("by gpa> " + roster);

		Collections.sort(roster, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				float gpa1 = o2.getGpa(), gpa2 = o1.getGpa();
				return gpa1 > gpa2 ? +1 : gpa1 < gpa2 ? -1 : 0;
			}
		});
		System.out.println("by reverse gpa> " + roster);

		Collections.sort(roster, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
		System.out.println("by last name> " + roster);

		// Collections.sort(roster, /*new Comparator<Student>() {*/
		// /*@Override
		// public int compare*/(Student o1, Student o2) -> {
		// return o1.getFirstName().compareTo(o2.getFirstName());
		// }
		// /*}*/);
		// System.out.println("by first name> " + roster);

		Collections.sort(roster, 
			(o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
		System.out.println("by first name> " + roster);

		System.out.println("Students with low gpa " 
				+ filter(roster, s -> s.getGpa() < 3.0F));
		
		Predicate<Student> under21Predicate = s -> s.getAge() < 21;
		System.out.println("Students under 21 " 
				+ filter(roster, under21Predicate));
		
		if (under21Predicate.test(roster.get(0))) {
			System.out.println("student zero is under 21");
		}
		
		int [] ageLimit = { 22 };
		Predicate<Student> mature = s -> s.getAge() > ageLimit[0];
		System.out.println("Students over " + ageLimit[0] 
				+ filter(roster, mature));
		
		ageLimit[0] = 19;
		System.out.println("Students over " + ageLimit[0] 
				+ filter(roster, mature));
		
		System.out.println("Students under 22 " 
				+ filter(roster, getAgeMaxFilter(22)));

		System.out.println("Students under 21 " 
				+ filter(roster, getAgeMaxFilter(21)));
		
	}
}
