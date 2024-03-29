class Solution {

    HashMap<String, Boolean> dp = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        
         
        if(wordDict.contains(s)){
            return true;
        }

        if (dp.containsKey(s)) {
            return dp.get(s);
        }

        for (int i = 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(0,i)) && wordBreak(s.substring(i), wordDict)) {
                dp.put(s, true);
                return true;
            }
        }

        dp.put(s, false);
        return false;
    }
}