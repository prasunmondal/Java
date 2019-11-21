package Array;

public class Kadanes_Algorithm {

	private static int kadanesAlgo(int[] arr) {
		int max_so_far = 0;
		int max_ending_here = 0;

		for (int i = 0; i < arr.length; i++) {
			max_ending_here = max_ending_here + arr[i];

			if (max_ending_here < 0)
				max_ending_here = 0;
			if (max_ending_here > max_so_far)
				max_so_far = max_ending_here;
		}
		return max_so_far;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 5, 1, -5, -6, 9 };
		System.out.println(kadanesAlgo(arr));
	}

}
