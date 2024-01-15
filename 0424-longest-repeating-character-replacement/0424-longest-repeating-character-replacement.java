class Solution {

    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int ans = 0;
        int count = 0;
        int maxFreq = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            for (char cc : map.keySet()) {
                maxFreq = Math.max(maxFreq, map.get(cc));
            }

            if ((right - left + 1) - maxFreq > k) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }

            ans = Math.max(ans, (right - left + 1));
            right++;
        }

        return ans;

    }
}