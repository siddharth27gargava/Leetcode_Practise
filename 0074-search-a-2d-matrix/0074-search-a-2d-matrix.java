class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int hi = (matrix.length)*(matrix[0].length) - 1;
        int lo = 0;
        int pivot_Idx = 0;
        int pivot_element = 0;
        int n = matrix[0].length;
        while(hi >= lo){
            pivot_Idx = (hi+lo)/2;
            pivot_element = matrix[pivot_Idx / n][pivot_Idx % n];
            
            if(pivot_element == target){
                return true;
            } else {
                if(target < pivot_element){
                    hi = pivot_Idx - 1;
                } else {
                    lo = pivot_Idx + 1; 
                }
            }
        }
        
        return false;
    }
}