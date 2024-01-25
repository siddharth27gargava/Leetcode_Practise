class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (map.get(a) - map.get(b)));

        for (int num : map.keySet()) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
            
        }

        int[] ans = new int[pq.size()];

        ArrayList<Integer> res = new ArrayList<>();

        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }

        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}