package Permutation;

import java.io.*;

public class PermutationMain {
	public static void main(String[] args) {
		String cipher = "";
		try {
			StringBuilder fileData = new StringBuilder(1000);
			String filePath = new File("").getAbsolutePath();
			BufferedReader reader = new BufferedReader(new FileReader(new StringBuilder().append(filePath).append("/src/Permutation/Cipher 4.txt").toString()));
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
		Permutation p = new Permutation(cipher);
		p.charCount();
	}
}
