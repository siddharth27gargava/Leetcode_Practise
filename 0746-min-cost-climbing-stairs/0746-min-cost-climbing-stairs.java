class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int one = minCost(0,cost, dp);
        int two = minCost(1,cost, dp);
        
        return Math.min(one,two);
    }
    
    int[] dp = new int[1000];
    
    public int minCost(int idx, int[] cost, int[] dp){
        if(idx >= cost.length){
            return 0;
        }
        
        if(dp[idx] != 0){
            return dp[idx];
        }
        
        int ans = Math.min(minCost(idx + 1,cost,dp),minCost(idx + 2,cost,dp)) + cost[idx];
        
        dp[idx] = ans;
        
        return ans;
    }
}