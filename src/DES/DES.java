/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DES;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;

public class DES {
	String str, key;
	static final int[] IP = { 58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14,
			6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45,
			37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7 };
	static final int[] E = { 32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17,
			18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1 };
	static final int[] P = { 16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9,
			19, 13, 30, 6, 22, 11, 4, 25 };
	static final int[] FP = { 40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62,
			30, 37, 5, 45, 13, 53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27, 34, 2, 42,
			10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25 };
	static final int[] PC1 = { 57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11,
			3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13,
			5, 28, 20, 12, 4 };
	static final int[] PC2 = { 14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2,
			41, 52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32 };
	static final int[] SHIFTS = { 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 };

	DES(String s, String key) {
		str = s;
		this.key = key;
	}

	void runDES() throws Exception {
		String binStr = "";
		for (int i = 0; i < str.length(); i++) {
			String temp;
			char c = str.charAt(i);
			temp = Integer.toBinaryString(Character.digit(str.charAt(i), 16));
			if (c != 10 && c != 13) {
				String temp1 = temp;
				if (temp1.length() == 1) {
					temp1 = 0 + 0 + 0 + temp1;
				}
				if (temp1.length() == 2) {
					temp1 = 0 + 0 + temp1;
				}
				if (temp1.length() == 3) {
					temp1 = 0 + temp1;
				}
				binStr = binStr + temp1;
			}
		}
		// System.out.println(binStr.length());
		int size = binStr.length();
		int value = binStr.length() / 64;
		// System.out.println(value);
		int k = 64;
		int n1 = 0, n2 = k;
		String[] sb = new String[value];
		// System.out.println(binStr);
		for (int l = 0; l < value; l++) {
			sb[l] = binStr.substring(n1, n2);
			// System.out.println("length of sub string is: "+sb[l].length());
			n1 = n2;
			n2 = n2 + k;
			// System.out.println(sb[l]);
		}
		// System.out.println(binStr);
		// stringToFile(binStr);
		String binKey = "";
		for (int i = 0; i < key.length(); i++) {
			String temp = "";
			temp = Integer.toBinaryString(Character.digit(key.charAt(i), 16));
			if (temp.length() == 1) {
				temp = 0 + 0 + 0 + temp;
			}
			if (temp.length() == 2) {
				temp = 0 + 0 + temp;
			}
			if (temp.length() == 3) {
				temp = 0 + temp;
			}
			binKey = binKey + temp;
		}
		// System.out.println(binKey+""+binKey.length());
		byte b[] = getInByte(binKey);
		// printBytes(b,"The Key is");
		byte[][] subKeys = getSubkeys(b);
		int rows = subKeys.length;
		int cols = subKeys[0].length;
		byte[][] subKeysReverse = new byte[rows][cols];
		for (int i = 0; i < rows; i++) {
			System.arraycopy(subKeys[i], 0, subKeysReverse[rows - 1 - i], 0, cols);
		}
		// printBytes(subKeysReverse,"The reverse");

		// printBytes(msg,"The passed message");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your choice" + "\n" + "1.Encrypt" + "\n" + "2.Decrypt");
		int ch = input.nextInt();
		String binStrA = "";
		byte[] cipherBlock = new byte[64];
		System.out.println(binStr);
		/*
		 * System.out.println(totalText.length);
		 * System.out.println(cipherBlock.length);
		 */
		// int n;
		String temp = "";
		if (ch == 1) {
			for (int i = 0; i < value; i++) {
				byte[] msg = getInByte(sb[i]);
				cipherBlock = cipherBlock(msg, subKeys);
				temp = byteToHexString(cipherBlock);
				binStrA = binStrA + temp;
			}
		}
		if (ch == 2) {
			for (int i = 0; i < value; i++) {
				byte[] msg = getInByte(sb[i]);
				cipherBlock = cipherBlock(msg, subKeysReverse);
				temp = byteToHexString(cipherBlock);
				binStrA = binStrA + temp;
			}
		}
		System.out.println("Final text in HexaDecimal" + "\n" + binStrA);
		String plainText = convertHexToString(binStrA);
		System.out.print("The final ASCII text is:" + "\n" + plainText);
		// totalText=binStrA.getBytes();
		// printBytes(totalText,"Final Message");
	}

