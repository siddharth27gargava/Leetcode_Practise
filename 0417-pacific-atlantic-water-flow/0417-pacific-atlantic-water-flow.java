class Solution {
    public class Pair{
        int r;
        int c;
        
        public Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //visited set required
        
        List<List<Integer>> res = new ArrayList<>();
        
        int rows = heights.length;
        int cols = heights[0].length;
        
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];
        
        //For the first and last row connected to pac & atl where col values change 
        for(int c = 0; c < cols; c++){
            //
            dfs(0,c,pac, heights[0][c],heights); //heights[r][c] indicates prev. height giving r & c since rt now we're at the edge with no prev height 
            dfs(rows-1,c,atl,heights[rows-1][c],heights);
        }
        
        for (int r = 0; r < rows; r++){
            dfs(r,0,pac,heights[r][0],heights);
            dfs(r,cols-1,atl,heights[r][cols-1],heights);
        }
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                //Pair rc = new Pair(r,c);
                if(pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        
        return res;
    }
    
    public void dfs(int r, int c, boolean[][] visit, int prevHeight, int[][] heights){
        
        //Pair rc = new Pair(r,c);
        
        //Base-Case: pair already in visit or curr heights less than prev heights or inner/outer bounds
        if(r < 0 || c < 0|| r >= heights.length || c >= heights[0].length || visit[r][c] || heights[r][c] < prevHeight){
            return;
        }
        
        visit[r][c] = true;
        
        dfs(r+1,c,visit,heights[r][c],heights);
        dfs(r-1,c,visit,heights[r][c],heights);
        dfs(r,c+1,visit,heights[r][c],heights);
        dfs(r,c-1,visit,heights[r][c],heights);
        
    }
}