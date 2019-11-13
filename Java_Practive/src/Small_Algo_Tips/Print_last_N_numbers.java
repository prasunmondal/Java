package Small_Algo_Tips;

public class Print_last_N_numbers {

	public static void printLastNNumners(int n, int[] array) {

		int start = -1;
		for (int i = 0; i < array.length; i++) {
			if (i >= n-1) {
				start++;
			}
		}

		for (int i = start; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
	}

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		printLastNNumners(10, array);
	}

}
