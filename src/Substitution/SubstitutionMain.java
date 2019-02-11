
package Substitution;

import java.io.*;

public class SubstitutionMain {

	public static void main(String[] args) {
		String cipher = "";
		try {
			StringBuilder fileData = new StringBuilder(1000);
			BufferedReader reader = new BufferedReader(new FileReader("Cipher 1.txt"));
			char[] buf = new char[1024];
			int numRead = 0;
			while ((numRead = reader.read(buf)) != -1) {
				String readData = String.valueOf(buf, 0, numRead);
				fileData.append(readData);
				buf = new char[1024];
			}
			reader.close();
			String str = fileData.toString();
			cipher = str;

		} catch (Exception e) {
			System.out.println("File not found");
		}
		Frequency f = new Frequency(cipher);
		f.frequencyCount();
		Digram d = new Digram(cipher);
		d.digramCount();
		Tigram t = new Tigram(cipher);
		t.tigramCount();
	}

}
