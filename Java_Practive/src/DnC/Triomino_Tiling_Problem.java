package DnC;

public class Triomino_Tiling_Problem {

	int[][] grid;
	int holeRow, holeCol;

	public Triomino_Tiling_Problem(int size, int holeRow, int holeCol) {
		grid = new int[size][size];
		grid[holeRow][holeCol] = 1;
	}
	
	private int getQuadrant(int row, int col) {
		int position = 0;
		if (holeRow <= row) {
			position = 0;
		} else {
			position = 2;
		}
		
		if(holeCol > col) {
			position++;
		}
		return position;
	}

	private void putMaze(int upRow, int downRow, int leftCol, int rightCol) {
		int dividerRow = (downRow - upRow) / 2;
		int dividerCol = (rightCol - leftCol) / 2;

		System.out.println(dividerRow);
		System.out.println(dividerCol);
		
		int holeQuadrant = getQuadrant(dividerRow, dividerCol);
		
		switch(holeQuadrant) {
		
		}
	}

	private static void recurseSolution() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
