package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestAnnotation {

	public static void main(String[] args) throws Throwable {
		Class sc = Class.forName("annotation.Stuff");
		Object o = sc.newInstance();
		System.out.println("object is " + o);
		
		Method [] methods = sc.getDeclaredMethods();
		for (Method m : methods) {
			String mName = m.getName();
			ListOCalls lc = m.getAnnotation(ListOCalls.class);
			CallMe[] cma = lc.value();
			CallMe[] cma2 = m.getAnnotationsByType(CallMe.class);
			CallMe a = m.getAnnotation(CallMe.class);
			System.out.println("Method " + mName);
			if (a != null) {
				m.setAccessible(true);
				System.out.println("   has @CallMe(value=" 
						+ a.value() + ")" );
				m.invoke(o);
			}
		}
		
		Field[] fields = sc.getDeclaredFields();
		for (Field f : fields) {
			String fName = f.getName();
			System.out.println("Field: " + fName);
			SetMe sm = f.getAnnotation(SetMe.class);
			if (sm != null) {
				f.setAccessible(true);
				f.set(o, "Set by framework");
			}
		}
		System.out.println("Object o is now " + o);
	}

}
