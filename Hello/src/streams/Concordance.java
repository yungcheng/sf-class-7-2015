package streams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Concordance {

	public static void main(String[] args) throws Throwable {
		Files.newBufferedReader(Paths.get("pride.txt"))
				.lines()
				.flatMap(s -> Arrays.stream(s.split("\\W+")))
				.filter(s->s.length() > 0)
				.collect(Collectors.groupingBy(s -> s, Collectors.counting()))
				.entrySet()
				.stream()
				.sorted((a, b) -> Long.signum(a.getValue() - b.getValue()))
				.forEach(e -> System.out.println(
						  e.getKey() + " occurs " + e.getValue() + " times"));
		
//		Files.newBufferedReader(Paths.get("pride.txt"))
//		.lines()
//		.forEach(s -> { 
//			String [] sa = s.split("\\W+");
//			for (int i = 0; i < sa.length; i++) {
//				String st = sa[i];
//				if (st.length() == 0) {
//					System.out.println(s + " causes empty at " + i);
//					System.out.println("rejoined:" + String.join("|", sa));
//				}
//			}
//		});
	}
}
