class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        
        generate(0,s,res,new ArrayList());
        
        return res;
    }
    
    public void generate(int idx, String s, List<List<String>> res, List<String> subs){
        if(idx >= s.length()){
            res.add(new ArrayList(subs));
            return;
        }
        
        for(int j = idx; j < s.length(); j++){
            if(isPalindrome(s,idx,j)){
                subs.add(s.substring(idx,j+1));
                generate(j+1,s,res,subs);
                subs.remove(subs.size() - 1);
            }
        }
        
        
    }
    
    public boolean isPalindrome(String s, int i, int j){
        String ls = s.toLowerCase();
        int start = i;
        int end = j;
        while(start < end){
            if(ls.charAt(start) != ls.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}