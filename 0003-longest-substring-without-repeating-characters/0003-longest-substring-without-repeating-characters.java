class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() < 1){
            return 0;
        }
        
        //2 pointers 
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        
        HashSet<Character> set = new HashSet<>();
        
        while(right < s.length()){
            
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                max = Math.max(max,set.size());
            } else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        
        return max;
    }
}