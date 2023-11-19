class Solution {
    public int missingElement(int[] nums, int k) {
        //Find if the number is in gap
        
        for(int i = 1; i < nums.length; i++){
            //define gap
            int gap = nums[i] - nums[i-1] - 1;
            
            if(gap < k){
                k = k - gap;
            } else {
                return nums[i-1] + k;
            }
        }
        
        return nums[nums.length - 1] + k;
    }
}