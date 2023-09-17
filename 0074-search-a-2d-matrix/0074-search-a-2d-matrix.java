class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = (matrix.length) * (matrix[0].length) - 1;
        
        int pivot_idx = 0;
        int pivot_el = 0;
        int n = matrix[0].length;
        
        while(left <= right){
            pivot_idx = (left + right)/2;
            pivot_el = matrix[pivot_idx/n][pivot_idx%n];
            
            if(pivot_el == target){
                return true;
            } else {
                if(target < pivot_el){
                    right = pivot_idx - 1;
                } else {
                    left = pivot_idx + 1;
                }
            }
        }
        
        return false;
    }
}