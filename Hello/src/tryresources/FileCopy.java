package tryresources;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileCopy {

	public static void main(String[] args) {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(
				System.in));
		boolean success = false;
		
		while (!success) {
			System.out.print("Please enter filename: ");
			System.out.flush();
			try (
				FileInputStream fis = new FileInputStream(keyboard.readLine());
				FileOutputStream fos = new FileOutputStream("output.copy");
			) {
				int c;
				while ((c = fis.read()) != -1) fos.write(c);
				success = true;
			} catch (FileNotFoundException fnfe) {
				System.out.println("Not found: " + fnfe.getLocalizedMessage());
			} catch (IOException ioe) {
				System.out.println("Gach, something fatal broke");
				throw new RuntimeException("Unrecoverable io problem", ioe);
			}
		}
	}
}
