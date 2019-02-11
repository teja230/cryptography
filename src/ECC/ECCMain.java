
package ECC;

import java.util.*;

class ECCMain {

	public static void main(String[] args) {
		// count and largest point
		ECCPoint a = new ECCPoint(799, 790, 1039);
		ECCPoint b = a;
		ECCPoint max = b;
		int mark = 0;
		for (int i = 0; i < 1039; i++) {
			if (max.distance() < b.distance()) {
				max = b;
			}
			if (!b.ifEquals(a)) {
				b = b.add(a);
			} else {
				mark = i;
				break;
			}
		}
		System.out.println("There are " + (mark + 1) + " points on the curve over Z1039");
		System.out.println();
		System.out.println("The lexically largest largest point is: " + max.print());
		System.out.println("");
		// validating existence of a point
		System.out.println("Validating existence of a point:");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the value of x(given 1014):");
		int x = input.nextInt();
		System.out.println("Enter the value of y(given 291):");
		int y = input.nextInt();
		// System.out.println("Enter value of z(given 1039):");
		// int z=input.nextInt();
		ECCPoint a1 = new ECCPoint(x, y, 1039);
		if (a1.validate()) {

			System.out.println("" + a1.print() + "  belongs to Z1039");

		} else {
			System.out.println("" + a1.print() + "  doesn't belongs to Z1039");
		}
		System.out.println();
		// Elgamal encryption
		ECCPoint a2 = new ECCPoint(799, 790, 1039);
		ECCPoint b2 = new ECCPoint(385, 749, 1039);
		ElGamal e = new ElGamal(a2, b2, 100);
		ECCPoint plaintext = new ECCPoint(575, 419, 1039);
		e.encrypt(plaintext);
		System.out.println();
		// Elgamal decryption
		ECCPoint cipherY1 = new ECCPoint(873, 233, 1039); // (873,233), (234,14)
		ECCPoint cipherY2 = new ECCPoint(234, 14, 1039);
		e.decrypt(cipherY1, cipherY2);
		System.out.println();
		// Diffie Hellman key exchange
		DiffieHellman dh = new DiffieHellman(new ECCPoint(818, 121, 1039), new ECCPoint(199, 72, 1039),
				new ECCPoint(815, 519, 1039));
		dh.commonSecret();
		System.out.println();
	}
}
