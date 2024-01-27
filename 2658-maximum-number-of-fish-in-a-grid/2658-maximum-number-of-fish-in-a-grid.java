class Solution {
    boolean[][] visited;
    public int findMaxFish(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        visited = new boolean[rows][cols];
        int max = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] != 0) {
                    max = Math.max(max, dfs(r, c, cols, rows, grid, visited, 0));
                }
            }
        }

        return max;

    }

    public int dfs(int r, int c, int cols, int rows, int[][] grid, boolean[][] visited, int count){
        if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0 || visited[r][c]){
            return 0;
        }

        visited[r][c] = true;

        count += grid[r][c] + dfs(r + 1, c, cols, rows, grid, visited, count)
        + dfs(r - 1, c, cols, rows, grid, visited, count)
        + dfs(r, c + 1, cols, rows, grid, visited, count)
        + dfs(r, c - 1, cols, rows, grid, visited, count);

        return count;
    }
}