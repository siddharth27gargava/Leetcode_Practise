class Solution {
    public int maxSubArray(int[] nums) {
        
        if(allNegative(nums)){
            return maxNum(nums);
        }
        
        int csum = 0;
        int obsum = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            csum += nums[i];
            
            if(csum < 0){
                csum = 0;
            }
            
            if(obsum < csum){
                obsum = csum;
            }
        }
        
        return obsum;
    }
    
    public int maxNum(int[] arr){
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
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