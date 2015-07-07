package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class Words {

	public static void main(String[] args) throws Throwable {
		IntSummaryStatistics c = Files
			.newBufferedReader(Paths.get("pride.txt"))
			.lines()
			.flatMap(s->Arrays.stream(s.split("\\W+")))
			.map(s->s.toUpperCase())
//			.filter(s->s.equals("WICKHAM"))
			.mapToInt(s->s.length())
			.summaryStatistics();
//			.count();
		System.out.println("stats are " + c);
			//			.forEach(s->System.out.println(s));
	}

}
