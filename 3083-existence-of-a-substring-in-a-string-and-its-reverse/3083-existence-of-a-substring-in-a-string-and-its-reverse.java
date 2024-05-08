class Solution {
    public boolean isSubstringPresent(String s) {

        int left = 0;
        int right = 2;

        String rev = reverse(s);

        while (right <= s.length()) {
            String sub = s.substring(left, right);
            
            if (isPresent(rev,sub)) {
                return true;
            }

            left++;
            right++;
        }

        return false;
    }

    public boolean isPresent(String str, String sub){
        int left = 0;
        int right = 2;
        while(right <= str.length()){
            if (str.substring(left, right).equals(sub)) {
                return true;
            }
            left++;
            right++;
        }

        return false;
    }

    public String reverse(String str){
        StringBuilder sb = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }
}