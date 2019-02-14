/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DES;

import java.io.*;

public class DesMain {
	public static void main(String[] args) throws Exception {
		String cipher = "";
		try {
			StringBuilder fileData = new StringBuilder(1000);
			String filePath = new File("").getAbsolutePath();
			BufferedReader reader = new BufferedReader(new FileReader(filePath+"/src/DES/cipher.txt"));
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
		// System.out.println(cipher);
		String key = "8B2A7FF25E98C35D";
		DES d = new DES(cipher, key);
		d.runDES();
	}
}
