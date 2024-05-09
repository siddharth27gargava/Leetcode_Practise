class LRUCache {
    public class Node{
        int key;
        int val;
        //double-ended linkedlist
        Node next;
        Node prev;

        public Node(){};

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    HashMap<Integer, Node> map;
    Node head = new Node();
    Node tail = new Node();  
    int capacity = 0;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;

        //connect double-ended linkedlist
        head.next = tail;
        tail.prev = head;
    }

    public void add(Node node){
        Node head_next = head.next;

        //connect node with head_next
        node.next = head_next;
        head_next.prev = node;

        //connect node with head
        head.next = node;
        node.prev = head;
    }

    public void remove(Node node){
        Node node_prev = node.prev;
        Node node_next = node.next;

        node_prev.next = node_next;
        node_next.prev = node_prev;
    }
    
    public int get(int key) {
        int result = -1;

        Node nn = map.get(key);

        if (nn!=null) {
            remove(nn);
            result = nn.val;
            add(nn);
        }

        return result;
    }
    
    public void put(int key, int value) {
        Node nn = map.get(key);

        if (nn != null) {
            remove(nn);
            nn.val = value;
            add(nn);
        } else {
            if(map.size() >= capacity){
                map.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node node = new Node(key,value);
            map.put(key, node);
            add(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */