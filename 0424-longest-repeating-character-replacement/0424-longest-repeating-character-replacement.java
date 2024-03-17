class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int max = 0;
        int maxFreq = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            //just the keys
            Set<Character> keys = map.keySet();

            // //just the values
            // Collection<Integer> values = map.values();

            // //key and values
            // Set<Map.Entry<Character, Integer>> entries = map.entrySet();

            for(char cc : keys){
                if (map.get(cc) > maxFreq) {
                    maxFreq = map.get(cc);
                }
            }

            if ((right - left + 1) - maxFreq > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}