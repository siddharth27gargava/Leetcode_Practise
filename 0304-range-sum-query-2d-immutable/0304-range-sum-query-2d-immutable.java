class NumMatrix {
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int starting_row = row1;
        int ending_row = row2;
        int starting_col = col1;
        int ending_col = col2;
        int sum = 0;

        for (int row = starting_row; row <= ending_row; row++) {
            for (int col = starting_col; col <= ending_col; col++) {
                sum = sum + this.matrix[row][col];
            }
        }

        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */