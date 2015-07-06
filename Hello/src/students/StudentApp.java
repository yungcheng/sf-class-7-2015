package students;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentApp {

	public static void doStuff(Student... students) {
		for (Student s : students) {
			System.out.println("> " + s);
		}
	}

	public static void main(String[] args) {
		List<Student> roster = Arrays.asList(new Student("Fred", "Jones", 21,
				3.7F), new Student("Jim", "Smith", 19, 3.8F), new Student(
				"Sheila", "Hopper", 22, 3.6F));
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

	}
}
