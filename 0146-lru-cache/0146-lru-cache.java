class LRUCache {
    
    public class Node{
        int key;
        int val;
        Node next;
        Node prev;
    }
    
    final Node head = new Node();
    final Node tail = new Node();
    HashMap<Integer, Node> map;
    int capacity;
    
    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public void remove(Node node){
        Node node_prev = node.prev;
        Node node_next = node.next;
        
        node_prev.next = node_next;
        node_next.prev = node_prev;
    }
    
    public void add(Node node){
        Node head_next = head.next;
        
        node.next = head_next;
        head_next.prev = node;
        
        head.next = node;
        node.prev = head;
    }
    
    public int get(int key) {
        int result = -1;
        
        Node nn = map.get(key);
        
        if(nn!=null){
            remove(nn);
            result = nn.val;
            add(nn);
        }
        
        return result;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        
        if(node!=null){
            remove(node);
            node.val = value;
            add(node);
        } else {
            if(map.size() >= capacity){
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            
            Node nn = new Node();
            nn.key = key;
            nn.val = value;
            add(nn);
            map.put(key,nn);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */