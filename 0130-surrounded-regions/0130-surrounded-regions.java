class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O' && (i == 0 || i == rows-1 || j == 0 || j == cols-1)){
                    dfs(i,j,rows,cols,board);
                }
            }
        }
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    
    public void dfs(int i, int j, int rows, int cols, char[][] board){
        if(i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != 'O'){
            return;
        }
        
        board[i][j] = 'T';
        
        dfs(i+1,j,rows,cols,board);
        dfs(i-1,j,rows,cols,board);
        dfs(i,j+1,rows,cols,board);
        dfs(i,j-1,rows,cols,board);
    }
}