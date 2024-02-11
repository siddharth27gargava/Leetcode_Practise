class Solution {

    int[] dp;
    public int rob(int[] nums) {

        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        int zero = recursion(0, nums);
        int one = recursion(1, nums);

        return Math.max(zero, one);
    }

    public int recursion(int curr, int[] nums){
        if (curr >= nums.length) {
            return 0;
        }

        if (dp[curr] != -1) {
            return dp[curr];
        }
        //skip the current one
        int choiceone = recursion(curr + 1, nums);

        //loot the current one and jump beyond
        int choicetwo = recursion(curr + 2, nums) + nums[curr];

        int max_ans = Math.max(choiceone, choicetwo);

        dp[curr] = max_ans;

        return max_ans;

    }
}