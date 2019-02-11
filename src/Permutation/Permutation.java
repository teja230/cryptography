package Permutation;

public class Permutation {
	String s;

	public Permutation(String str) {
		s = str;
	}

	void charCount() {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 65 && c <= 90) {
				count++;
			}
		}
		System.out.println("The count of characters is: " + count);
	}
}