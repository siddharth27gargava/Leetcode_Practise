class Solution {
    public int strStr(String haystack, String needle) {
        int left = 0;
        int right = needle.length();

        while (right <= haystack.length()) {
            if (haystack.substring(left, right).equals(needle)) {
                return left;
            }

            left++;
            right++;
        }

        return -1;
    }
}