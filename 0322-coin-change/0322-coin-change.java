class Solution {

    int[][] dp;
    public int coinChange(int[] coins, int amount) {

        dp = new int[coins.length][amount + 1];
        
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        int ans = recursion(coins, 0, amount);

        if (ans == Integer.MAX_VALUE) {
            return -1;
        }

        return ans;
    }

    public int recursion(int[] coins, int curr, int amount){

        if(amount < 0){
            return Integer.MAX_VALUE;
        }

        if(amount == 0){
            return 0;
        }

        if(curr == coins.length){
            return Integer.MAX_VALUE;
        }

        if (dp[curr][amount] != -1) {
            return dp[curr][amount];
        }

        //exclude
        int exclsum = recursion(coins, curr + 1, amount);
        int count = Integer.MAX_VALUE;
        int inclsum = 0;
        //include
        //include only if the amount is greater than 0;
        if (amount >= coins[curr]) {
            inclsum = recursion(coins, curr, amount - coins[curr]);

            if (inclsum != Integer.MAX_VALUE) {
                count = inclsum + 1;
            }
        }

        int ans = Math.min(exclsum, count);

        dp[curr][amount] = ans;

        return ans;
    }
}