	private static byte[] cipherBlock(byte[] theMsg, byte[][] subKeys) throws Exception {
		if (theMsg.length < 8)
			throw new Exception("Message is less than 64 bits.");
		printBytes(theMsg, "Input message");
		theMsg = selBits(theMsg, IP); // Initial Permutation
		// printBytes(theMsg,"After initial permutation");
		int blockSize = IP.length;
		byte[] l = selBits(theMsg, 0, blockSize / 2);
		byte[] r = selBits(theMsg, blockSize / 2, blockSize / 2);
		int numOfSubKeys = subKeys.length;
		for (int k = 0; k < numOfSubKeys; k++) {
			byte[] rBackup = r;
			r = selBits(r, E); // Expansion
			// printBytes(r,"R: After E expansion");
			r = doXORBytes(r, subKeys[k]); // XOR with the sub key
			// printBytes(r,"R: After XOR with the subkey");
			r = substitution6x4(r); // Substitution
			// printBytes(r,"R: After S boxes");
			r = selBits(r, P); // Permutation
			// printBytes(r,"R: After P permutation");
			r = doXORBytes(l, r); // XOR with the previous left half
			// printBytes(r,"Right half at round #"+(k+1));
			l = rBackup; // Taking the previous right half
		}
		byte[] lr = concatBits(r, blockSize / 2, l, blockSize / 2);
		// printBytes(lr,"After 16 rounds");
		lr = selBits(lr, FP); // Inverse Permutation
		printBytes(lr, "After final permutation");
		return lr;
	}

	private static byte[] doXORBytes(byte[] a, byte[] b) {
		byte[] out = new byte[a.length];
		for (int i = 0; i < a.length; i++) {
			out[i] = (byte) (a[i] ^ b[i]);
		}
		return out;
	}

	static final int[] S = { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7, // S1
			0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8, 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0,
			15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13, 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10, // S2
			3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5, 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15,
			13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9, 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8, // S3
			13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1, 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7,
			1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12, 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15, // S4
			13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9, 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4,
			3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14, 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9, // S5
			14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6, 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14,
			11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3, 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11, // S6
			10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8, 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6,
			4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13, 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1, // S7
			13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6, 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2,
			6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12, 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7, // S8
			1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2, 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8,
			2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11 };

	private static byte[] substitution6x4(byte[] in) {
		in = splitBytes(in, 6); // Splitting byte[] into 6-bit blocks
		// printBytes(in,"R: After splitting");
		byte[] out = new byte[in.length / 2];
		int lhByte = 0;
		for (int b = 0; b < in.length; b++) { // Should be sub-blocks
			byte valByte = in[b];
			int r = 2 * (valByte >> 7 & 0x0001) + (valByte >> 2 & 0x0001); // 1
																			// and
																			// 6
			int c = valByte >> 3 & 0x000F; // Middle 4 bits
			int hByte = S[64 * b + 16 * r + c]; // 4 bits (half byte) output
			if (b % 2 == 0)
				lhByte = hByte; // Left half byte
			else
				out[b / 2] = (byte) (16 * lhByte + hByte);
		}
		return out;
	}

	private static byte[][] getSubkeys(byte[] theKey) throws Exception {
		printBytes(theKey, "Input key");
		int activeKeySize = PC1.length;
		int numOfSubKeys = SHIFTS.length;
		byte[] activeKey = selBits(theKey, PC1);
		// printBytes(activeKey,"After permuted choice 1 - Active key");
		int halfKeySize = activeKeySize / 2;
		byte[] c = selBits(activeKey, 0, halfKeySize);
		byte[] d = selBits(activeKey, halfKeySize, halfKeySize);
		byte[][] subKeys = new byte[numOfSubKeys][];
		for (int k = 0; k < numOfSubKeys; k++) {
			c = rotateLeft(c, halfKeySize, SHIFTS[k]);
			d = rotateLeft(d, halfKeySize, SHIFTS[k]);
			byte[] cd = concatBits(c, halfKeySize, d, halfKeySize);
			// printBytes(cd,"Subkey #"+(k+1)+" after shifting");
			subKeys[k] = selBits(cd, PC2);
			printBytes(subKeys[k], "Subkey #" + (k + 1));
		}
		return subKeys;
	}

