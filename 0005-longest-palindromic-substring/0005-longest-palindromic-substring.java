class Solution {
    public String longestPalindrome(String s) {
        
        String ans = "";
        int maxl = ans.length();
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i,j))) {
                    if (s.substring(i, j).length() > maxl) {
                        maxl = s.substring(i, j).length();
                        ans = s.substring(i, j);
                    }
                }
            }
        }

        return ans;
    }

    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;

        //do this because we also want to check the edge case of that mid element
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}