class Solution {
    public boolean exist(char[][] board, String word) {
        
        int rows = board.length;
        int cols = board[0].length;
        
        boolean[][] visit = new boolean[rows][cols];
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(word.charAt(0) == board[r][c] && dfs(r,c,0,visit,word,board)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(int r, int c, int idx, boolean[][] visit, String word, char[][] board){
        if(idx == word.length()){
            return true;
        }
        
        //Base case
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || visit[r][c] || word.charAt(idx) != board[r][c]){
            return false;
        }
        
        visit[r][c] = true;
        
        if(dfs(r+1,c,idx+1,visit,word,board)||
        dfs(r-1,c,idx+1,visit,word,board)||
        dfs(r,c+1,idx+1,visit,word,board)||
        dfs(r,c-1,idx+1,visit,word,board)){
            return true;
        }
        
        
        visit[r][c] = false;
        
        return false;
    }
}