class Solution {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int rows = grid.length;
        int cols = grid[0].length;

        //Build prefix sum with the formula
        int[][] prefixsum = new int[rows+1][cols+1];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                prefixsum[r+1][c+1] = prefixsum[r+1][c] + prefixsum[r][c+1] - prefixsum[r][c] + grid[r][c];
            }
        }

        //diff to apply range updated(stamping)
        int[][] diff = new int[rows+1][cols+1];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                //update the difference array if we can successfully fit in a stamp with all constraints
                if (grid[r][c] == 0) {
                    int eRow = r + stampHeight;
                    int eCol = c + stampWidth;
                    if (eRow <= rows && eCol <= cols &&
                    //this is reqd to check if there are no 1s in the covering stamp area
                    prefixsum[eRow][eCol] - prefixsum[eRow][c] - prefixsum[r][eCol] + prefixsum[r][c] == 0 ) {
                        //start of the stamp
                        diff[r][c]++;
                        //end of stamp vertically
                        diff[eRow][c]--;
                        //end of stamp horizontally
                        diff[r][eCol]--;
                        //overlap adjustment
                        diff[eRow][eCol]++;
                    }
                }
            }
        }

        int[][] coverCount = new int[rows + 1][cols + 1];
        //running sum to apply the diff array updates to the grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                coverCount[r+1][c+1] = coverCount[r+1][c] + coverCount[r][c+1] - coverCount[r][c] + diff[r][c];
                //grid cell is 0 and yet we can't cover it with stamp
                if (grid[r][c] == 0 && coverCount[r+1][c+1] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}