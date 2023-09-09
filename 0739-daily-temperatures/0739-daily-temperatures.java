class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] output = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        
        st.push(0);
        
        for(int i = 1; i < temperatures.length; i++){
            
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int val = st.pop();
                output[val] = i - val;
            }
            
            st.push(i);
        }
        
        return output;
    }
}