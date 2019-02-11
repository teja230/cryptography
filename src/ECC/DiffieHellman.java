
package ECC;

class DiffieHellman {

	ECCPoint alpha;
	ECCPoint aliceMsg;
	ECCPoint bobMsg;
	int z;

	DiffieHellman(ECCPoint alpha, ECCPoint aliceMsg, ECCPoint bobMsg) {
		this.alpha = alpha;
		this.aliceMsg = aliceMsg;
		this.bobMsg = bobMsg;
		z = 1039;
	}

	void commonSecret() {
		System.out.print("Alice's key:");
		int alicekey = getKey(aliceMsg);
		ECCPoint point = alpha.multiply(alicekey);
		System.out.println("Alice's Msg: " + point.printNextLine());
		System.out.println();
		System.out.print("Bob's key:");
		int bobkey = getKey(bobMsg);
		point = alpha.multiply(bobkey);
		System.out.print("Bob's Msg: " + point.printNextLine());
		System.out.println();
		System.out.println();
		ECCPoint p1 = alpha.multiply(overZ(alicekey * bobkey));
		System.out.print("Common Secret between Alice and Bob: " + p1.printNextLine());
	}

	int overZ(int num) {
		while (num < 0) {
			num += z;
		}
		num = num % z;
		return num;
	}

	int getKey(ECCPoint eccp) {
		ECCPoint p1 = alpha;
		int mark = 0;
		for (int i = 0; i < p1.z; i++) {
			p1 = p1.add(alpha);
			if (p1.equals(eccp)) {
				mark = i;
				break;
			}
			if (!p1.validate()) {
				System.out.print(p1.printNextLine());
				System.out.println("not verified!");
				break;
			}
		}
		System.out.println(" " + (mark + 2));
		return mark + 2;
	}
}
