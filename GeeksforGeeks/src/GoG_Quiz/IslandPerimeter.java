package GoG_Quiz;

//https://leetcode.com/problems/island-perimeter/
import static java.lang.System.out;

public class IslandPerimeter {
	static int[][] island = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };

	public static void main(String[] args) {
		out.println(islandPerimeter(island));
	}

	public static int islandPerimeter(int[][] grid) {
		int peri = 0;
		int row = 0, col = 0;
		while (row < grid.length) {

			if (grid[row][col] == 1) {
				peri += 4;

				if (col + 1 != grid[row].length && grid[row][col + 1] == 1) {
					peri -= 2;
				}
				if (row + 1 != grid.length && grid[row + 1][col] == 1) {
					peri -= 2;
				}
			}
			if (col == grid[row].length - 1) {
				row++;
				col = 0;
			} else {
				col++;
			}
		}
		return peri;
	}
}
