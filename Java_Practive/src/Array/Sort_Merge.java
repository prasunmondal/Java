package Array;

import PrsnUtils.PrsnUtils;

public class Sort_Merge {

	private static void mergeSort(int[] arr) {
		int left = 0;
		int right = arr.length - 1;

		mergeSortUtil(arr, left, right);
	}

	private static void mergeSortUtil(int[] arr, int left, int right) {
		if (right <= left) // break when it is only one element
			return;
		
		int mid = (right + left) / 2;
		mergeSortUtil(arr, left, mid); // keep creating first half part
		mergeSortUtil(arr, mid + 1, right); // keep creating second half part

		merge(arr, left, mid, right); // merge the first and the second part
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int l1 = mid - left + 1, l2 = right - mid;
		int[] arr1 = new int[l1], arr2 = new int[l2]; // create two arrays of the sub-array length

		for (int i = 0; i < l1; i++) // Copy the elements to the first sub-array
			arr1[i] = arr[i + left];

		for (int i = 0; i < l2; i++) // Copy the elements to the second sub-array
			arr2[i] = arr[mid + 1 + i];

		int i = 0, j = 0, k = left;
		while (i < l1 && j < l2) // merge the two arrays comparing the lowest
			arr[k++] = (arr1[i] <= arr2[j]) ? arr1[i++] : arr2[j++];

		while (i < l1) // if the second sub-array got exhausted. Simple copy the first array
			arr[k++] = arr1[i++];

		while (j < l2) // if the second sub-array got exhausted. Simple copy the first array
			arr[k++] = arr2[j++];
	}

	public static void main(String[] args) {
		int[] arr = { 10, 40, 30, 50, 20, 60, 40 };
		mergeSort(arr);
		PrsnUtils.printArray(arr);
	}
}