package Pop_Algo;

public class MaxWaterTrappedByPairOfVerticalLines {

	public static int getWaterStored(int[] heights, int index1, int index2) {
		int len = Math.abs(index2 - index1);
		int height = Math.min(heights[index1], heights[index2]);
		return height * len;
	}

	public static int getMaxWater(int[] heights) {
		int pointer1 = 0, pointer2 = heights.length - 1, maxWater = 0;
		while (pointer1 < pointer2) {
			if (maxWater < getWaterStored(heights, pointer1, pointer2)) 
				maxWater = getWaterStored(heights, pointer1, pointer2);
			
			if (heights[pointer1] < heights[pointer2])
				pointer1++;
			else
				pointer2--;
		}
		return maxWater;
	}

	public static void main(String[] args) {
		int[] heights = { 1, 2, 1, 3, 4, 4, 5, 6, 2, 1, 3, 1, 3, 2, 1, 2, 4, 1 };
		System.out.println(getMaxWater(heights));
	}

}
