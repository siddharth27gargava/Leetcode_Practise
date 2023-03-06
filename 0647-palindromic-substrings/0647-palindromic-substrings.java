class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        
        for(int i = 0; i < s.length(); i++){
            int left = i;
            int right = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            }
            
            left = i;
            right = i+1;
            
             while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            }
        }
        
        return count;
    }
    
    
    public boolean isPalindrome(String s, int i, int j){
        if(s.length() == 0){
            return false;
        }
        
        String ls = s.toLowerCase();
        
        int left = i;
        int right = j;
        
        while(left < right){
            if(ls.charAt(left) != ls.charAt(right)){
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}