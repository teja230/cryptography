package Vigenere;

import java.util.*;

public class Vigenere {
	String s;

	public Vigenere(String str) {
		s = str;
	}

	public void vigCipher() {
		Scanner input = new Scanner(System.in);
		int value;
		// Kasiski test
		while (true) {
			while (true) {
				System.out.println("Enter the string to match:");
				String test = input.next();
				int index1 = s.indexOf(test);
				int i = index1 + 2;
				int index2 = s.indexOf(test, i);
				int index3 = s.lastIndexOf(test);
				int g1 = gcd(index1, index2);
				int g2 = gcd(index2, index3);
				int g = gcd(g1, g2);
				System.out.println("Position1: " + index1 + "\n" + "Position2: " + index2 + "\n" + "Position3: "
						+ index3 + "\n" + "GCD: " + g + "\n");
				// System.out.println("GCD1: "+g1+"GCD2: "+g2);
				// boolean b;
				int j;
				System.out.println("Do You want to try the next method\n 1.Yes\n 2.No");
				j = input.nextInt();
				if (j == 1) {
					value = g;
					break;
				}
			}
			int z;
			System.out.println("Enter the key size(kasiski or your own):");
			z = input.nextInt();
			int n = s.length();
			System.out.println("Length: " + n);
			value = z;
			System.out.println("Possible Keyword size is: " + value);
			int k = (n / value);
			String[] sb = new String[value];
			int n1 = 0, n2 = k;
			for (int l = 0; l < value; l++) {
				sb[l] = s.substring(n1, n2);
				// System.out.println("length of sub string is:
				// "+sb[l].length());
				n1 = n2;
				n2 = n2 + k;
				// System.out.println(""+sb[l].length());
			}
			char[][] blocks = new char[value][k];
			for (int l = 0; l < value; l++) {
				for (int m = 0; m < k; m++)
					blocks[l][m] = sb[l].charAt(m);
			}
			double[] p1 = new double[value];

			int karma = 0;
			for (int l = 0; l < value; l++) {
				HashMap h = new HashMap();
				h.clear();
				String stub = sb[karma];
				for (int i = 0; i < stub.length(); i++) {
					char c = stub.charAt(i);
					if (h.get(c) != null) {
						h.put(c, (Integer) (h.get(c)) + 1);
					} else {
						h.put(c, 1);
					}
				}
				// System.out.print("block["+value+"] :");
				System.out.println(h.entrySet());
				int o = h.size();
				Object[] keys = h.keySet().toArray();
				Object[] values = h.values().toArray();
				int[] count = new int[o];
				String temp2 = "";
				String temp1 = "";
				for (int m = 0; m < o; m++) {
					temp1 = values[m].toString();
					count[m] = Integer.valueOf(temp1);
					// System.out.println(""+count[m]);
					temp2 = temp2 + keys[m].toString();
				}
				char[] c = temp2.toCharArray();
				System.out.println("Calculation for the Index of coincidence for the block[" + l + "]");
				/*
				 * int sum=0; for(int m=0;m<count.length;m++) {
				 * sum=sum+count[m]; }
				 */
				// System.out.println(sum);
				double prob = 0.0;
				double prod1 = 0.0;
				double prod2 = 0.0;
				int a = 0, b = 0;
				for (int p = 0; p < 25; p++) {
					prod1 = ((double) count[p] / (double) k);
					a = count[p] - 1;
					b = k - 1;
					prod2 = ((double) a / (double) b);
					// System.out.println(" "+prod+" ");
					prob = (prob) + (prod1 * prod2);
					// System.out.print(" "+prob+" ");
				}
				p1[karma] = prob;
				System.out.println("The index of coincidence for block[" + l + "] is:" + p1[karma]);
				karma++;
			}
			int q;
			System.out.println("Does the index of coincidence satisfy\n 1.Yes\n 2.No");
			q = input.nextInt();
			if (q == 1) {
				System.out.println("The key size is: " + value);
				break;
			}
		}

	}

	public int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}
}
