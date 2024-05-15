class BoundedBlockingQueue {
    private final Semaphore eSemaphore;
    private final Semaphore dSemaphore;
    private final Deque<Integer> q;

    public BoundedBlockingQueue(int capacity) {
        eSemaphore = new Semaphore(capacity);
        dSemaphore = new Semaphore(0);
        q = new ArrayDeque<>();
    }
    
    public void enqueue(int element) throws InterruptedException {
        eSemaphore.acquire();

        synchronized(this){
            q.add(element);
        }

        dSemaphore.release();
    }
    
    public int dequeue() throws InterruptedException {
        int element = 0;
        dSemaphore.acquire();
        synchronized(this){
            element = q.poll();
        }

        eSemaphore.release();
        return element;
    }
    
    public int size() {
        synchronized(this){
            return q.size();
        }
    }
}