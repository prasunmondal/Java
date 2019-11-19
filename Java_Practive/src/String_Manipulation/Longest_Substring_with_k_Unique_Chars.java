package String_Manipulation;

/*


Find the longest substring with k unique characters in a given string
Given a string you need to print longest possible substring that has exactly M unique characters. If there are more than one substring of longest possible length, then print any one of them.
Examples:

"aabbcc", k = 1
Max substring can be any one from {"aa" , "bb" , "cc"}.

"aabbcc", k = 2
Max substring can be any one from {"aabb" , "bbcc"}.

"aabbcc", k = 3
There are substrings with exactly 3 unique characters
{"aabbcc" , "abbcc" , "aabbc" , "abbc" }
Max is "aabbcc" with length 6.

"aaabbb", k = 3
There are only two unique characters, thus show error message. 

 */

public class Longest_Substring_with_k_Unique_Chars {

	static int[] charMap = new int[26];
	static int uniqueChar = 0;
	static int left = 0;
	static int right = 0;
	static String str = "";

	public static void add(char ch) {
		int index = ch - 97;
		if (charMap[index] == 0) {
			uniqueChar++;
		}
		charMap[index]++;
	}

	public static void remove(char ch) {
		int index = ch - 97;
		if (charMap[index] == 1) {
			uniqueChar--;
		}
		charMap[index]--;
	}

	public static boolean doesContainKUniqueAlphabets(int k) {
		return uniqueChar == k;
	}

	public static void printWindow() {
		System.out.print("Left :" + left);
		System.out.println("  Right: " + right);
		System.out.println("String: " + str.substring(left, right));
		System.out.println("UniqC: " + uniqueChar);
	}

	public static void increaseWindow() {
		if (right < str.length())
			add(str.charAt(right));
		right++;
	}

	public static void decreaseWindow() {
		if (left < str.length())
			remove(str.charAt(left));
		left++;
	}

	public static String getMaxString(int k) {
		String maxStr = "";
		int maxLen = 0;

		while (right <= str.length()) {
			System.out.println();
			if (uniqueChar > k) {
				decreaseWindow();
			} else if (uniqueChar < k) {
				increaseWindow();
			} else {
				int currentStrLen = right - left;
				if (maxLen < currentStrLen) {
					maxLen = currentStrLen;
					System.out.println("LW: " + left + " RW: " + right + "    String: " + str.substring(left, right));
					maxStr = str.substring(left, right);
				}
				increaseWindow();
			}
			if (right <= str.length())
				printWindow();

		}
		return maxStr;
	}

	public static void main(String[] args) {
		str = "abcddddeeffgghko";
		System.out.println(getMaxString(4));
//		System.out.println(str.substring(2,6));
	}

}
