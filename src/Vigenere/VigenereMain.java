package Vigenere;

import java.io.*;

public class VigenereMain {
	public static void main(String[] args) {
		String cipher = "", ci = "";
		char c;
		char[] ciph = new char[3000];
		try {
			StringBuilder fileData = new StringBuilder(1000);
			String filePath = new File("").getAbsolutePath();
			BufferedReader reader = new BufferedReader(new FileReader(new StringBuilder().append(filePath).append("/src/Vigenere/Cipher 3.txt").toString()));
			char[] buf = new char[1024];
			int numRead = 0;
			while ((numRead = reader.read(buf)) != -1) {
				String readData = String.valueOf(buf, 0, numRead);
				fileData.append(readData);
				buf = new char[1024];
			}
			reader.close();
			String str = fileData.toString();
			ci = str;
			for (int i = 0; i < str.length(); i++) {
				c = str.charAt(i);
				if (c >= 65 && c <= 90) {
					cipher = cipher + Character.toString(c);
				}
			}
		} catch (Exception e) {
			System.out.println("File not found");
		}
		System.out.println("Your cipher is:");
		System.out.println(cipher);
		Vigenere p = new Vigenere(cipher);
		p.vigCipher();
	}
}
