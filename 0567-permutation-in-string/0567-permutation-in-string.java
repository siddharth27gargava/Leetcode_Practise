class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> s1map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1map.put(s1.charAt(i), s1map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int right = s1.length()-1;
        int left = 0;

        while (right < s2.length()) {
            HashMap<Character,Integer> s2map = new HashMap<>();
            for (int i = left; i <= right; i++) {
                s2map.put(s2.charAt(i), s2map.getOrDefault(s2.charAt(i), 0) + 1);
            }

            if (s1map.equals(s2map)) {
                return true;
            }

            left++;
            right++;
        }

        return false;
    }
}