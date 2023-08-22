class Solution {
    public boolean isPalindrome(String s) {
        String ls = s.toLowerCase();
        String qs = remove(ls);
        
        int left = 0;
        int right = qs.length() - 1;
        while(left <= right){
            if(qs.charAt(left) != qs.charAt(right)){
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    public String remove(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i)>='0'&&s.charAt(i)<='9')){
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}