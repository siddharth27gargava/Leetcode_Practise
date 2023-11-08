class KthLargest {
    public PriorityQueue<Integer> pq;
    private final int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        
        for(int m: nums){
            add(m);
        }
    }
    
    public int add(int val) {
        
        pq.add(val);
        
        if(pq.size() > k){
            pq.poll();
        }
        
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */