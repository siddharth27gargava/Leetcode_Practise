class Solution {
    public int climbStairs(int n) {
        int ans;
        
        ans = climbstairs(0,n,dp);
        
        return ans;
    }
    
    public int[] dp = new int[100];
    
    public int climbstairs(int idx, int n, int[] dp){
        
        if(idx == n){
            return 1;
        }
        
        if(dp[idx] != 0){
            return dp[idx];
        }
        
        if(idx > n){
            return 0;
        }
        
        int ans = climbstairs(idx+1,n,dp) + climbstairs(idx+2,n,dp);
        
        dp[idx] = ans;
        
        return ans;
    }
}