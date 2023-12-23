class Solution {
    
    int[] dp = new int[101];
    
    public int numDecodings(String s) {
        return rec(s,0,dp);
    }
    
    public int rec(String s, int curr, int[] dp){
        
        //Base cases:
        //size > 2
        //size = 2 and count >= 27 -> 0
        // size <= 2 and count < 27 -> 1
        //size = 1 and count > 0 -> 1
        
        if(curr == s.length()){
            return 1;
        }
        
        if(s.charAt(curr) == '0'){
            return 0;
        }
        
        if(dp[curr] > 0){
            return dp[curr];
        }
        
        int count = rec(s,curr + 1,dp);
        
        if(curr < s.length() - 1 && (s.charAt(curr) == '1' || (s.charAt(curr) == '2' && s.charAt(curr+1) <= '6'))){
            count += rec(s,curr + 2,dp);
        }
        
        dp[curr] = count;
        
        return count;
    }
    
//     public int getNum(String s){
//         int sum = 0;
//         for(int i = 0; i < s.length(); i++){
//             int val = s.charAt(i) - 'a' + 1;
//             sum = (sum*10) + val; 
//         }
        
//         return sum;
//     }
}