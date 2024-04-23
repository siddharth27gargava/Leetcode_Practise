class MyStack {

    Deque<Integer> q;

    public MyStack() {
        this.q = new ArrayDeque<>();
    }
    
    public void push(int x) {
        this.q.addLast(x);
    }
    
    public int pop() {
        int qs = this.q.size();
        for (int i = 0; i < qs - 1; i++) {
            this.push(this.q.pollFirst());
        }

        return this.q.pollFirst();

    }
    
    public int top() {
        int qs = this.q.size();
        for (int i = 0; i < qs - 1; i++) {
            this.push(this.q.pollFirst());
        }

        int res = this.q.peekFirst();
        this.push(this.q.pollFirst());

        return res;
    }
    
    public boolean empty() {
        return this.q.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */