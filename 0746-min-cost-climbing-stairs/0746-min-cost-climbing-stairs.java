class Solution {
    
    int[] dp = new int[1000];
    
    public int minCostClimbingStairs(int[] cost) {
        int zero = rec(cost,0);
        int one = rec(cost,1);
        
        return Math.min(zero,one);
    }
    
    public int rec(int[] cost, int curr){
        
        int n = cost.length;
        
        //Base Case
        if(curr >= n){
            return 0;
        }
        
        if(dp[curr] != 0){
            return dp[curr];
        }
        
        int min = Math.min(rec(cost,curr+1),rec(cost,curr+2)) + cost[curr];
        
        dp[curr] = min;
        
        return min;
    }
}