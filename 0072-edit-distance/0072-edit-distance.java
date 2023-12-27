class Solution {
    
    public int[][] dp;
    
    public int minDistance(String word1, String word2) {
        
        dp = new int[word1.length() + 1][word2.length() + 1];
        
        //changes to only happen to word1
        //If chars are same, then we move on without considering them
        return rec(word1,word2,0,0);
    }
    
    public int rec(String word1, String word2, int i, int j){
        
        //Base Cases : if word2 is empty, remove all letters one by oen from word1
        if(word2.length() == j){
            return word1.length() - i;
        }
        
        //Base Cases : if word1 is empty, add all letters one by oen from word1
        if(word1.length() == i){
            return word2.length() - j;
        }
        
        if(dp[i][j] > 0){
            return dp[i][j];
        }
        
        char ch1 = word1.charAt(i);
        char ch2 = word2.charAt(j);
        
        int ans = 0;
        
        if(ch1 == ch2){
            ans = rec(word1,word2,i+1,j+1);
            
        } else {
            int insert = 1 + rec(word1,word2,i,j+1); //because, we're inserting char in word1 so i is same, but j can be incremented since new char cancels out j, and so j moves on
            int delete = 1 + rec(word1,word2,i+1,j); //because we deleted char from word1, which means ignored the current value of i and moved since the ignored value is considered deleted. However j stays the same since it hasn't be crossed out yet
            int replace = 1 + rec(word1,word2,i+1,j+1);//once we replace, then the two chars match and we strike both of them and move on for both pointers
            
            ans = Math.min(insert, Math.min(delete,replace));
        }
        
        dp[i][j] = ans;
        return ans;
    }
}