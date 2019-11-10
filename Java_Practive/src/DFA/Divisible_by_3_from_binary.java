/*




Is Binary Number Multiple of 3


Given a binary number, write a program that prints 1 if given binary number is a multiple of 3.  Else prints 0. The given number can be big upto 2^100. It is recommended to finish the task using one traversal of input binary string.

Input:
The first line contains T denoting the number of testcases. Then follows description of testcases. 
Each case contains a string containing 0's and 1's.

Output:
For each test case, output a 1 if string is multiple of 3, else 0.

Constraints:
1<=T<=100
1<=Length of Input String<=100

Example:
Input:
2
011
100

Output:
1
0



// Solution 1 (DFA)
 https://www.geeksforgeeks.org/check-binary-string-multiple-3-using-dfa/



// Solution 2
 
Example : 23 (00..10111)
1) Get count of all set bits at odd positions (For 23 it’s 3).
2) Get count of all set bits at even positions (For 23 it’s 1).
3) If difference of above two counts is a multiple of 3 then number is also a multiple of 3.







 */


package DFA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class DFA_divisible_by_3 {
	int remainder = 0;

	public void input(int in) {
		switch (remainder) {
		case 0:
			if (in == 0)
				remainder = 0;
			if (in == 1)
				remainder = 1;
			break;

		case 1:
			if (in == 0)
				remainder = 2;
			if (in == 1)
				remainder = 0;
			break;

		case 2:
			if (in == 0)
				remainder = 1;
			if (in == 1)
				remainder = 2;
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + remainder);
		}
	}

	public int isDivisibleBy3() {
		return remainder == 0 ? 1 : 0;
	}
}

public class Divisible_by_3_from_binary {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int length = str.length();
		DFA_divisible_by_3 dfa = new DFA_divisible_by_3();
		for (int i = 0; i < length; i++) {
			dfa.input(str.charAt(i) - 48);
		}
		System.out.println(dfa.isDivisibleBy3());
	}
}
