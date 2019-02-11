
package ECC;

import java.math.*;

class ECCPoint {

	int x, y;
	int z;
	int a;

	ECCPoint(int x, int y) {
		this(x, y, 1039);
	}

	ECCPoint(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		a = 1;
	}

	boolean equals(ECCPoint eccp) {
		if ((x == eccp.x) && (y == eccp.y)) {
			return true;
		} else {
			return false;
		}
	}

	String print() {
		return ("(" + x + "," + y + ")");
	}

	String printNextLine() {
		return ("(" + x + "," + y + ") over " + z);
	}

	ECCPoint add(ECCPoint eccp) {
		int s;
		int xr, yr;
		if ((eccp.x == x) && (eccp.y == y)) {
			BigInteger b1 = bigInteger(overZ(3 * x * x + a));
			BigInteger b2 = bigInteger(overZ(2 * y));
			b1 = (b1.multiply(b2.modInverse(bigInteger(z)))).mod(bigInteger(z));
			s = b1.intValue();
		} else {
			BigInteger b1 = bigInteger(overZ(y - eccp.y));
			BigInteger b2 = bigInteger(overZ(x - eccp.x));
			b1 = (b1.multiply(b2.modInverse(bigInteger(z)))).mod(bigInteger(z));
			s = b1.intValue();
		}

		xr = overZ(s * s - x - eccp.x);
		yr = overZ(s * overZ(x - xr) - y);
		return new ECCPoint(xr, yr);
	}

	ECCPoint multiply(int a) {
		ECCPoint p1 = new ECCPoint(x, y, z);
		ECCPoint p2 = new ECCPoint(x, y, z);
		for (int i = 0; i < a - 1; i++) {
			p1 = p1.add(p2);
		}
		return p1;
	}

	ECCPoint minus() {
		ECCPoint p1 = new ECCPoint(x, overZ(-y), z);
		return p1;
	}

	int overZ(int a) {
		while (a < 0) {
			a += z;
		}
		a = a % z;
		return a;
	}

	BigInteger bigInteger(int a) {
		BigInteger b = new BigInteger(a + "");
		return b;
	}

	boolean validate() {
		if (overZ(y * y) == overZ(x * x * x + x + 6)) {
			return true;
		} else {
			return false;
		}
	}

	boolean ifEquals(ECCPoint eccp) {
		if ((eccp.x == x) && (eccp.y != y)) {
			return true;
		} else {
			return false;
		}
	}

	int distance() {
		return x * x + y * y;
	}
}
