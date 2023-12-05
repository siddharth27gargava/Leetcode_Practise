class Solution {
    public void solve(char[][] board) {
        
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        //find 'O' in border region
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(board[r][c] == 'O' && (r == 0 || r == rows - 1 || c == 0 || c == cols-1)){
                    dfs(board,r,c);
                }
            }
        }
        
        //run dfs in 'O' of that region and convert other found 'O's to 'T's
        //DONE in DFS
        

        //convert 'O's to 'X's
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
            }
        }
        
        //convert 'T's to 'O's
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(board[r][c] == 'T'){
                    board[r][c] = 'O';
                }
            }
        }
        
        
    }
    
    public void dfs(char[][] board, int r, int c){
        //Base-Case
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O'){
            return;
        }
        
        board[r][c] = 'T';
        
        dfs(board,r+1,c);
        dfs(board,r-1,c);
        dfs(board,r,c+1);
        dfs(board,r,c-1);
    }
}