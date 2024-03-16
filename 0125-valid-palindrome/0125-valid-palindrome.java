class Solution {
    public boolean isPalindrome(String s) {
        String rem = s.trim();
        String remlow = rem.toLowerCase();
        String onlyletters = removeSpecial(remlow);
        //palap
        int left = 0;
        int right = onlyletters.length() - 1;
        while(left <= right){
            if (onlyletters.charAt(left) != onlyletters.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public String removeSpecial(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9') ) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}