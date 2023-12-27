class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return rec(nums,target,0,0);
    }
    
    public int rec(int[] nums, int target, int curr, int sum){
        
        //BC
        
        if(curr == nums.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }
        
        //int excl = rec(nums, target, curr + 1, sum);
        int ps = rec(nums, target, curr + 1, sum + nums[curr]);
        int ng = rec(nums, target, curr + 1, sum - nums[curr]);
        
        return ps + ng;
    }
}