class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(right < s.length()){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0) + 1);
            
            for(char cc:map.keySet()){
                if(map.get(cc) > maxFreq){
                    maxFreq = map.get(cc);
                }
            }
            
            if((right - left + 1) - maxFreq > k){
                map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0) - 1);
                left++;
            }
            
            result = Math.max(result, (right - left + 1));
            
            right++;
        }
        
        return result;
    }
}