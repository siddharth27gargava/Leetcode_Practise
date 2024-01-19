class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for(String token : tokens){
            if(token.equals("+")){
                st.push(st.pop() + st.pop());
            } else if(token.equals("-")){
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            } else if(token.equals("*")){
                int a = st.pop();
                int b = st.pop();
                st.push(a *b);
            } else if (token.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                st.push((int)(b/a));
            } else{
                st.push(Integer.parseInt(token));
            }
        }

        return st.pop();
    }
}