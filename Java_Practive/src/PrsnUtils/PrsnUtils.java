package PrsnUtils;

import java.util.HashSet;

public class PrsnUtils {
	
	public static void printArray(int[] array) {
		int i=0;
		System.out.print("[");
		for(i=0; i<array.length-1; i++) {
			System.out.print(array[i] + ", ");
		}System.out.println(array[i] + "]");
	}
	
	public static void printArray(Object[] array) {
		int i=0;
		System.out.print("[");
		for(i=0; i<array.length-1; i++) {
			System.out.print(array[i] + ", ");
		}System.out.println(array[i] + "]");
	}
	
	public static void printCollection(HashSet<Integer> comp) {
		printArray(comp.toArray());
	}
}