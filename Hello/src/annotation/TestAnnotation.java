package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestAnnotation {

	public static void main(String[] args) throws Throwable {
		Class sc = Class.forName("annotation.Stuff");
		Object o = sc.newInstance();
		System.out.println("object is " + o);
		
		Method [] methods = sc.getDeclaredMethods();
		for (Method m : methods) {
			String mName = m.getName();
			CallMe a = m.getAnnotation(CallMe.class);
			System.out.println("Method " + mName);
			if (a != null) {
				m.setAccessible(true);
				System.out.println("   has @CallMe");
				m.invoke(o);
			}
		}
	}

}
