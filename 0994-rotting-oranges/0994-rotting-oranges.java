class Solution {
    
    public class Pair{
        int r;
        int c;
        
        public Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    public final int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int orangesRotting(int[][] grid) {
        //Identified with BFS
        //1. Pair
        //Done
        
        //create q;
        
        Deque<Pair> q = new LinkedList<>();
        int time = 0;
        int fresh = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        //get all fresh orange count
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 1){
                    fresh++;
                }
                
                if(grid[r][c] == 2){
                    q.addLast(new Pair(r,c));
                }
            }
        }
        
        //get all rotten oranges in pair
        //Done
        
        while(!q.isEmpty() && fresh > 0){
            int qs = q.size();
            for(int i = 0; i < qs; i++){
                Pair rmv = q.removeFirst();
                
                for(int j = 0; j < directions.length; j++){
                    Pair np = new Pair(0,0);
                    np.r = rmv.r + directions[j][0];
                    np.c = rmv.c + directions[j][1];
                    
                    if(np.r < 0 || np.r >= rows || np.c < 0 || np.c >= cols || grid[np.r][np.c] != 1){
                        continue;
                    }
                    
                    grid[np.r][np.c] = 2;
                    q.addLast(np);
                    fresh--;
                }
            }
            time++;
        }
        
        if(fresh>0){
            return -1;
        } else {
            return time;
        }
        
        //BFS--
        //go through each first pair--
        //add it to your array--
        //check if it's not fresh or in limit, then continue
        //otherwise - add that in q and fresh--;
        //add time for each loop
        //return time
        
    }
}