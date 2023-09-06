class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = s1.length();
        
        HashMap<Character,Integer> maps1 = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
                maps1.put(s1.charAt(i),maps1.getOrDefault(s1.charAt(i),0) + 1);
        }
        
        while(right <= s2.length()){
            
            HashMap<Character,Integer> maps2 = new HashMap<>();
            
            for(int i = left; i < right; i++){
                maps2.put(s2.charAt(i),maps2.getOrDefault(s2.charAt(i),0) + 1);
            }
            
            if(maps1.equals(maps2)){
                return true;
            }
            
            right++;
            left++;
        }
        
        return false;
    }
    
}