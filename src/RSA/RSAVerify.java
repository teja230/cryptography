package RSA;

import java.math.*;

public class RSAVerify {

	public static void main(String[] args) {
		{
			BigInteger n = new BigInteger("18721");
			BigInteger b1 = new BigInteger("43");
			BigInteger b2 = new BigInteger("7717");
			BigInteger y1 = new BigInteger("12677");
			BigInteger y2 = new BigInteger("14702");
			BigInteger c1 = new BigInteger("0");
			BigInteger c2 = new BigInteger("0");
			BigInteger x = new BigInteger("0");
			BigInteger temp1 = new BigInteger("0");
			BigInteger one = new BigInteger("1");
			System.out.println("Encrypted message sent to bob using x value is:" + y1);
			c1 = b1.modInverse(b2);
			System.out.println("Value of c1: " + c1);
			c2 = c1.multiply(b1).subtract(one).divide(b2);
			System.out.println("Value of c2:" + c2);
			temp1 = y2.modPow(c2, n);
			BigInteger temp = temp1.modInverse(n);
			x = y1.pow(c1.intValue()).multiply(temp).mod(n);
			System.out.println("The actual message is " + x);
			temp1 = x.modPow(b1, n);
			System.out.println("Encrypted message sent to bob using x value is:" + temp1);
			if (temp1.compareTo(y1) == 0)
				System.out
						.println("The message encrypted using calculated x matches with the orignal encryped message");
			else
				System.out.println("Doesnot Match");
		}
	}

}