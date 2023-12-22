class Solution {
    
    public int[] dp = new int[100];
    
    public int climbStairs(int n) {
        //do it with recursion
        if(n == 0){
            return 0;
        }
        
        if(n == 1){
            return 1;
        }
        
        return rec(0,n);
        
    }
    
    public int rec(int curr, int n){
        if(curr > n){
            return 0;
        }
        
        if(dp[curr] != 0){
            return dp[curr];
        }
        
        if(curr == n){
            return 1;
        }
        
        int ans = rec(curr + 1, n) + rec(curr + 2,n);
        
        dp[curr] = ans;
        
        return ans;
    }
}