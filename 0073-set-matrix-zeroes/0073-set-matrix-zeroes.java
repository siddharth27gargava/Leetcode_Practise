class Solution {
    public void setZeroes(int[][] matrix) {
        //concept:you'll have to create boolean matrix and set the values to true
        //check even if one of them is true, then make those values zero

        boolean[] zeroR = new boolean[matrix.length];
        boolean[] zeroC = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroR[i] = true;
                    zeroC[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (zeroR[i] || zeroC[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
         
    }
}