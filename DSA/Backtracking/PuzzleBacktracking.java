import java.util.*;

public class PuzzleBacktracking {
    int[] deltaRow = {-1, 0, 1, 0};
    int[] deltaCol = {0, 1, 0, -1};
    Set<String> visited = new HashSet<>();

    public boolean isSorted(int[][] grid, int M) {
        int previousElement = grid[0][0];
        for (int i = 1; i < M * M; i++) {
            int currentRow = i / M;
            int currentCol = i % M;
            if (grid[currentRow][currentCol] != 0 && previousElement > grid[currentRow][currentCol]) {
                return false;
            }
            previousElement = grid[currentRow][currentCol];
        }
        return true;
    }

    public boolean getOutput(int[][] grid, int takenNumber, int XMarkI, int XMarkJ, int M) {
        // Base case: check if the puzzle is solved
        if (XMarkI == M - 1 && XMarkJ == M - 1 && isSorted(grid, M)) {
            return true;
        }
    
        // Convert grid to string for cycle detection
        String gridState = Arrays.deepToString(grid);
        if (visited.contains(gridState)) {
            return false; // Avoid cycles
        }
        visited.add(gridState); // Mark this state as visited
    
        // Debugging: Print current grid state
        System.out.println("Current grid state:");
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Trying to move from (" + XMarkI + ", " + XMarkJ + ")");
    
        // Explore all four possible directions
        for (int i = 0; i < 4; i++) {
            int neighbourRow = XMarkI + deltaRow[i];
            int neighbourCol = XMarkJ + deltaCol[i];
    
            // Check if the neighbor is within bounds
            if (neighbourRow >= 0 && neighbourRow < M && neighbourCol >= 0 && neighbourCol < M) {
                if (grid[neighbourRow][neighbourCol] != takenNumber) {
                    // Swap the empty cell with the neighbor
                    int temp = grid[XMarkI][XMarkJ];
                    grid[XMarkI][XMarkJ] = grid[neighbourRow][neighbourCol];
                    grid[neighbourRow][neighbourCol] = temp;
    
                    // Recursive call with the new grid state
                    if (getOutput(grid, temp, neighbourRow, neighbourCol, M)) {
                        return true; // Puzzle is solved
                    }
    
                    // Backtrack: Swap back to the original state
                    grid[neighbourRow][neighbourCol] = grid[XMarkI][XMarkJ];
                    grid[XMarkI][XMarkJ] = temp;
                }
            }
        }
        return false; // No solution found in this path
    }
    

    public static void main(String[] args) {
        Scanner rs = new Scanner(System.in);
        int M = rs.nextInt();
        int[][] grid = new int[M][M];
        int XMarkI = 0;
        int XMarkJ = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = rs.nextInt();
                if (grid[i][j] == 0) {
                    XMarkI = i;
                    XMarkJ = j;
                }
            }
        }

        PuzzleBacktracking obj = new PuzzleBacktracking();
        System.out.print(obj.getOutput(grid, 0, XMarkI, XMarkJ, M));
    }
}
