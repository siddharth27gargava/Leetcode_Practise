class Solution {
    
    boolean[][] visited;
    
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int max = 0;
        
        visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                max = Math.max(max,dfs(i,j,rows,cols,grid,visited));
            }
        }
        
        return max;
    }
    
    public int dfs(int i, int j, int rows, int cols, int[][] grid, boolean[][] visited){
        if(i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j] == true || grid[i][j] == 0){
            return 0;
        }
        
        visited[i][j] = true;
        
        return( 1 + (dfs(i+1,j,rows,cols,grid,visited) +
                dfs(i-1,j,rows,cols,grid,visited) +
                dfs(i,j+1,rows,cols,grid,visited) +
               dfs(i,j-1,rows,cols,grid,visited))
              );
    }
}