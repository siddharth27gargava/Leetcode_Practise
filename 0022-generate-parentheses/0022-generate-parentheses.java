class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        
        backtrack(list,"",0,0,n);
        return list;
    }
    
    public void backtrack(ArrayList<String> output, String current, int open, int close, int max){
        if(current.length() == 2*max){
            output.add(current);
            return;
        }
        
        
        if(open < max){
            backtrack(output,current+"(",open+1,close,max);
        }
        
        if(close < open){
            backtrack(output,current+")",open,close+1,max);
        }
    }
}