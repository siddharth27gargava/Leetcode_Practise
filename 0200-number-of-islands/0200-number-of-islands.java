class Solution {

    boolean[][] visited;

    public int numIslands(char[][] grid) {
        //standard step
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        visited = new boolean[grid.length][grid[0].length];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                //if not visited and matrix value is 1, we can start search for an island and increment count
                if (grid[r][c] == '1' && !visited[r][c]) {
                    count++;
                    //traverse completely all the connected ones since we want to increment only once for all banded ones
                    dfs(r, c, rows, cols, grid, visited);
                }
            }
        }

        return count;
    }

    public void dfs(int r, int c, int rows, int cols, char[][] grid, boolean[][] visited){
        if (r < 0 || r > rows-1 || c < 0 || c > cols-1 || grid[r][c] == '0' || visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        dfs(r+1, c, rows, cols, grid, visited);
        dfs(r-1, c, rows, cols, grid, visited);
        dfs(r, c+1, rows, cols, grid, visited);
        dfs(r, c-1, rows, cols, grid, visited);

    }
}