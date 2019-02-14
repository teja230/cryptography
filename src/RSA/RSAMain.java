package RSA;

import java.io.*;

public class RSAMain {
	public static void main(String[] args) throws IOException {
		String cipher = "";
		try {
			StringBuilder fileData = new StringBuilder(1000);
			String filePath = new File("").getAbsolutePath();
			BufferedReader reader = new BufferedReader(new FileReader(new StringBuilder().append(filePath).append("/src/RSA/RSA-ciphertext.txt").toString()));
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
		RSA r = new RSA(cipher);
		r.runRSA();
	}
}
