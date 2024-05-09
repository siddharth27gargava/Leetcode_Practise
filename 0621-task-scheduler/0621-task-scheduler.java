class Solution {
    public int leastInterval(char[] tasks, int n) {
        //thought process is to first fit the max occurring tasks and then the remaining one
        HashMap<Character, Integer> fmap = new HashMap<>();
        //Approach
        //1. after figuring out max tasks, and finding idle slots - by (x - 1)*(n+1)
        //2. deterrmining the number of max frequency tasks - they can all be placed in the final unit of the 
        //cooldown period of the max frequency task without violating the cooldown requirement
        //3. calc total time : Max of either the total idle time OR total task list length

        for(char cc : tasks){
            fmap.put(cc, fmap.getOrDefault(cc, 0) + 1);
        }

        int maxFreq = 0;
        char maxElement;

        for(Map.Entry<Character, Integer> entry: fmap.entrySet()){
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                maxElement = entry.getKey();
            }
        }

        int idle_time = (maxFreq - 1) * (n + 1);

        int count_of_max_elements = 0;

        for(char cc : fmap.keySet()){
            if (fmap.get(cc) == maxFreq) {
                count_of_max_elements++;
            }
        }

        int ans = Math.max(idle_time + count_of_max_elements, tasks.length);

        return ans;
    }
}