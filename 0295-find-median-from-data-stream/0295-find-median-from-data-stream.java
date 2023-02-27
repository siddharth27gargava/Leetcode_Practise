class MedianFinder {
    
    Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
    Queue<Integer> minHeap = new PriorityQueue<>();
    int size = 0;
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
         //Add in heap
        size++;

        if (maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.add(num);
        } else{
            minHeap.add(num);
        }

        //Balance
        if (minHeap.size() + 1 < maxHeap.size()){
            int val = maxHeap.poll();
            minHeap.add(val);
        } else if(minHeap.size() > maxHeap.size()){
            int val = minHeap.poll();
            maxHeap.add(val);
        }
    }
    
    public double findMedian() {
        if (size%2 != 0){
            return (double)(maxHeap.peek());
        } else {
            return (double)(minHeap.peek() + maxHeap.peek())/2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */