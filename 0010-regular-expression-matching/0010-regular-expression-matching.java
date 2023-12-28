class Solution {
    public boolean isMatch(String s, String p) {
        return dfs(s,p,0,0);
    }
    
    public boolean dfs(String s, String p, int i, int j){
        
        //Base Cases
        if(i >= s.length() && j >= p.length()){
            return true;
        }
        
        if(j >= p.length()){
            return false;
        }
        
        boolean match = false;
        
        if( i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')){
            match = true;
        }
        
        if(j+1 < p.length() && (p.charAt(j+1) == '*')){
            //don't use the star OR use the start
            return dfs(s,p,i,j+2) || (match && dfs(s,p,i+1,j));
        }
        
        if(match){
            return dfs(s,p,i+1,j+1);
        }
        
        return false;
    }
}