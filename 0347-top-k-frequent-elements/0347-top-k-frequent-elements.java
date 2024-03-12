class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //1. HashMap - put all numbers
        //Pq -> frequencies
        //add all the values in the pq and 
        HashMap<Integer, Integer> fmap = new HashMap<>();

        for(int num : nums){
            fmap.put(num, fmap.getOrDefault(num,0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> fmap.get(b) - fmap.get(a));

        Set<Integer> keys = fmap.keySet();

        for(int key : keys){
            pq.add(key);
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;

    }
}