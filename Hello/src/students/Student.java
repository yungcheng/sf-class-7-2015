package students;

import java.util.Comparator;

public class Student implements Comparable<Student> {
	private String firstName;
	private String lastName;
	private int age;
	private float gpa;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", gpa=" + gpa + "]";
	}

	public Student(String firstName, String lastName, int age, float gpa) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gpa = gpa;
	}

	@Override
	public int compareTo(Student o) {
		return this.age - o.age;
	}
	
	private static Comparator<Student> gpaComparator =
			new StudentGPAComparator();
	public static Comparator<Student> getGpaComparator() {
		return gpaComparator;
	}
	
	private static class StudentGPAComparator implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			return o1.gpa > o2.gpa ? +1
					: o1.gpa < o2.gpa ? -1
					: 0;
		}
	}
}
