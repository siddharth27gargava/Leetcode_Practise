class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        // int k = 0;
        StringBuilder sb = new StringBuilder();

        while (i < word1.length() && j < word2.length()) {
            char cci = word1.charAt(i);
            sb.append(cci);
            i++;

            char ccj = word2.charAt(j);
            sb.append(ccj);
            j++;
        }

        if (i == word1.length()) {
            while (j < word2.length()) {
                char ccj = word2.charAt(j);
                sb.append(ccj);
                j++;
            }
        }

        if (j == word2.length()) {
            while (i < word1.length()) {
                char cci = word1.charAt(i);
                sb.append(cci);
                i++;
            }
        }

        return sb.toString();
    }
}