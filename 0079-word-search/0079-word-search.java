class Solution {
    
    boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(word.charAt(0) == board[i][j] && dfs(i,j,0,visited,word,board)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(int i, int j, int idx, boolean[][] visited, String word, char[][] board){
        if(word.length() == idx){
            return true;
        }
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(idx) != board[i][j]){
            return false;
        }
        
        visited[i][j] = true;
        
        if(dfs(i+1,j,idx+1,visited,word,board) ||
          dfs(i-1,j,idx+1,visited,word,board) ||
          dfs(i,j+1,idx+1,visited,word,board) ||
          dfs(i,j-1,idx+1,visited,word,board)){
            return true;
        }
        
        visited[i][j] = false;
        
        return false;
    }
}