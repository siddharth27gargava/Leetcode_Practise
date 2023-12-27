class Solution {
    
    int[][] dp;
    
    public int longestIncreasingPath(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        dp = new int[rows + 1][cols + 1];
        
        int ans = 0;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                ans = Math.max(ans,rec(matrix,rows,cols,i,j,-1));
            }
        }
        
        return ans;
    }
    
    public int rec(int[][] matrix, int rows, int cols, int r, int c, int prev){//pass in prev so that it's in increasing order
        
        //Base Case
        if(r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] <= prev){
            return 0;
        }
        
        //DP
        if(dp[r][c] > 0){
            return dp[r][c]; 
        }
        
        int res = 1;
        
        res = Math.max(res, rec(matrix,rows,cols,r+1,c,matrix[r][c]) + 1);
        res = Math.max(res, rec(matrix,rows,cols,r-1,c,matrix[r][c]) + 1);
        res = Math.max(res, rec(matrix,rows,cols,r,c+1,matrix[r][c]) + 1);
        res = Math.max(res, rec(matrix,rows,cols,r,c-1,matrix[r][c]) + 1);
        
        dp[r][c] = res;
        
        return res;
        
    }
}