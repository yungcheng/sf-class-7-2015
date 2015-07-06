package iterator;

import java.util.Iterator;

//import java.util.Date;

public class MyListApp {

	public static void main(String[] args) {
		MyList<String> ml = new MyList<>();
		ml.add("Fred");
		ml.add("Jim");
		ml.add("Sheila");
		
		String data = (String)ml.get(2);
		System.out.println("Item 2 is " + data);
		
		//ml.add(new Date()); // not permitted for generic ml
		
		Iterator<String> is = ml.iterator();
		while(is.hasNext()) {
			System.out.println("> " + is.next());
		}
		
		for (String s : ml) {
			System.out.println(">> " + s);
		}
	}

}
