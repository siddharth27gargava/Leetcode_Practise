class Solution {

    public int islandPerimeter(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        // the concept is that first find a box, and then if the box is connected to a neighboring box, that means one edge is gone from the perimeter. If there are two connected box to that box, then two edges are gone and so on and so forth. Also, keep in mind - that this subtraction shouldn't happen if it is on the edge
        int count = 0;

        int up,down,left,right = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // do this only where 1 is there
                if (grid[r][c] == 1) {
                    
                    //checking for topmost
                    //reason why we put <= is because the boundary element on top will not have neighbor above it
                    if (r <= 0) {
                        up = 0;
                    } else {
                        up = grid[r - 1][c];
                    }

                    //checking for leftmost
                    if (c <= 0) {
                        left = 0;
                    } else {
                        left = grid[r][c - 1];
                    }

                    if(r >= rows-1){
                        down = 0;
                    } else {
                        down = grid[r + 1][c];
                    }

                    //checking the rightmost
                    if(c >= cols-1){
                        right = 0;
                    } else {
                        right = grid[r][c + 1];
                    }

                    count += 4 - (up + down + left + right);
                }
                
            }
        }

        return count;
    }


}