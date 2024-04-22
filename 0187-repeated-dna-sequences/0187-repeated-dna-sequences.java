class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        //store all the 10 letter subseq in set

        HashMap<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        int left = 0;
        int right = left + 10;

        while(right<=s.length()){
            String storestr = s.substring(left, right);
            map.put(storestr, map.getOrDefault(storestr, 0) + 1);
            left++;
            right++;
        }

        for(String val : map.keySet()){
            if(map.get(val) > 1){
                res.add(val);
            }
        }

        return res;
    }
}