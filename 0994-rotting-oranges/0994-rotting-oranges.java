class Solution {
    
    public class Pair{
        int x;
        int y;
        
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        Deque<Pair> q = new LinkedList<>();
        int time = 0;
        int fresh = 0;
        
        //Get all fresh oranges and rotten oranges
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                
                if(grid[i][j] == 2){
                    q.addLast(new Pair(i,j));
                }
            }
        }
        
        //bfs begins
        while(!q.isEmpty() && fresh > 0){
            int qsize = q.size();
            for(int i = 0; i < qsize; i++){
                Pair rmv = q.removeFirst();
               
                
                for(int dr = 0; dr < directions.length; dr++){
                    
                    Pair np = new Pair(0,0);
                    np.x = rmv.x + directions[dr][0]; 
                    np.y = rmv.y + directions[dr][1];
                    
                    if(np.x < 0 || np.x == rows || np.y < 0 || np.y == cols || grid[np.x][np.y] != 1){
                        continue;
                    }
                    
                    grid[np.x][np.y]=2;
                    q.addLast(np);
                    fresh--;
                }
                
                
            }
            time++;
        }
        if(fresh == 0){
            return time;
        } else {
            return -1;
        }
    }
}