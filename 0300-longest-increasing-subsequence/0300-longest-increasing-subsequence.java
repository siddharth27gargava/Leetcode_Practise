class Solution {
    
    public int[][] dp;

    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length + 1][nums.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return rec(nums, 0, -1);
    }
    
    private int rec(int[] nums, int curr, int prevIdx) {
        if (curr == nums.length) {
            return 0;
        }

        if (prevIdx != -1 && dp[prevIdx][curr] != -1) {
            return dp[prevIdx][curr];
        }

        // Exclude current element
        int exc = rec(nums, curr + 1, prevIdx);

        // Include current element
        int inc = 0;
        if (prevIdx == -1 || nums[curr] > nums[prevIdx]) {
            inc = 1 + rec(nums, curr + 1, curr);
        }

        int ans = Math.max(inc, exc);

        if (prevIdx != -1) {
            dp[prevIdx][curr] = ans;
        }

        return ans;
    }
}
