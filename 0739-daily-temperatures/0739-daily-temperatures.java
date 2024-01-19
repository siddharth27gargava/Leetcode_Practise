class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int curr_day = 0; curr_day < res.length; curr_day++) {
            //cond for monotonic stack
            while (!stack.isEmpty() && temperatures[curr_day] > temperatures[stack.peek()]) {
                int prev_day = stack.pop();
                res[prev_day] = curr_day - prev_day;
            }

            stack.push(curr_day);
        }

        return res;
    }
}