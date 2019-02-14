
package Elgamal;

import java.math.*;

public class ElgamalUse {
	BigInteger p = new BigInteger("31847");
	BigInteger alpha = new BigInteger("5");
	int a = 7899;
	BigInteger beta = new BigInteger("18074");
	BigInteger temp = new BigInteger("0");
	BigInteger temp1 = new BigInteger("0");

	/**
	 *
	 * @param y1
	 * @param y2
	 * @return
	 */
	public String calc(String y1, String y2) {
		String x = "";
		BigInteger d1 = new BigInteger(y1);
		BigInteger d2 = new BigInteger(y2);
		temp = d1.pow(a);
		temp = temp.modInverse(p);
		temp1 = d2.mod(p);
		temp = temp.multiply(temp1);
		temp = temp.mod(p);
		// System.out.println(y1+"\n"+y2);
		// System.out.println(temp);
		String t1 = temp.toString();
		int i = Integer.parseInt(t1);
		int j1 = (i / (26 * 26)) + 97;
		int t = i % (26 * 26);
		int j2 = (t / 26) + 97;
		int j3 = (t % 26) + 97;
		// System.out.println((char)j1+" "+(char)j2+" "+(char)j3);
		x = (char) j1 + "" + (char) j2 + "" + (char) j3;
		return (x);
	}
}