	private static byte[] splitBytes(byte[] in, int len) {
		int numOfBytes = (8 * in.length - 1) / len + 1;
		byte[] out = new byte[numOfBytes];
		for (int i = 0; i < numOfBytes; i++) {
			for (int j = 0; j < len; j++) {
				int val = getBit(in, len * i + j);
				setBit(out, 8 * i + j, val);
			}
		}
		return out;
	}

	private static byte[] rotateLeft(byte[] in, int len, int step) {
		int numOfBytes = (len - 1) / 8 + 1;
		byte[] out = new byte[numOfBytes];
		for (int i = 0; i < len; i++) {
			int val = getBit(in, (i + step) % len);
			setBit(out, i, val);
		}
		return out;
	}

	private static byte[] concatBits(byte[] a, int aLen, byte[] b, int bLen) {
		int numOfBytes = (aLen + bLen - 1) / 8 + 1;
		byte[] out = new byte[numOfBytes];
		int j = 0;
		for (int i = 0; i < aLen; i++) {
			int val = getBit(a, i);
			setBit(out, j, val);
			j++;
		}
		for (int i = 0; i < bLen; i++) {
			int val = getBit(b, i);
			setBit(out, j, val);
			j++;
		}
		return out;
	}

	private static byte[] selBits(byte[] in, int pos, int len) {
		int numOfBytes = (len - 1) / 8 + 1;
		byte[] out = new byte[numOfBytes];
		for (int i = 0; i < len; i++) {
			int val = getBit(in, pos + i);
			setBit(out, i, val);
		}
		return out;
	}

	private static byte[] selBits(byte[] in, int[] map) {
		int numOfBytes = (map.length - 1) / 8 + 1;
		byte[] out = new byte[numOfBytes];
		for (int i = 0; i < map.length; i++) {
			int val = getBit(in, map[i] - 1);
			setBit(out, i, val);
			// System.out.println("i="+i+", pos="+(map[i]-1)+", val="+val);
		}
		return out;
	}

	private static int getBit(byte[] data, int pos) {
		int posByte = pos / 8;
		int posBit = pos % 8;
		byte valByte = data[posByte];
		int valInt = valByte >> (8 - (posBit + 1)) & 0x0001;
		return valInt;
	}

	private static void setBit(byte[] data, int pos, int val) {
		int posByte = pos / 8;
		int posBit = pos % 8;
		byte oldByte = data[posByte];
		oldByte = (byte) (((0xFF7F >> posBit) & oldByte) & 0x00FF);
		byte newByte = (byte) ((val << (8 - (posBit + 1))) | oldByte);
		data[posByte] = newByte;
	}

	private static void printBytes(byte[] data, String name) {
		System.out.println("");
		System.out.println(name + ":");
		for (int i = 0; i < data.length; i++) {
			System.out.print(byteToBits(data[i]) + " ");
		}
		System.out.println();
	}

	private static String byteToHexString(byte[] block) {
		StringBuilder buf = new StringBuilder();
		char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		int len = block.length;
		int high = 0;
		int low = 0;
		for (int i = 0; i < len; i++) {
			high = ((block[i] & 0xf0) >> 4);
			low = (block[i] & 0x0f);
			buf.append(hexChars[high]);
			buf.append(hexChars[low]);
		}
		return buf.toString();
	}

	private static String convertHexToString(String hex) {

		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();

		for (int i = 0; i < hex.length() - 1; i += 2) {

			String output = hex.substring(i, (i + 2));

			int decimal = Integer.parseInt(output, 16);

			sb.append((char) decimal);

			temp.append(decimal);
		}

		return sb.toString();
	}

	private static String byteToBits(byte b) {
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < 8; i++)
			buf.append((int) (b >> (8 - (i + 1)) & 0x0001));
		return buf.toString();
	}

	private static byte[] getInByte(String binKey) {
		String strKey = binKey;
		byte[] theKey = new byte[8];
		int k = 8;
		int n1 = 0;
		int n2 = k;
		for (int i = 0; i < 8; i++) {
			String strByte = strKey.substring(n1, n2);
			theKey[i] = (byte) Integer.parseInt(strByte, 2);
			n1 = n2;
			n2 = n1 + k;
		}
		return theKey;
	}
}