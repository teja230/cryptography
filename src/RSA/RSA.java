package RSA;

import java.math.*;

public class RSA {
	String str;
	static final BigInteger ONE = new BigInteger("1");
	BigInteger n = new BigInteger("68102916241556953901301068745501609390192169871097881297");
	BigInteger b = new BigInteger("36639088738407540894550923202224101809992059348223191165");
	BigInteger p = new BigInteger("761059198034099969");
	BigInteger q = new BigInteger("89484387571261623539483274324628239313");
	BigInteger a = new BigInteger("0");
	BigInteger temp = new BigInteger("28595220443600602493861284158505136951947525031399288434");
	String[][] matrix = {

			{ " ", "!", "\"", "#", "$", "%", "&", "'", "(", ")" },

			{ "*", "+", ",", "-", ".", "/", "0", "1", "2", "3" },

			{ "4", "5", "6", "7", "8", "9", ":", ";", "<", "=" },

			{ ">", "?", "@", "A", "B", "C", "D", "E", "F", "G" },

			{ "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q" },

			{ "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "[" },

			{ "\\", "]", "^", "_", "`", "a", "b", "c", "d", "e" },

			{ "f", "g", "h", "i", "j", "k", "l", "m", "n", "o" },

			{ "p", "q", "r", "s", "t", "u", "v", "w", "x", "y" },

			{ "z", "{", "|", "}", "~", " ", " ", "\n", "\r", " " }

	};

	RSA(String str) {
		this.str = str;
	}

	void runRSA() {
		System.out.println("First number is " + p + ",Second Number is " + q);
		BigInteger phi = new BigInteger("1");
		phi = p.subtract(ONE).multiply(q.subtract(ONE));
		System.out.println("Phi() function value is:" + phi);
		a = b.modInverse(phi);
		System.out.println("a function value is:" + a);
		String[] sb = str.split("\n");
		for (int l = 0; l < sb.length; l++) {
			int o = sb[l].length();
			sb[l] = sb[l].substring(0, o - 1);
		}
		String strPtext = "";
		String strDec = "";
		for (int i = 0; i < sb.length; i++) {
			temp = new BigInteger(sb[i]);
			temp = temp.modPow(a, n);
			strDec = temp.toString();
			strPtext = strPtext + strDec;
		}
		plainText(strPtext, matrix);
	}

	private static void plainText(String str, String[][] m) {
		String plainTxt = "";
		System.out.println(str.length());
		for (int i = 0; i < str.length() / 2; i++) {
			String s = str.substring(2 * i, (2 * i) + 2);
			char c1 = s.charAt(0);
			char c2 = s.charAt(1);
			// String s1=(String)c1;
			int i1 = c1 - '0';
			int i2 = c2 - '0';
			// System.out.println(c1+""+c2);
			// System.out.println(i1+""+i2);
			plainTxt = plainTxt + m[i1][i2];
		}
		System.out.println(plainTxt);
	}
}