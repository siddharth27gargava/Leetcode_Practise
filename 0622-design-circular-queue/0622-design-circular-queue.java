class MyCircularQueue {
    private int[] queue;
    private int front; // Index of the front element
    private int size; // Current size of the queue
    private int capacity; // Maximum capacity of the queue

    public MyCircularQueue(int k) {
        queue = new int[k];
        capacity = k;
        front = 0;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) { // Check if the queue is full
            return false;
        }
        // Calculate the index where the value will be inserted
        int index = (front + size) % capacity;
        queue[index] = value;
        size++; // Increment the size of the queue
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) { // Check if the queue is empty
            return false;
        }
        front = (front + 1) % capacity; // Move the front pointer to the next element
        size--; // Decrement the size of the queue
        return true;
    }

    public int Front() {
        if (isEmpty()) { // Check if the queue is empty
            return -1;
        }
        return queue[front]; // Return the front element
    }

    public int Rear() {
        if (isEmpty()) { // Check if the queue is empty
            return -1;
        }
        // Calculate the index of the rear element
        int index = (front + size - 1) % capacity;
        return queue[index]; // Return the rear element
    }

    public boolean isEmpty() {
        return size == 0; // Return true if the size is 0
    }

    public boolean isFull() {
        return size == capacity; // Return true if the size is equal to the capacity
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */