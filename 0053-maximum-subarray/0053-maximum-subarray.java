class Solution {
    public int maxSubArray(int[] nums) {
        int oSum = Integer.MIN_VALUE;
        int cSum = 0;
        
        if(allNegative(nums)){
            return maxNum(nums);
        }
        
        for(int i = 0; i < nums.length; i++){
            cSum += nums[i];
            if(cSum < 0){
                cSum = 0;
            }
            
            if(oSum < cSum){
                oSum = cSum;
            }
        }
        
        return oSum;
    }
    
    public int maxNum(int[] array){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++){
            if(max < array[i]){
                max = array[i];
            }
        }
        
        return max;
    }
    
    public boolean allNegative(int[] arr){
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0){
                return false;
            }
        }
        
        return true;
    }
}