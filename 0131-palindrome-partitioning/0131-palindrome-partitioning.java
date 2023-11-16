class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        
        dfs(0,s,res,new ArrayList<>());
        
        return res;
    }
    
    public void dfs(int idx, String s, List<List<String>> res, List<String> curr){
        //Base Case
        if(idx == s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int j = idx; j < s.length(); j++){
            if(isPalindrome(s,idx,j)){
                curr.add(s.substring(idx,j+1));
                //after figuring out that curr is currently a palindrome, check if there are other palindromes by incrementing the dfs and then clean it up
                dfs(j+1,s,res,curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            
            l++;
            r--;
        }
        
        return true;
    }
}