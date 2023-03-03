class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(i,j,rows,cols,grid);
                }
            }
        }
        return count;
    }
    
    public void dfs(int i, int j, int row, int col, char[][] grid){
        if(i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0'){
            return;
        }
        
        grid[i][j] = '0';
        
        dfs(i+1,j,row,col,grid);
        dfs(i-1,j,row,col,grid);
        dfs(i,j+1,row,col,grid);
        dfs(i,j-1,row,col,grid);
    }
}