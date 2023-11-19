class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        
        if(s.length() > 12){
            return res;
        }
        
        backtrack(0,s,res,"",0);
        
        return res;
    }
    
    public void backtrack(int idx, String s, List<String> res, String currIP, int dots){
        //Base case-1
        if(dots == 4 && idx == s.length()){
            res.add(currIP.substring(0,currIP.length() - 1));
            return;
        }
        
        //Base case-2
        if(dots > 4){
            return;
        }
        
        //Main work
        for(int j = idx; j < Math.min(s.length(),idx + 3); j++){
            if(Integer.parseInt(s.substring(idx,j+1)) < 256 && (j == idx || !s.substring(idx,idx+1).equals("0")) ){
                backtrack(j+1,s,res,currIP + s.substring(idx,j+1) + ".",dots+1);
            }
        }
        
    }
}