class Solution {
    
    int[][] dp;
    
    public int maxCoins(int[] nums) {
        int[] numc = new int[nums.length + 2];
        numc[0] = 1;
        numc[numc.length - 1] = 1;
        for(int i = 0; i < nums.length; i++){
            numc[i+1] = nums[i];
        }
        
        dp = new int[numc.length + 1][numc.length + 1];
        
        return dfs(numc,1,numc.length - 2);
    }
    
    public int dfs(int[] numc, int l, int r){
        //Base cases:
        
        //left passed right
        if(l > r){
            return 0;
        }
        
        if(dp[l][r] > 0){
            return dp[l][r];
        }
        
        int ans = 0;
        int coin_immediate_val = 0;
        
        for(int i = l; i <= r; i++){
            coin_immediate_val = numc[l - 1] * numc[i] * numc[r+1];
            coin_immediate_val += dfs(numc,l,i-1) + dfs(numc,i+1,r);
            ans = Math.max(ans,coin_immediate_val);
        }
        
        dp[l][r] = ans;
        return ans;
    }
}