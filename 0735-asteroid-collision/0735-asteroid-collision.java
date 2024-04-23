class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int idx = 0;

        while(idx < asteroids.length){
            int a = asteroids[idx];
            //add if st is empty
            if (st.isEmpty()) {
                st.push(a);
                idx++;
            //compare peek and a values
            } else {
                //check if opposite values
                //check if strength is different
                if(st.peek() > 0 && a < 0 ){
                    if (Math.abs(st.peek()) > Math.abs(a)) {
                        idx++;
                    } else if(Math.abs(st.peek()) < Math.abs(a)){
                        st.pop();
                    } else {
                        st.pop();
                        idx++;
                    }
                } else {
                    st.push(a);
                    idx++;
                }
            }
        }

        int[] res = new int[st.size()];

        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }

        return res;
    }
}