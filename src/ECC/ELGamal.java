
package ECC;

class ElGamal {

	ECCPoint alpha;
	ECCPoint beta;
	ECCPoint x;
	ECCPoint y1, y2, Dk;
	int pk;
	int k;

	ElGamal(ECCPoint alpha, int pk, int k) {
		this.alpha = alpha;
		this.pk = pk;
		beta = alpha.multiply(pk);
		this.k = k;
	}

	ElGamal(ECCPoint alpha, ECCPoint beta, int k) {
		this.alpha = alpha;
		this.beta = beta;
		this.k = k;
		System.out.println("ElGamal Encyption and Decryption");
	}

	void encrypt(ECCPoint x) {
		System.out.println("Elgamal Encryption...");
		this.x = x;
		y1 = alpha.multiply(k);
		y2 = beta.multiply(k).add(x);
		System.out.println("The ElGamal Cipher text is: " + y1.print() + " " + y2.print() + " over " + y2.z);
	}

	ECCPoint decrypt(ECCPoint y1, ECCPoint y2) {
		System.out.println("Elgamal decryption...");
		ECCPoint p1 = y1.multiply(getKey());
		ECCPoint p2 = y2.add(p1.minus());
		System.out.println("The ElGamal Plain text is: " + p2.printNextLine());
		return p2;
	}

	int getKey() {
		ECCPoint pk1 = alpha;
		int mark = 0;
		for (int i = 0; i < pk1.z; i++) {
			pk1 = pk1.add(alpha);
			if (pk1.equals(beta)) {
				mark = i;
				break;
			}
			if (!pk1.validate()) {
				System.out.print(pk1.printNextLine());
				System.out.println("not verified!");
				break;
			}
		}

		System.out.println("The ElGamal key is = " + (mark + 2));
		return mark + 2;
	}
}
