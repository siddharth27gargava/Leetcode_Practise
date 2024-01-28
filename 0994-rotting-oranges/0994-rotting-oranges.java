
import java.awt.GridLayout;class Solution {
    public class Pair {
        int r;
        int c;

        public Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public int[][] twod = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int fresh = 0;
        int time = 0;

        Deque<Pair> q = new LinkedList<>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }

                if (grid[i][j] == 2) {
                    q.addLast(new Pair(i,j));
                }
            }
        }

        //bfs starts
        while (!q.isEmpty() && fresh > 0) {
            int qs = q.size();
            for (int i = 0; i < qs; i++) {
                Pair rmv = q.removeFirst();
                //new pair to be formed inside the direction loop
                for (int j = 0; j < twod.length; j++) {
                    Pair np = new Pair(0, 0);
                    np.r = rmv.r + twod[j][0];
                    np.c = rmv.c + twod[j][1];

                    if (np.r < 0 || np.r >= rows || np.c < 0 || np.c >= cols || grid[np.r][np.c] != 1) {
                        continue;
                    }

                    grid[np.r][np.c] = 2;
                    q.addLast(np);
                    fresh--;
                }
            }
            time++;
        }

        if (fresh > 0) {
            return -1;
        }

        return time;
    }
}