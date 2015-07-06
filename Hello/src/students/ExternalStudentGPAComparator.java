package students;

import java.util.Comparator;

public class ExternalStudentGPAComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		float gpa1 = o1.getGpa(), gpa2 = o2.getGpa();
		
		return gpa1 > gpa2 ? +1
				: gpa1 < gpa2 ? -1
				: 0;
	}

}
