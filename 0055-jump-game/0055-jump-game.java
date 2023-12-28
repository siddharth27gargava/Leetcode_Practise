class Solution {
    public boolean canJump(int[] nums) {
        //goal where we want to reach
        int goal = nums[nums.length - 1];
        for(int i = nums.length - 1; i >= 0; i--){
            
            //check at every instance if we can reach goal from i, then bring goal closer
            if(i + nums[i] >= goal){
                goal = i;
            }
        }
        
        if(goal > 0){
            return false;
        }
        
        return true;
    }
}