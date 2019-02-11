
package RSA;

import java.io.*;
import java.math.*;

public class GetRSAValues {

	static final BigInteger ONE = new BigInteger("1");

	public static void main(String[] args) throws IOException {

		{

			BigInteger n = new BigInteger("68102916241556953901301068745501609390192169871097881297");

			BigInteger b = new BigInteger("36639088738407540894550923202224101809992059348223191165");

			BigInteger p = new BigInteger("0");

			BigInteger q = new BigInteger("0");

			BigInteger a = new BigInteger("0");

			BigInteger temp = new BigInteger("1"); // ;

			BigInteger temp1 = new BigInteger("28595220443600602493861284158505136951947525031399288434");

			// char [] mat1= {};

			for (int j = 2; j < 1500; j++)

			{

				if (temp.compareTo(ONE) == 0)

				{

					a = a.pow(j);

					System.out.println("Value of a is" + a);

					System.out.println(" & n is" + n + " j=" + j);

					a = a.mod(n);

					System.out.println("Still in for loop" + a);

				}

				else

				{

					System.out.println("Fail");

					break;

				}

				temp = a.subtract(ONE);

				temp = temp.gcd(n);

				System.out.println("Temp1 is of Value:" + temp);

			}

			p = temp;
			q = n.divide(temp);

		}
	}
}
