class Solution {

    int[][] dp;

    public int lengthOfLIS(int[] nums) {
        
        dp = new int[nums.length+1][nums.length+1];

        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return recursion(nums, 0, -1);   
    }

    public int recursion(int[] nums, int curr, int prev){
        if (curr == nums.length) {
            return 0;
        }

        int prevCheck = prev + 1;
        if (dp[curr][prevCheck] != -1) {
            return dp[curr][prevCheck];
        }

        int excl = recursion(nums, curr+1, prev);
        int incl =0;
        if (prev == -1 || nums[curr] > nums[prev]) {
            incl = 1 + recursion(nums, curr+1, curr);
        }

        int ans = Math.max(excl, incl);
        dp[curr][prevCheck] = ans;

        return ans;
    }
}