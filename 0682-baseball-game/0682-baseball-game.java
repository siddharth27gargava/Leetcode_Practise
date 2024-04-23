class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for(String str: operations){

            if (str.equals("+")) {
                int first = st.pop();
                int second = st.pop();
                st.push(second);
                st.push(first);
                st.push(first + second);
            } else if (str.equals("D")) {
                int initial = st.pop();
                int newval = 2 * initial;
                st.push(initial);
                st.push(newval);
            } else if (str.equals("C")) {
                st.pop();
            }else{
                st.push(Integer.parseInt(str));
            }
        }
        int sum = 0;
        while (!st.isEmpty()) {
            sum = sum + st.pop();
        }

        return sum;
    }
}