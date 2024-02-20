class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return recursion(text1, text2, 0, 0, dp);
    }

    public int recursion(String text1, String text2, int i, int j, int[][] dp){
        if(i == text1.length() || j == text2.length()){
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        char ch1 = text1.charAt(i);
        char ch2 = text2.charAt(j);

        int ans = 0;

        if (ch1 == ch2) {
            ans = 1 + recursion(text1, text2, i+1, j+1, dp);
            dp[i][j] = ans;
            
        } else{
            int o1 = recursion(text1, text2, i+1, j, dp);
            int o2 = recursion(text1, text2, i, j+1, dp);

            ans = Math.max(o1, o2);
            dp[i][j] = ans;
        }

        return ans;
        
    }
}