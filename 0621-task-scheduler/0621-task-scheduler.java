class Solution {
    public int leastInterval(char[] tasks, int n) {
         //create a char map
        int[] char_map = new int[26];

        for (char c : tasks){
            char_map[c - 'A']++;
        }

        Arrays.sort(char_map);
        int max_value = char_map[25] - 1;
        int idle_slots = max_value * n;

        for (int i = 24; i >= 0 ; i--) {
            idle_slots -= Math.min(max_value,char_map[i]);
            //we do math.min with max_value because if there is similar frequency
            //of another char, then idle slot will be filled only till max_val and that
            //task will come after max_value
        }

        if (idle_slots > 0){
            return idle_slots + tasks.length;
        }
        
        return tasks.length;
    }
}