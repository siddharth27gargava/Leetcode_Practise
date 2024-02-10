class Solution {
    public String longestCommonPrefix(String[] strs) {
        //find smallest word length
        int small_length = Integer.MAX_VALUE;
        String small_str = "";

        for (String string : strs) {
            
            if (string.length() == 0) {
                return "";
            }

            if (string.length() < small_length) {
                small_length = string.length();
                small_str = string;
            }
        }

        //char cc;
        int i = 0;;


        while (i < small_length) {
            
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) != strs[j+1].charAt(i)) {
                    return strs[j].substring(0,i);
                }
            }
            i++;
        }

        return small_str;
    }
}