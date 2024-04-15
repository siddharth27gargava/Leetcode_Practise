class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        //board reversal
        reverseBoard(board);

        boolean[] visited = new boolean[n * n+1];
        
        //2d with 2 col value (0th position and 1st position)
        Deque<int[]> q = new LinkedList<>();
        q.addLast(new int[]{1,0});
        visited[1] = true;

        //bfs starts
        while(!q.isEmpty()){
            int[] curr = q.removeFirst();
            for(int j = 1; j <= 6; j++){
                
                //traverse to that element
                int next = curr[0] + j;

                //get the coordinate value
                int[] coor = sqtoCoor(next, n);

                //if the coordinate is not -1, then travel to that position
                if(board[coor[0]][coor[1]] != -1){
                    next = board[coor[0]][coor[1]];
                }
                //
                if(next == n*n){
                    return curr[1] + 1;
                }

                if(!visited[next]){
                    visited[next] = true;
                    q.addLast(new int[]{next, curr[1] + 1});
                }
            }
        }

        return -1;
    }

    public void reverseBoard(int[][] board){
        int l = 0;
        int r = board.length - 1;
        while(l < r){
            int[] temp = board[l];
            board[l] = board[r];
            board[r] = temp;

            l++;
            r--;
        } 
    }

    public int[] sqtoCoor(int square, int n){
        int row = (square-1)/n;
        int col = (square-1)%n;

        if(row % 2 != 0){
            col = n - 1 - col;
        }

        return new int[]{row,col};
    }
}