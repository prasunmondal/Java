/*




Given an array A of N positive integers and another number X. Determine whether or not there exist two elements in A whose sum is exactly X.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N and X, N is the size of array. The second line of each test case contains N integers representing array elements A[i].

Output:
Print "Yes" if there exist two elements in A whose sum is exactly X, else "No" (without quotes).

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 105
1 ≤ A[i] ≤ 105

Example:
Input:
2
6 16
1 4 45 6 10 8
5 10
1 2 4 3 6

Output:
Yes
Yes

Explanation:
Testcases 1: 10 and 6 are numbers making a pair whose sum is equal to 16.




 */

package Pop_Algo;

import java.util.HashSet;
import PrsnUtils.PrsnUtils;

public class Pair_To_Get_Sum {
	int[] array;

	public Pair_To_Get_Sum(int[] array) {
		this.array = array;
	}

	public boolean pair(int sum) {
		HashSet<Integer> comp = new HashSet<Integer>();

		for (int i = 0; i < array.length; i++) {
			if(comp.contains(sum-array[i]))
				return true;
			comp.add(array[i]);
			PrsnUtils.printArray(comp.toArray());
		}
		return false;
	}

	public static void main(String[] args) {
		int[] array = { 1, 4, 2, 6, 8, 3 };
		Pair_To_Get_Sum ptgs = new Pair_To_Get_Sum(array);
		int reqSum = 10;
		System.out.println(ptgs.pair(reqSum));
	}
}
