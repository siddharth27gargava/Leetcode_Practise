class Solution {
    public String longestPalindrome(String s) {
        
        String longest = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j <= s.length(); j++){
                if(isPalindrome(s.substring(i,j))){
                    String nstr = s.substring(i,j);
                    
                    if(nstr.length() > longest.length()){
                        longest = nstr;
                    }
                }
            }
        }
        
        return longest;
    }
    
    public boolean isPalindrome(String word){
        int left = 0;
        int rt = word.length() - 1;
        
        while(left < rt){
            if(word.charAt(left) != word.charAt(rt)){
                return false;
            }
            
            left++;
            rt--;
        }
        
        return true;
    }
}