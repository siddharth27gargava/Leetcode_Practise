class TrafficLight {

    private int roadAGreen = 1;
    private final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public TrafficLight() {
    }
    
    public void carArrived(
        int carId,           // ID of the car
        int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
        int direction,       // Direction of the car
        Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
        Runnable crossCar    // Use crossCar.run() to make car cross the intersection 
    ) {
        queue.add(carId);
        while(queue.peek() != carId) { 
                
        }
        while (roadAGreen != roadId){
            rwLock.writeLock().lock();
            // try to turn the light to green
            roadAGreen=roadId;
            turnGreen.run();
            // after turn to green then run 
            rwLock.writeLock().unlock();
        } 
        crossCar.run();
        queue.poll();
    }
}