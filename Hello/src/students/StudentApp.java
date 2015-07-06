package students;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentApp {

	public static void doStuff(Student ... students) {
		for (Student s : students) {
			System.out.println("> " + s);
		}
	}
	
	public static void main(String[] args) {
		List<Student> roster = Arrays.asList(
				new Student("Fred", "Jones", 21, 3.7F),
				new Student("Jim", "Smith", 19, 3.8F),
				new Student("Sheila", "Hopper", 22, 3.6F)
				);
		doStuff((Student[])(roster.toArray()));
		System.out.println("class> " + roster);
		
		Collections.sort(roster);
		System.out.println("by age> " + roster);

		Collections.sort(roster, 
				Student.getGpaComparator());
		System.out.println("by gpa> " + roster);
	}

}
