class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
    }
    
    final Node head = new Node();
    final Node tail = new Node();
    HashMap<Integer,Node> nodemap;
    int cache_capacity;
    
    

    public LRUCache(int capacity) {
        nodemap = new HashMap<>();
        this.cache_capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public void add(Node node){
        Node head_next = head.next;

        node.next = head_next;
        head_next.prev = node;

        head.next = node;
        node.prev = head;

    }

    public void remove(Node node){
        Node next_node = node.next;
        Node prev_node = node.prev;

        prev_node.next = next_node;
        next_node.prev = prev_node;
    }
    
    public int get(int key) {
        int result = -1;
        Node node = nodemap.get(key);
        if (node!=null){
            remove(node);
            result = node.val;
            add(node);
        }

        return result;
    }
    
    public void put(int key, int value) {
        Node node = nodemap.get(key);
        if (node!=null){
            remove(node);
            node.val = value;
            add(node);
        } else {
            if (nodemap.size() >= cache_capacity){
                nodemap.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node nn = new Node();
            nn.key = key;
            nn.val = value;

            nodemap.put(key,nn);
            add(nn);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */