class Solution {
    public int missingNumber(int[] nums) {
        
        int sum_ar = 0;
        int sum_le = 0;
        
        for(int i = 0; i <= nums.length; i++){
           sum_le = sum_le + i; 
        }
        
        for(int i = 0; i < nums.length; i++){
           sum_ar = sum_ar + nums[i]; 
        }
        
        return (sum_le - sum_ar);
    }
}