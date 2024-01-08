class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //make a min-heap and max-heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        ArrayList<Integer> res = new ArrayList<>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : map.keySet()){
            pq.add(num);

            while (pq.size() > k) {//when doing while it should be opposite of what you do for if
                pq.poll();
            }
        }

        while(!pq.isEmpty()){
            res.add(pq.poll());
        }

        int[] ans = new int[k];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}