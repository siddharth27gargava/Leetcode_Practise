class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int stone : stones){
            pq.add(stone);
        }
        
        while(pq.size() > 1){
            int x = pq.poll();
        int y = pq.poll();
        
        int dif = Math.abs(x - y);
        
        if(dif > 0){
            pq.add(dif);
        }
        }
        
        if(pq.size() == 0){
            return 0;
        }
        return pq.peek();
    }
}