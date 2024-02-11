class Solution {

    int[] dp = new int[50];
    public int climbStairs(int n) {
        return recursion(0, n);
    }

    public int recursion(int curr, int n){
        if (curr == n) {
            return 1;
        }

        if (curr > n) {
            return 0;
        }

        if (dp[curr] != 0) {
            return dp[curr];
        }

        int ans = recursion(curr + 1, n) + recursion(curr + 2, n);

        dp[curr] = ans;

        return ans; 
    }
}