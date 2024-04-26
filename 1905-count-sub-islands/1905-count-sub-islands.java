class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows2 = grid1.length;
        int cols2 = grid1[0].length;

        int ans = 0;

        for (int row = 0; row < rows2; row++) {
            for (int col = 0; col < cols2; col++) {
                if (grid2[row][col] == 1) {
                    boolean call = dfs(grid1, grid2, row, col, rows2, cols2);
                    if (call) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    public boolean dfs(int[][] grid1, int[][] grid2, int r, int c, int rows, int cols){
        //base case
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid2[r][c] == 0) {
            return true;
        }

        if (grid2[r][c] == 1 && grid1[r][c] == 0) {
            return false;
        }

        grid2[r][c] = 0;

        boolean c1 = dfs(grid1, grid2, r+1, c, rows, cols);
        boolean c2 = dfs(grid1, grid2, r-1, c, rows, cols);
        boolean c3 = dfs(grid1, grid2, r, c+1, rows, cols);
        boolean c4 = dfs(grid1, grid2, r, c-1, rows, cols);
        
        return c1 && c2 && c3 && c4;
    }

}