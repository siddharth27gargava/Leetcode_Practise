class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            
            char cc = s.charAt(i);
            
            if(cc == '(' || cc == '{' || cc == '['){
                st.push(cc);
                continue;
            }
            
            if(st.isEmpty()){
                return false;
            }
            
            char check;
            if(cc == ')'){
                check = st.pop();
                if(check == '[' || check == '{'){
                    return false;
                }
            } else if(cc == '}'){
                check = st.pop();
                if(check == '[' || check == '('){
                    return false;
                }
            } else if(cc == ']'){
                check = st.pop();
                if(check == '{' || check == '('){
                    return false;
                }
            }
        }
        
        return st.isEmpty();
    }
}