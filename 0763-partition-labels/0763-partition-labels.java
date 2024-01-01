class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> lastidx = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            lastidx.put(ch,i);//setting the last idx of the character
        }
        //initialise variables
        List<Integer> res = new ArrayList<>();
        int size = 0;
        int end = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            size++;
            
            end = Math.max(end,lastidx.get(ch));
            
            if(i == end){
                res.add(size);
                size = 0;
            }
        }
        
        return res;
    }
}