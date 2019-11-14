package String_Manipulation;

/*
 
Problem: Find matching pattern in string

Method: Hashing


*/

public class Rabin_Karp {

	String str;

	public Rabin_Karp(String str) {
		this.str = str;
	}

	private int hashFunction(String str) { // should be changed in case of input changes
		char[] arr = str.toCharArray();
		int value = 0;
		for (int i = 0; i < arr.length; i++) {
			value += Math.pow(2, i) * (arr[i] - 97);
		}
		return value;
	}

	private boolean doesStringMatch(String str1, String str2) {
		return (str1.equals(str2));
	}

	public int findPattern(String pattern) {
		int index = 0;
		int hashValuePattern = hashFunction(pattern);

		for (int i = 0; i < this.str.length() - pattern.length() + 1; i++) {
			String strToMatch = this.str.substring(i, i + pattern.length());
			if (hashFunction(strToMatch) == hashValuePattern 
					&& doesStringMatch(strToMatch, pattern)) {
				System.out.println("Pattern Matched at starting index: " + (i + 1));
			}
		}
		return index;
	}

	public static void main(String[] args) {
		String main = "aaaababaab";
		String pattern = "aba";
		Rabin_Karp rk = new Rabin_Karp(main);
		rk.findPattern(pattern);
	}

}
