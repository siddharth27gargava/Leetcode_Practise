class Solution {
    
    public int findTargetSumWays(int[] nums, int target) {

        return recursion(nums, target, 0, 0);
    }

    public int recursion(int[] nums, int target, int curr, int sum){
        if (curr == nums.length) {
            if (sum == target) {
                return 1;
            }

            return 0;
        }


        int positive = recursion(nums, target, curr + 1, sum + nums[curr]);
        int negative = recursion(nums, target, curr + 1, sum - nums[curr]);

        int ans = positive + negative;

        return ans;

    }
}