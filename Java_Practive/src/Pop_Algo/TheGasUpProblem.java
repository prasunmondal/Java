package Pop_Algo;

public class TheGasUpProblem {

	public static int ampleCity(int[] gallons, int[] distances) {
		int minCity = -1, minRemaining = 0, totalGallons = 0, totalDistance = 0;

		for (int i = 0; i < gallons.length; i++) {
			totalGallons += gallons[i];
			totalDistance += distances[i];
		}
		int mpg = totalDistance / totalGallons;

		int remaining = 0;
		for (int i = 1; i < gallons.length; i++) {
			remaining += gallons[i - 1] - (distances[i - 1] / mpg);
			if (remaining < minRemaining) {
				minRemaining = remaining;
				minCity = i;
			}
		}
		return minCity;
	}

	public static void main(String[] args) {
		int[] gallons = { 10, 50, 20, 5, 30, 25, 10 };
		int[] distances = { 100, 900, 600, 200, 400, 600, 200 };
		int minCity = ampleCity(gallons, distances);
		System.out.println("MinCity: " + minCity);
		System.out.println("MinCity Gallons: " + gallons[minCity]);
		System.out.println("MinCity Distances: " + distances[minCity]);
	}
}
