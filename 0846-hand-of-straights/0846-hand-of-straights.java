class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        //think of it as - pq which stores the lowest values ascending order numbers and 
        //hashmap which we use to track freq of each numbers

        if (hand.length % groupSize != 0) {
            return false;
        }

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : hand) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : hand) {
            pq.add(num);
        }

        while (!pq.isEmpty()) {
            int min_val = pq.poll();

            //this means we have already visited this 
            if (freq.get(min_val) == 0) {
                continue;
            }

            for (int i = min_val; i < min_val + groupSize; i++) {
                if (!freq.containsKey(i) || freq.get(i) == 0) {
                    return false;
                }

                freq.put(i, freq.get(i) - 1);
            }
        }

        return true;   
    }
}